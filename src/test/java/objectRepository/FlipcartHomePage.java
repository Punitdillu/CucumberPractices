package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FlipcartHomePage {

	
	private By SearchBox = By.xpath("//input[@title='Search for Products, Brands and More']");
	public By returnSearchresult(String data) {By SearchResult =By.xpath("//div[text()='"+data+"']");return SearchResult;}
	
	 
	 public void searchForProduct(WebDriver driver,String productName) throws InterruptedException
	 {
		
			driver.findElement(SearchBox).sendKeys(productName);
			driver.findElement(SearchBox).sendKeys(Keys.ENTER);
			Thread.sleep(3000);
	 }
	 
	 public void selectResult(WebDriver driver,String phoneName) throws InterruptedException
	 {
			driver.findElement(returnSearchresult(phoneName)).click();
			Thread.sleep(3000);
	 }
}
