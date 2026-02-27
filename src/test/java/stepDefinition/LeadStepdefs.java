package stepDefinition;

import GenericFunction.LeadFunctions;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepository.LoginPage;
import utils.BaseTest;
import utils.ExcelSheetUtils;
import utils.ExtentLogger;
import utils.TestContextSetup;

import java.util.Map;

public class LeadStepdefs extends BaseTest {

    public TestContextSetup testContextSetup;
    LoginPage loginPage = new LoginPage();
    ExcelSheetUtils gu = new ExcelSheetUtils();
    LeadFunctions leadFunctions = new LeadFunctions();
    public LeadStepdefs(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
    }



    @Given("User is on the Lead Creation Page")
    public void userIsOnTheLeadCreationPage() throws Throwable {
        testContextSetup.driver = webdriverManager();
        System.out.println("User is on the Lead Creation Page");

    }

    @When("User enters valid username {string} password {string} and logs in")
    public void user_enters_valid_username_password_and_logs_in(String username, String password) {
        ExtentLogger.info("Opening login page");
        loginPage.enterUsername(testContextSetup.driver, username);
        loginPage.enterPassword(testContextSetup.driver, password);
        loginPage.clickLogin(testContextSetup.driver);
        ExtentLogger.pass("Login page opened successfully", testContextSetup.driver);
    }

    @When("User enters valid lead details from excel {string}")
    public void userEntersValidLeadDetailsFromExcel(String testID) throws Exception {
        ExtentLogger.info("User Is at lead page");
        // 1. Fetch the Key-Value Map from Excel
        Map<String, String> excelData = gu.getRowData(System.getProperty("user.dir")+"/src/test/resources/testData/TestData.xlsx", "Leads", testID);

        leadFunctions.createLead(testContextSetup.driver, excelData);
        ExtentLogger.pass("Lead Created successfully"  , testContextSetup.driver);
    }

    @And("User clicks on Save button")
    public void userClicksOnSaveButton() {

    }

    @Then("Lead should be created successfully")
    public void leadShouldBeCreatedSuccessfully() {

    }

    @And("Confirmation message {string} should be displayed")
    public void confirmationMessageShouldBeDisplayed(String arg0) {

    }



}
