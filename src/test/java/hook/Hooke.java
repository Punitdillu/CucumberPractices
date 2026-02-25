package hook;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ExtentLogger;
import utils.ExtentManager;
import utils.TestContextSetup;

public class Hooke {

	public TestContextSetup testContextSetup;

	public Hooke(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	@Before
	public void setup(Scenario scenario) {

		ExtentTest test =
				ExtentManager
						.getReportInstance()
						.createTest(scenario.getName());

		ExtentManager.setTest(test);
	}

	@After
	public void tearDown(Scenario scenario) {

		WebDriver driver = testContextSetup.driver;

		if (scenario.isFailed()) {

			ExtentLogger.fail(
					"Scenario Failed : " + scenario.getName(),
					driver);

		} else {

			ExtentLogger.pass(
					"Scenario Passed : " + scenario.getName(),
					driver);
		}

		// ⭐ MOST IMPORTANT LINE
		ExtentManager.getReportInstance().flush();
		if (driver != null) {
			driver.quit();
		}
	}
}