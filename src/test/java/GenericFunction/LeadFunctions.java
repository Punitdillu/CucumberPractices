package GenericFunction;

import objectRepository.HomePageObjects;
import objectRepository.LeadPage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import utils.ExtentLogger;
import utils.GenericUtils;
import java.util.Map; // Added for data-driven map

public class LeadFunctions {

        HomePageObjects hp = new HomePageObjects();
        GenericUtils gu = new GenericUtils();
        LeadPage leadPage = new LeadPage();

        /**
         * @param testData A map containing column headers as keys and excel cell values as values
         */

        public void createLead(WebDriver driver, Map<String, String> testData) {

                // ===== Navigate to Lead Creation Page =====
                gu.WebdriverWaitElementTobeClickable(driver, 20, hp.ThreeLines);
                driver.findElement(hp.ThreeLines).click();
                ExtentLogger.pass("Clicked on Three Lines Menu", driver);

                gu.WebdriverWaitElementTobeClickable(driver, 20, hp.MarketingBtn);
                driver.findElement(hp.MarketingBtn).click();
                ExtentLogger.pass("Clicked on Marketing Button", driver);

                gu.WebdriverWaitElementTobeClickable(driver, 20, hp.LeadButton);
                driver.findElement(hp.LeadButton).click();

                gu.WebdriverWaitElementTobeClickable(driver, 20, leadPage.AddbtnLeadPage);
                driver.findElement(leadPage.AddbtnLeadPage).click();

                // ===== Fill Lead Form Using Excel Data =====

                // Use testData.get("ColumnHeader") to fetch values
                gu.selectByVisibleText(driver, leadPage.salutation, testData.get("Salutation"));

                driver.findElement(leadPage.firstName).sendKeys(testData.get("FirstName"));
                driver.findElement(leadPage.lastName).sendKeys(testData.get("LastName"));
                driver.findElement(leadPage.company).sendKeys(testData.get("Company"));

                driver.findElement(leadPage.primaryPhone).sendKeys(testData.get("PrimaryPhone"));
                driver.findElement(leadPage.mobilePhone).sendKeys(testData.get("MobilePhone"));
                // Checkbox handling
//                if (!driver.findElement(leadPage.emailOptOut).isSelected()) {
//                        driver.findElement(leadPage.emailOptOut).click();
//                }
                driver.findElement(leadPage.designation).sendKeys(testData.get("Designation"));

                gu.selectByVisibleText(driver, leadPage.leadSource, "Employee"); // Can also be moved to Excel
                driver.findElement(leadPage.email).sendKeys(testData.get("Email"));

                gu.selectByVisibleText(driver, leadPage.industry, testData.get("Industry"));

                // City and other address details from Excel
                driver.findElement(leadPage.city).sendKeys(testData.get("City"));



                driver.findElement(leadPage.savebtn).click();
                ExtentLogger.pass("Lead created successfully for: " + testData.get("FirstName"), driver);
        }
}