package GenericFunction;

import com.aventstack.extentreports.Status;
import objectRepository.HomePageObjects;
import objectRepository.LeadPage;
import org.openqa.selenium.WebDriver;
import utils.ExtentLogger;
import utils.GenericUtils;

public class LeadFunctions {

    HomePageObjects hp = new HomePageObjects();
    GenericUtils gu = new GenericUtils();
    LeadPage leadPage = new LeadPage();

    public void createLead(WebDriver driver) {

            // ===== Navigate to Lead Creation Page =====
            gu.WebdriverWaitElementTobeClickable(driver, 20, hp.ThreeLines);
            driver.findElement(hp.ThreeLines).click();
            ExtentLogger.pass( "Clicked on Three Lines Menu", driver);
            gu.WebdriverWaitElementTobeClickable(driver, 20, hp.MarketingBtn);
            driver.findElement(hp.MarketingBtn).click();
            ExtentLogger.pass("Clicked on Marketing Button", driver);
            gu.WebdriverWaitElementTobeClickable(driver, 20, hp.LeadButton);
            driver.findElement(hp.LeadButton).click();

            gu.WebdriverWaitElementTobeClickable(driver, 20, leadPage.AddbtnLeadPage);
            driver.findElement(leadPage.AddbtnLeadPage).click();


            // ===== Fill Lead Form =====

            gu.selectByVisibleText(driver, leadPage.salutation, "Mr.");

            driver.findElement(leadPage.firstName).sendKeys("Punit");
            driver.findElement(leadPage.lastName).sendKeys("Ranjan");
            driver.findElement(leadPage.company).sendKeys("ABC Pvt Ltd");

            driver.findElement(leadPage.primaryPhone).sendKeys("9876543210");
            driver.findElement(leadPage.mobilePhone).sendKeys("9123456780");

            driver.findElement(leadPage.designation).sendKeys("QA Engineer");
            driver.findElement(leadPage.fax).sendKeys("123456");

            gu.selectByVisibleText(driver, leadPage.leadSource, "Employee");
            driver.findElement(leadPage.email).sendKeys("punit@test.com");

            gu.selectByVisibleText(driver, leadPage.industry, "Technology");

            driver.findElement(leadPage.website).sendKeys("https://example.com");
            driver.findElement(leadPage.annualRevenue).sendKeys("500000");


            driver.findElement(leadPage.noOfEmployees).sendKeys("100");

            gu.smoothScroll(driver);
            driver.findElement(leadPage.secondaryEmail).sendKeys("punit.secondary@test.com");

            gu.selectByVisibleText(driver, leadPage.assignedTo, "Administrator");

            // Checkbox handling
            if (!driver.findElement(leadPage.emailOptOut).isSelected()) {
                driver.findElement(leadPage.emailOptOut).click();
            }

            // Address Details
            driver.findElement(leadPage.street).sendKeys("Main Road");
            driver.findElement(leadPage.poBox).sendKeys("123");
            driver.findElement(leadPage.postalCode).sendKeys("800001");
            driver.findElement(leadPage.city).sendKeys("Patna");
            driver.findElement(leadPage.state).sendKeys("Bihar");
            driver.findElement(leadPage.country).sendKeys("India");

            // Description
            driver.findElement(leadPage.description)
                    .sendKeys("Lead created using Selenium Automation Framework");

        driver.findElement(leadPage.savebtn).click();


    }
}
