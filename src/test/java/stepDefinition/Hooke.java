package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooke {

	
public TestContextSetup testContextSetup;
	
	public Hooke(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}
	@After
	public void closetheBrowser()
	{
		testContextSetup.driver.quit();
	}
	
	@AfterStep
	public void AttachScreenShot(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
		File file = ((TakesScreenshot) testContextSetup.driver).getScreenshotAs(OutputType.FILE);
		byte[] filecontent = FileUtils.readFileToByteArray(file);
		scenario.attach(filecontent, "image/png", "image");
		}
	}
}
