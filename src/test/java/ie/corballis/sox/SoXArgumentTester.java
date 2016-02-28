package ie.corballis.sox;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SoXArgumentTester {

    @Test
    public void testArguments() throws WrongParametersException {
        SoX soX = new SoX("/usr/local/bin/sox");
        List<String> arguments = soX
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
}
