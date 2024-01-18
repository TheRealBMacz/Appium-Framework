package demoappium.TestUtils;

import demoappium.PageObjects.ios.HomePage;
import demoappium.utils.CommonUtils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Properties;


public class IOSBaseTest extends CommonUtils {
    public IOSDriver driver;
    public AppiumDriverLocalService serviceBuilder;
    public HomePage homePage;
    @BeforeClass
    public void setUp() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"//src/main/java/demoappium/resources/data.properties");
        properties.load(fileInputStream);
        String ipAddress = properties.getProperty("ipAddess");
        int portNumber = Integer.parseInt(properties.getProperty("port"));
        serviceBuilder =  startAppiumServer(ipAddress,portNumber);
        XCUITestOptions xcuiTestOptions = new XCUITestOptions();
        xcuiTestOptions.setDeviceName("iPhone 13 Pro");
        xcuiTestOptions.setPlatformVersion("15.5");
        xcuiTestOptions.setWdaLaunchTimeout(Duration.ofSeconds(20));
        xcuiTestOptions.setApp("PATH FOR IOS APP");
        driver  = new IOSDriver(serviceBuilder.getUrl(),xcuiTestOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
        serviceBuilder.stop();
    }
}
