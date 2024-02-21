package stepDefinition;

import objectRepository.FlipcartHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.BaseTest;
import utils.GenericUtils;
import utils.TestContextSetup;

public class ProductSearchPage extends BaseTest{
	
	FlipcartHomePage fHome = new FlipcartHomePage();
	GenericUtils gu = new GenericUtils();

	public TestContextSetup testContextSetup;

	public ProductSearchPage(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Given("User navigated to Flipkart landing page")
	public void user_navigated_to_flipkart_landing_page() throws Throwable {
		testContextSetup.driver = webdriverManager();
	}

	@When("^User search with ProductName (.+) and extract actual name of product$")
	public void user_search_with_product_name_apple_i_phone_blue_gb_and_extract_actual_name_of_product(String producName) throws InterruptedException {
		fHome.searchForProduct(testContextSetup.driver,producName);
		fHome.selectResult(testContextSetup.driver, producName);
	}

}
