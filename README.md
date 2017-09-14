# Sox wrapper for java
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
  <artifactId>sox-java</artifactId>
  <version>1.0.4</version>
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

### Don't find your favorite sox argument implemented yet?

If an argument, you are looking for is not implemented yet, feel free to open an issue, but don't worry.
You do not need to wait for a new version. you can always use the following "universal" method for such a cases:
 `SoX argument(String ...args)`
The above mentioned method accepts any kind of custom arguments and passes it straight to the sox.

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
import ie.corballis.sox.Sox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SoxConfiguration {

    @Bean(name = "soxFactory")
    public SoxFactory soxFactory() {
        return new SoxFactory("<sox-binary-full-path>");
    }
}

```

With the above described Spring configuration class you can inject the sox wrapper anywhere in you Spring project like this:

```
@Autowired private SoXFactory soxFactory; 

...

// My lovely sox command 
soxFactory.getInstance().inputFile('myFile').outputFile('outputFile').execute();
```

## Does the order of the arguments matter?
Yes, it does. However, this java wrapper allows you any kind of order of the sox parameters, it does not check sox'
syntax, the wrapper will pass the arguments to sox in the same order as you provided them in the java code.
The wrapper checks only one syntax: You have to provide your output parameter later than your input parameter.
If you break this rule, then you will get a `WrongParameterException` checked exception.