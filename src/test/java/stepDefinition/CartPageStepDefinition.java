package stepDefinition;

import objectRepository.FlipKartCartPage;
import io.cucumber.java.en.Then;
import utils.TestContextSetup;

public class CartPageStepDefinition  {

	
	FlipKartCartPage fcp = new FlipKartCartPage();
	TestContextSetup testContextSetup;

	public CartPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}
	
	@Then("^Validate product (.+) added in cart or Not$")
	public void validate_product_added_in_cart_or_not(String productName) throws InterruptedException {

		fcp.vfyProductAddedInCart(testContextSetup.driver,productName);
	}
	
	
}
