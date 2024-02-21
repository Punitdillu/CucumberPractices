package utils;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;

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
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\resorces\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String data=prop.getProperty(key);
		return data;
		
	}
}
