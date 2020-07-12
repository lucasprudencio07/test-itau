package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\lucas\\Documents\\irts-teste-itau-master\\src\\test\\resources\\features",
        glue = "cucumber\\steps", // the package to get the steps to be executed
        plugin = "pretty")
public class Runner {
}
