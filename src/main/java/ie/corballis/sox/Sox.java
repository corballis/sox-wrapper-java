package ie.corballis.sox;

import java.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SoX {

    private static Logger logger = LoggerFactory.getLogger(SoX.class);

    private final String soXBinaryPath;

    private List<String> arguments = new ArrayList<String>();

    private boolean globalOptionSet = false;

    private boolean formatOptionSet = false;

    private boolean inputFileSet = false;

    private boolean outputFileSet = false;

    private boolean hasBeenExecuted = false;

    public SoX(String soxPath) {
        this.soXBinaryPath = soxPath;
    }

    public SoX ignoreLength() {
        arguments.add("--ignore-length");
        formatOptionSet = true;
        return this;
    }

    // format options
    public SoX fileType(AudioFileFormat format) {
        arguments.add("--type");
        arguments.add(format.toString());
        return this;
    }

    public SoX encoding(SoXEncoding encoding) {
        arguments.add("--encoding");
        arguments.add(encoding.toString());
        return this;
    }

    public SoX bits(Integer bits) {
        arguments.add("--bits");
        arguments.add(bits.toString());
        return this;
    }

    public SoX reverseNibbles() {
        arguments.add("--reverse-nibbles");
        return this;
    }

    public SoX reverseBits() {
        arguments.add("--reverse-bits");
        return this;
    }

    public SoX sampleRate(Integer sample) {
        arguments.add("--rate");
        arguments.add(sample.toString());
        formatOptionSet = true;
        return this;
    }

// global options
    public SoX verbose(Integer level) {
        arguments.add("-V" + level.toString());
        globalOptionSet = true;
        return this;
    }

    public SoX effect(SoXEffect effect, String ... effectArguments) {
        arguments.add(effect.toString());
        for (String effectArgument : effectArguments) {
            arguments.add(effectArgument);
        }
        return this;
    }

    public SoX argument(String ... arguments) {
        Collections.addAll(this.arguments, arguments);
        return this;
    }

    public SoX inputFile(String inputFile) {
        arguments.add(inputFile);
        return this;
    }

    public SoX outputFile(String outputFile) throws WrongParametersException {
        if (inputFileSet) {
            throw new WrongParametersException("The output file has to be later then an input file");
        }
        arguments.add(outputFile);
        outputFileSet = true;
        return this;
    }

    public void execute() throws IOException, WrongParametersException, AlreadyExecutedException {
        if (hasBeenExecuted) {
            throw new AlreadyExecutedException("The execute() method cannot be called twice");
        }
        File soxBinary = new File(soXBinaryPath);
        if (!soxBinary.exists()) {
            throw new FileNotFoundException("SoX binary is not available under the following path: " + soXBinaryPath);
        }

        if (!outputFileSet) {
            throw new WrongParametersException("The output file argument is missing");
        }
        arguments.add(0, soXBinaryPath);
        logger.debug("SoX arguments: {}", arguments);
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
            logger.error("Error while running SoX. {}", e.getMessage());
        } finally {
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
