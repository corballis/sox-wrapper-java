# sox-wrapper-java
Java wrapper around the famous SOX (https://sourceforge.net/projects/sox/) audio processing command line tool.
The majority of the arguments are not implemented yet, but

The project does not include the binary of the sox itself;

## Code Examples

A simple example of how to re-sample a stereo audio file and extract it's left channel into a new file.
```
SoX sox = new SoX("/usr/bin/sox");
        sox
            .sampleRate(16000)
            .inputFile("input.wav")
            .encoding(SoXEncoding.SIGNED_INTEGER)
            .bits(16)
            .outputFile("output.wav")
            .effect(SoXEffect.REMIX,"1")
            .execute();
    }
```

If an argument, you are looking for is not implemented yet, feel free to open an issue, or simply use the
 `SoX argument(String ...args)` method to pass custom arguments to the sox.
```
SoX sox = new SoX("/usr/bin/sox");
        sox.argument("--myargumentKey", "myArgumentValue")
            .inputFile("input.wav")
            .outputFile("output.wav")
            .execute();
    }
```

Use the sox wrapper with the Spring Framework
```

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoXConfiguration {

    @Bean(id="sox" scope="prototype")
    public SoX sox() {
        SoX sox = new SoX("/usr/bin/sox");
        return sox;
    }
```

With the above described Spring configuration class you can inject the sox wrapper anywhere in you Spring project like this:

```@Autowired private SoX sox;``` and the framework will initialize a new wrapper for you.
