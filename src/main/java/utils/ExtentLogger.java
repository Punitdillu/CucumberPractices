package utils;

import com.aventstack.extentreports.*;
import org.openqa.selenium.WebDriver;
import utils.ScreenshotUtil;

public class ExtentLogger {

    private static ExtentTest getTest() {

        return ExtentManager.getTest();

    }

    public static void pass(String message, WebDriver driver) {
        attachLog(Status.PASS, message, driver);
    }

    public static void fail(String message, WebDriver driver) {
        attachLog(Status.FAIL, message, driver);
    }

    public static void info(String message) {
        getTest().log(Status.INFO, message);
    }

    private static void attachLog(Status status,
                                  String message,
                                  WebDriver driver) {

        try {

            String path = ScreenshotUtil.captureScreenshot(
                    driver,
                    String.valueOf(System.currentTimeMillis()));

            getTest().log(
                    status,
                    message,
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(path)
                            .build());

        } catch (Exception e) {
            getTest().log(Status.FAIL, "Logging Error: " + e.getMessage());
        }
    }

    public static void warning(String s, WebDriver driver) {

    }
}