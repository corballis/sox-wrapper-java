package ie.corballis.sox;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArgumentTester {

    @Test
    public void testArguments() throws WrongParametersException {
        Sox sox = new Sox("/usr/local/bin/sox");
        List<String> arguments = sox
                .sampleRate(16000)
                .inputFile("input.wav")
                .outputFile("output.wav")
                .bits(16)
                .encoding(SoXEncoding.SIGNED_INTEGER)
                .effect(SoXEffect.REMIX).argument("1")
                .getArguments();
        List<String> expectedArguments = Arrays.asList(
                "input.wav",
                "output.wav",
                "--bits",
                "16",
                "--encoding",
                "signed-integer",
                "remix",
                "1");
        assertEquals(expectedArguments, arguments);
    }

    @Test(expected = WrongParametersException.class)
    public void testOutputParamHasToFollowInputParam() throws WrongParametersException {
        Sox sox = new Sox("/usr/local/bin/sox");
        sox.outputFile("").inputFile("");
    }
}
