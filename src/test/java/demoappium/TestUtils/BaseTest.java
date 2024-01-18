package demoappium.TestUtils;

import demoappium.PageObjects.android.Formpage;
import demoappium.utils.CommonUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest  extends CommonUtils {
    public AndroidDriver driver;
    public AppiumDriverLocalService serviceBuilder;

   public Formpage formpage;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"//src/main/java/demoappium/resources/data.properties");
        properties.load(fileInputStream);
        //ADDING CODE TO CHECK AND UTILIZE PARAMETER "IP ADDRESS"
        //FROM THE MAVEN COMMAND USING -D
        //COMMAND --- mvn test -PSmoke -DipAddress=213.24.322
        String ipAddress = System.getProperty("ipAddress")!= null ?
                System.getProperty("ipAddress") :  properties.getProperty("ipAddress");
       // String ipAddress = properties.getProperty("ipAddress");
        int portNumber = Integer.parseInt(properties.getProperty("portNum"));
        String deviceName = properties.getProperty("AndroidDeviceName");
        serviceBuilder =  startAppiumServer(ipAddress,portNumber);
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setDeviceName(deviceName); //EMULATOR
        // uiAutomator2Options.setDeviceName("Android Phone"); -- REAL ANDROID PHONE
        uiAutomator2Options.setChromedriverExecutable("C:\\PROJECTS WORKSPACE\\Appium\\src\\test\\java\\resources\\chromedriver.exe");
        //uiAutomator2Options.setApp("C:\\PROJECTS WORKSPACE\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
        uiAutomator2Options.setApp("C:\\PROJECTS WORKSPACE\\Appium-Framework-Design\\src\\test\\java\\demoappium\\resources\\General-Store.apk");
        driver  = new AndroidDriver(serviceBuilder.getUrl(),uiAutomator2Options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        formpage = new Formpage(driver);
    }


    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
        serviceBuilder.stop();
    }
}
