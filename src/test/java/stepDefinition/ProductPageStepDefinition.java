package stepDefinition;

import objectRepository.FlipkartProductPage;
import io.cucumber.java.en.Then;
import utils.GenericUtils;
import utils.TestContextSetup;

public class ProductPageStepDefinition  {
	
	FlipkartProductPage fp = new FlipkartProductPage();
	GenericUtils gu = new GenericUtils();

	public TestContextSetup testContextSetup;

	public ProductPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	
	@Then("Add product in cart")
	public void add_product_in_cart() {

		// add product in cart
		gu.switchTowindow(testContextSetup.driver);
		fp.addToCart(testContextSetup.driver);
	}

	
	
	
	

	
}
