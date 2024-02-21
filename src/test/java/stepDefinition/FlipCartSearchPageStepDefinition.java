package stepDefinition;

import objectRepository.FlipcartHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.BaseTest;
import utils.TestContextSetup;

public class FlipCartSearchPageStepDefinition extends BaseTest{
	
	FlipcartHomePage fHome = new FlipcartHomePage();

	public TestContextSetup testContextSetup;

	public FlipCartSearchPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		
	}

	@Given("User is on Flipkart landing page")
	public void UserisonFlipkartlandingpage() throws Throwable {

		testContextSetup.driver = webdriverManager();
		//testContextSetup.parentwindow = gu.handleCurrentWindow();

	}

	@When("^User search with shortName (.+) and extract actual name of product$")
	public void user_search_with_short_name_and_extract_actual_name_of_product(String producName)
			throws InterruptedException {

		fHome.searchForProduct(testContextSetup.driver,producName);
		fHome.selectResult(testContextSetup.driver,producName);
	}


	
}
