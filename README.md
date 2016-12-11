# sox-wrapper-java
Java wrapper around the famous [sox](https://sourceforge.net/projects/sox/) audio processing tool.
Please note that the sox executable is not part of this project. This is a wrapper application only that points to the
executable.

Few of the arguments are not implemented yet, but with the help of the `SoX argument(String ...args)` method
any kind of parameter can be added to the parameter list.

Although the constructor of the SoX class requires the user to provide the full path of the sox executable,
it may not be a good idea to hard-code file system paths to java code. Use property files or environment variables instead.

Have a nice coding :)

## How to use

```
<dependency>
    <groupId>ie.corballis</groupId>
    <artifactId>sox-wrapper-java</artifactId>
    <version>xxx</version>
</dependency>
```

## Code Examples

### Simple sox usage
The code below represents the following code in the CLI:
```sox --rate 16000 input.wav --encoding signed-integer --bits 16 output.wav remix 1 ```

```
Sox sox = new Sox("/usr/bin/sox");
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

### Pass unimplemented arguments to the sox

If an argument, you are looking for is not implemented yet, feel free to open an issue, or simply use the
 `SoX argument(String ...args)` method to pass custom arguments to the sox.
```
Sox sox = new Sox("/usr/bin/sox");
        sox.argument("--myargumentKey", "myArgumentValue")
            .inputFile("input.wav")
            .outputFile("output.wav")
            .execute();
    }
```

### Sox with Spring Framework
This is a recommendation, how to integrate the sox java wrapper with the Spring Framework

```
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoXConfiguration {

    @Bean(id="sox" scope="prototype")
    public Sox sox() {
        Sox sox = new Sox("/usr/bin/sox");
        return sox;
    }
```

With the above described Spring configuration class you can inject the sox wrapper anywhere in you Spring project like this:

```@Autowired private SoX sox;``` and the framework will initialize a new wrapper for you.
