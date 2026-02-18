package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.GenericUtils;

public class FlipcartHomePage {

	GenericUtils genericUtils = new GenericUtils();
	private By SearchBox = By.xpath("//input[@title='Search for Products, Brands and More']");
	public By returnSearchresult(String data) {By SearchResult =By.xpath("//div[text()='"+data+"']");return SearchResult;}
	
	 /*public void loginToFlipkart(WebDriver driver,String Username,String Password)
	 {

	 }*/
	 public void searchForProduct(WebDriver driver,String productName) throws InterruptedException
	 {
			genericUtils.WebdriverWaitElementTobeVisible(driver,20,genericUtils.find_Element(driver,SearchBox));
		    genericUtils.find_Element(driver,SearchBox).sendKeys(productName);
		    genericUtils.find_Element(driver,SearchBox).sendKeys(Keys.ENTER);
			Thread.sleep(3000);
	 }
	 
	 public void selectResult(WebDriver driver,String phoneName) throws InterruptedException
	 {
		    genericUtils.WebdriverWaitElementTobeVisible(driver,20,genericUtils.find_Element(driver,returnSearchresult(phoneName)));
			driver.findElement(returnSearchresult(phoneName)).click();
			Thread.sleep(3000);
	 }
}
