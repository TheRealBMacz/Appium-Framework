package demoappium.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class CommonUtils {

   public AppiumDriverLocalService serviceBuilder;


    //COMPONENT TO CONVERT JSON FILE --> JSON STRING --> LIST OF HASH MAPS
    public List<HashMap<String,String>> getJSONData(String jsonFilePath) throws IOException {
        String jsonFileContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
        ObjectMapper objectMapper = new ObjectMapper();
        List<HashMap<String, String>> jsonData = objectMapper.readValue(jsonFileContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return jsonData;
    }

    public AppiumDriverLocalService startAppiumServer(String ipAddress, int portNumber){
        serviceBuilder = new AppiumServiceBuilder().withAppiumJS(new File(System.getProperty("user.home")+"\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress(ipAddress).usingPort(portNumber).build();
        serviceBuilder.start();
        return serviceBuilder;
    }

    //GET FORMATTED AMOUNT FROM STRING
    public double getFormattedAmountFromString(String amount){
        return   Double.parseDouble(amount.trim().substring(1));
    }

    //WAIT FOR ELEMENT TO BE DISPLAYED
    public void waitForElementToBeDisplayed(AndroidDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    public String getScreenshotAs(String testCaseName,AppiumDriver driver) throws IOException {
       File sourceFile = driver.getScreenshotAs(OutputType.FILE);
       String screenshotPath =System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
       File destinationFile = new File(screenshotPath );
       FileUtils.copyFile(sourceFile,destinationFile);
       return screenshotPath;
    }
}
