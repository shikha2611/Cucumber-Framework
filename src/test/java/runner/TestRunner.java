package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
     	features = "C:\\eclipseWorkspaceNew\\CucumberSFDC\\src\\test\\java\\feature\\Login.feature", 
		glue = "\\steps", 
//		tags = "@DataTable", 
		monochrome = true,
		dryRun = false, 
		plugin = {"pretty", "html:src\\test\\java\\demo.html" })

@RunWith(Cucumber.class)
public class TestRunner {

}
