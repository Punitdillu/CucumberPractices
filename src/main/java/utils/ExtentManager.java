package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import static utils.GenericUtils.getCurrentDateTime;
import static utils.ScreenshotUtil.activeReportPath;

public class ExtentManager {

    public static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();


    public static ExtentReports getReportInstance() {

        if (activeReportPath == null) {
            // This MUST match the folder created by your extent.properties
            activeReportPath = "test-output/SparkReport_" + getCurrentDateTime();
            //activeReportPath = "test-output/SparkReport" ;
        }

        if (extent == null) {

            String path = System.getProperty("user.dir")+ "/" + activeReportPath +"/Spark.html";

            ExtentSparkReporter spark = new ExtentSparkReporter(path);
            spark.config().setReportName("Automation Report");
            spark.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }


        return extent;
    }

    public static ExtentTest getTest() {

        return extentTest.get();

    }

    public static void setTest(ExtentTest test) {
        extentTest.set(test);
    }


}