package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features = "C:\\Users\\lucas\\Documents\\irts-teste-itau-master\\src\\test\\resources\\features",
        features = "C:\\Users\\lprudencio\\Documents\\teste-itau\\test-itau\\src\\test\\resources\\features",
        glue = "cucumber\\steps",
        tags = "@this",
        plugin = "pretty")
public class Runner {
}
