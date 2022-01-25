package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/features/TestScenarios.Feature" } , 
				 /*format = {"pretty", "html:target/cucumber"}, */
				 glue = "stepDefinitions", dryRun = false, monochrome = true,
				 plugin = { "pretty","html:target/cucumber"},
				 tags =("@BBCHomepage,@DateandDay,@NewsSection,@SearchResults"))

public class TestRunner extends AbstractTestNGCucumberTests {
	
}
