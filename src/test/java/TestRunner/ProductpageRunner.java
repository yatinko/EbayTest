
package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * @author qcc
 */

@CucumberOptions(
		features = "src/test/resources/Features/ProductPage.feature", //the path of the feature files
		glue = {"stepDefinition"},
		//the path of the step definition files
		plugin = {"pretty", 
				"html:target/cucumber-reports/cucumber-pretty.html",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/rerun.txt"},
		monochrome = true,
		dryRun=false
		)
public class ProductpageRunner extends AbstractTestNGCucumberTests {

}
