package cucumberOption;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"stepDefinition"},
		monochrome = true,
		tags = "@PositiveLogin or @InvalidPassword or @InvalidUsername or @EmptyCredentials or @EmptyPassword " +
				"or @EmptyUsername",
		plugin = {
				"html:target/cucumber.html",
				"json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed_scenarios.txt"
		}
)
public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel=false)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
}
