package utils;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	
	GenericUtils gu = new GenericUtils();
	public  WebDriver driver = null;
	
	public WebDriver webdriverManager() throws Throwable {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String browser_Properties=gu.returnDataFromPropertyFile("browser");
		String url=gu.returnDataFromPropertyFile("url");
		String browser_Maven=System.getProperty("browser");
		
		String browser=browser_Maven!=null ? browser_Maven:browser_Properties;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--window-size=1920,1080"); // Force a large resolution
		options.addArguments("--start-maximized");
		if (driver == null) {
		if(browser.equalsIgnoreCase("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\eclipse-workspace\\CucumberAutomationLearning\\src\\test\\resources\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			DriverFactory.setDriver(driver);
		     
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			DriverFactory.setDriver(driver);
		}
		
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			DriverFactory.setDriver(driver);
		}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);

		return driver;
	}
	
	
}
