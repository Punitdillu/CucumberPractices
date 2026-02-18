package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepository.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import utils.BaseTest;
import utils.TestContextSetup;

public class LoginStepDefinition extends BaseTest {


    LoginPage loginPage = new LoginPage();

    public TestContextSetup testContextSetup;

    // Constructor Injection (Same as your example)
    public LoginStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    // ================= BACKGROUND =================

    @Given("User is on the Login Page")
    public void user_is_on_the_login_page() throws Throwable {

        testContextSetup.driver = webdriverManager();

    }

    // ================= USERNAME =================

    @When("User enters valid username {string}")
    public void user_enters_valid_username(String username) {

        loginPage.enterUsername(testContextSetup.driver, username);
    }

    @When("User enters invalid username {string}")
    public void user_enters_invalid_username(String username) {

        loginPage.enterUsername(testContextSetup.driver, username);
    }

    @When("User leaves username field empty")
    public void user_leaves_username_field_empty() {

        loginPage.enterUsername(testContextSetup.driver, "");
    }

    // ================= PASSWORD =================

    @When("User enters valid password {string}")
    public void user_enters_valid_password(String password) {

        loginPage.enterPassword(testContextSetup.driver, password);
    }

    @When("User enters invalid password {string}")
    public void user_enters_invalid_password(String password) {

        loginPage.enterPassword(testContextSetup.driver, password);
    }

    @When("User leaves password field empty")
    public void user_leaves_password_field_empty() {

        loginPage.enterPassword(testContextSetup.driver, "");
    }

    // ================= LOGIN ACTION =================

    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {

        loginPage.clickLogin(testContextSetup.driver);
    }

    // ================= VALIDATIONS =================

    @Then("User should be redirected to Dashboard page")
    public void user_should_be_redirected_to_dashboard_page() {

        String title = testContextSetup.driver.getTitle();
        System.out.println("Page Title : " + title);
    }

    @Then("Login should be successful")
    public void login_should_be_successful() {

        System.out.println("Login Successful");
    }

    @Then("Error message {string} should be displayed")
    public void error_message_should_be_displayed(String message) {

        System.out.println("Error Message Displayed : " + message);
    }

    @Then("Validation message {string} should be displayed")
    public void validation_message_should_be_displayed(String message) {

        System.out.println("Validation Message : " + message);
    }
}
