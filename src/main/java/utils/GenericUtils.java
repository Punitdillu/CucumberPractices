package utils;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils  {


	public void switchTowindow(WebDriver driver) {

		Set<String> windowidset = driver.getWindowHandles();
		Iterator<String> windoid = windowidset.iterator();
		
		while (windoid.hasNext()) {
			String currentwindow = windoid.next();
			driver.switchTo().window(currentwindow);
			if (driver.getTitle().contains(currentwindow))
				break;

		}
	}
	
	public String handleCurrentWindow(WebDriver driver) {

		
	 return driver.getWindowHandle();

	}
	
	
	public String returnDataFromPropertyFile(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String data=prop.getProperty(key);
		return data;
		
	}

	public WebElement find_Element(WebDriver driver, By by)
	{
		WebElement element = driver.findElement(by);
		return element;
	}

	public WebElement WebdriverWaitElementTobeClickable(WebDriver driver, int time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement WebdriverWaitElementTobeVisible(WebDriver driver, int time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}


}
