package ie.corballis.sox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sox {

    private static Logger logger = LoggerFactory.getLogger(Sox.class);

    private final String soXBinaryPath;

    private List<String> arguments = new ArrayList<String>();

    private boolean globalOptionSet = false;

    private boolean formatOptionSet = false;

    private boolean inputFileSet = false;

    private boolean outputFileSet = false;

    private boolean hasBeenExecuted = false;

    public Sox(String soxPath) {
        this.soXBinaryPath = soxPath;
    }

    public Sox ignoreLength() {
        arguments.add("--ignore-length");
        formatOptionSet = true;
        return this;
    }

    // format options
    public Sox fileType(AudioFileFormat format) {
        arguments.add("--type");
        arguments.add(format.toString());
        return this;
    }

    public Sox encoding(SoXEncoding encoding) {
        arguments.add("--encoding");
        arguments.add(encoding.toString());
        return this;
    }

    public Sox bits(Integer bits) {
        arguments.add("--bits");
        arguments.add(bits.toString());
        return this;
    }

    public Sox reverseNibbles() {
        arguments.add("--reverse-nibbles");
        return this;
    }

    public Sox reverseBits() {
        arguments.add("--reverse-bits");
        return this;
    }

    public Sox sampleRate(Integer sample) {
        arguments.add("--rate");
        arguments.add(sample.toString());
        formatOptionSet = true;
        return this;
    }

// global options
    public Sox verbose(Integer level) {
        arguments.add("-V" + level.toString());
        globalOptionSet = true;
        return this;
    }

    public Sox effect(SoXEffect effect, String ... effectArguments) {
        arguments.add(effect.toString());
        Collections.addAll(arguments, effectArguments);
        return this;
    }

    public Sox argument(String ... arguments) {
        Collections.addAll(this.arguments, arguments);
        return this;
    }

    public Sox inputFile(String inputFile) {
        arguments.add(inputFile);
        inputFileSet = true;
        return this;
    }

    public Sox outputFile(String outputFile) throws WrongParametersException {
        if (!inputFileSet) {
            throw new WrongParametersException("The output file has to be later then an input file");
        }
        arguments.add(outputFile);
        outputFileSet = true;
        return this;
    }

    public void execute() throws IOException, WrongParametersException {
        File soxBinary = new File(soXBinaryPath);
        if (!soxBinary.exists()) {
            throw new FileNotFoundException("Sox binary is not available under the following path: " + soXBinaryPath);
        }

        if (!outputFileSet) {
            throw new WrongParametersException("The output file argument is missing");
        }
        arguments.add(0, soXBinaryPath);
        logger.debug("Sox arguments: {}", arguments);
        ProcessBuilder processBuilder = new ProcessBuilder(arguments);
        processBuilder.redirectErrorStream(true);
        Process process = null;
        IOException errorDuringExecution = null;
        try {
            process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                logger.debug(line);
            }
        } catch (IOException e) {
            errorDuringExecution = e;
            logger.error("Error while running Sox. {}", e.getMessage());
        } finally {
            arguments.clear();
            if (process != null) {
                process.destroy();
            }
            if (errorDuringExecution != null) {
                throw errorDuringExecution;
            }
        }
    }

    public String getSoXBinaryPath() {
        return soXBinaryPath;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }
}
