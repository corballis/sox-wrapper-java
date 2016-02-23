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
                .inputFile("input.wav")
                .outputFile("output.wav")
                .bits(16)
                .encoding(SoXEncoding.SIGNED_INTEGER)
                .bits(16)
                .effect(SoXEffect.REMIX).argument("1")
                .getArguments();
        List<String> expectedArguments = Arrays.asList(
                "input.wav",
                "output.wav",
                "--bits",
                "16",
                "--encoding",
                "signed-integer",
                "--bits",
                "16",
                "remix",
                "1");
        assertEquals(expectedArguments, arguments);
    }

    @Test
    public void testAudioSplitting() throws WrongParametersException, IOException {
        //sox -r 16000 input.wav -e signed-integer -b 16 ouput_left.wav remix 1
        SoX soX = new SoX("/Users/sanyi/Downloads/sox-14.4.2/sox");
        soX.sampleRate(16000).inputFile("/Users/sanyi/projects/soundexchange-java/src/test/resources/one-two-three.wav")
                .encoding(SoXEncoding.SIGNED_INTEGER)
                .bits(16)
                .outputFile("/Users/sanyi/projects/soundexchange-java/src/test/resources/left.wav")
                .effect(SoXEffect.REMIX,"1").execute();
    }
}
