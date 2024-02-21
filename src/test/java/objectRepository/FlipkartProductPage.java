package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlipkartProductPage  {


	private By AddToCartBtn = By.xpath("(//li[contains(@class,'col col')])[1]");
	 
	 public void addToCart(WebDriver driver)
	 {
		 driver.findElement(AddToCartBtn).click();
	 }
}
