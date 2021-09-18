package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target/cucumber-reports.html"},
        features="src/test/resources/features",
        glue="stepdefinitions",
        tags="@Vue",
        dryRun=false
)
public class TestRunner {

}
