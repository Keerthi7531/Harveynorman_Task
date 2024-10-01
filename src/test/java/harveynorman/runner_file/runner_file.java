package harveynorman.runner_file;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import base_file.Base_Class1;
import data_file.Test_Data1;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\harveynorman\\feature_file", glue = "harveynorman\\step_definition", dryRun = false, publish = true, plugin = {
		"html:target/cucumber-reports/cucumber_report.html", "json:target/cucumber-reports/cucumber_report.json",
		"junit:target/cucumber-reports/cucumber_report.xml" })
public class runner_file extends Base_Class1 {
	@BeforeClass
	public static void start() {
		browser_Launch("chrome");
		driver.get(Test_Data1.url);
	}

	@AfterClass
	public static void end() {
		quit();
	}
}
