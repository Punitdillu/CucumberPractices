package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GenericUtils;

public class LoginPage {

    GenericUtils genericUtils = new GenericUtils();

    // ================= LOCATORS =================

    private By usernameTxt = By.id("username");

    private By passwordTxt = By.id("password");

    private By signInBtn = By.cssSelector("button[type='submit']");

    private By forgotPasswordLink = By.className("forgotPasswordLink");


    // ================= ACTION METHODS =================

    // Enter Username
    public void enterUsername(WebDriver driver, String username) {

        genericUtils.WebdriverWaitElementTobeVisible(
                driver, 20,
                genericUtils.find_Element(driver, usernameTxt));

        genericUtils.find_Element(driver, usernameTxt).clear();
        genericUtils.find_Element(driver, usernameTxt).sendKeys(username);
    }

    // Enter Password
    public void enterPassword(WebDriver driver, String password) {

        genericUtils.WebdriverWaitElementTobeVisible(
                driver, 20,
                genericUtils.find_Element(driver, passwordTxt));

        genericUtils.find_Element(driver, passwordTxt).clear();
        genericUtils.find_Element(driver, passwordTxt).sendKeys(password);
    }

    // Click Login Button
    public void clickLogin(WebDriver driver) {

        genericUtils.WebdriverWaitElementTobeVisible(
                driver, 20,
                genericUtils.find_Element(driver, signInBtn));

        genericUtils.find_Element(driver, signInBtn).click();
    }

    // Forgot password visibility
    public boolean isForgotPasswordDisplayed(WebDriver driver) {

        return genericUtils
                .find_Element(driver, forgotPasswordLink)
                .isDisplayed();
    }
}