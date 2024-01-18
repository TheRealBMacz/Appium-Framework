package demoappium.TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

public class ExtentReporterNG {

    //EXTENT SPARK REPORTER , EXTENT REPORT
    static ExtentReports extentReports;
    public static ExtentReports getExtentReportObject(){
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\index.html");
        extentSparkReporter.config().setReportName("TEST REPORT");
        extentSparkReporter.config().setDocumentTitle("TEST RESULTS");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("TEST", "TESTER 1");
        return  extentReports;
    }
}
