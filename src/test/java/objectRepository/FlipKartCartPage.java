package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestContextSetup;

public class FlipKartCartPage  {


	public By ProductInCart(String data) {By ProductInCart =By.xpath("//*[text()='"+data+"']");return ProductInCart;}

	 public void vfyProductAddedInCart(WebDriver driver,String searchedProduct) throws InterruptedException
	 {
		 Thread.sleep(6000);
		 if (driver.findElement(ProductInCart(searchedProduct)).isDisplayed()) {
				System.out.println("Product Added to cart");
			} 
			else 
			{
				System.out.println("product is not added");
			}
			driver.close();
			Thread.sleep(3000);

			//driver.switchTo().window(TestContextSetup.parentwindow);
			}
}
