package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/SearchCar.feature"},
        glue = {"stepDefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-html-report",
                "json:target/cucumber-json-report.json"
        }
)
public class CucumberTestRunner {
}
