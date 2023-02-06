package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(tags = "@DataTable", features = "C:\\eclipseWorkspace\\Cucumber\\src\\test\\java\\feature\\Login.feature", glue = "\\steps", monochrome = true, dryRun = false, plugin = {
		"pretty", "html:src\\test\\java\\demo.html" })
@RunWith(Cucumber.class)
public class TestRunner {

}
