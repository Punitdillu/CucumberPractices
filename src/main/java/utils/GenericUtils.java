package utils;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

	public WebElement WebdriverWaitElementTobeClickable(WebDriver driver, int time, By by )
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.elementToBeClickable(find_Element(driver, by)));
	}

	public WebElement WebdriverWaitElementTobeVisible(WebDriver driver, int time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void selectByVisibleText(WebDriver driver, By locator, String text) {
		Select select = new Select(driver.findElement(locator));
		select.selectByVisibleText(text);
	}

	public void scrollUp(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}

	public void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)");
	}

	public void scrollToTop(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0)");
	}

	public void scrollToBottom(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void smoothScroll(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy({top:600, behavior:'smooth'});");
	}

	public void scrollUntilElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static String getCurrentDateTime() {
		// Matches the pattern: d-MMM-YYYY HH-mm-ss
		return new java.text.SimpleDateFormat("d-MMM-yyyy HH-mm-ss").format(new java.util.Date());
	}

}
