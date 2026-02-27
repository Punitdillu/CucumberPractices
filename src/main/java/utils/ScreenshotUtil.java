package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static utils.GenericUtils.getCurrentDateTime;

public class ScreenshotUtil {

    public static byte[] capture(WebDriver driver) {
        return ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
    }
    public static String activeReportPath;
    public static String captureScreenshot(WebDriver driver, String fileName) {

        if (activeReportPath == null) {
            // This MUST match the folder created by your extent.properties
            activeReportPath = "test-output/SparkReport_" + getCurrentDateTime();
            //activeReportPath = "test-output/SparkReport_";
        }

        // Path: test-output/SparkReport {Timestamp}/screenshots/
        String screenshotDir = System.getProperty("user.dir") + "/" + activeReportPath + "/screenshots/";



        File dir = new File(screenshotDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        String fullPath = screenshotDir + fileName + ".png";

        try {
            FileUtils.copyFile(src, new File(fullPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ⭐ IMPORTANT FIX
        return "screenshots/" + fileName + ".png";
    }


}
