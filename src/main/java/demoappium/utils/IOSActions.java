package demoappium.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class IOSActions extends CommonUtils{

    IOSDriver driver;

    public IOSActions(IOSDriver driver){
        this.driver = driver;
    }

    //IOS Long Press Action
    public void IOSLongPressAction(WebElement element){
        Map<String, Object> param = new HashMap<>();
        param.put("element",((RemoteWebElement)element).getId());
        param.put("duration",5);
        driver.executeScript("mobile:touchAndHold",param);
    }

    //IOS Scroll Press Action
    public void IOSScrollAction(WebElement element){
        Map<String, Object> param = new HashMap<>();
        param.put("element",((RemoteWebElement)element).getId());
        param.put("direction","down");
        driver.executeScript("mobile:scroll",param);
    }

    //IOS Swipe Test
    public void IOSSwipeTest(){
        Map<String, Object> param2 = new HashMap<>();
        param2.put("direction","left");
        //BY DEFAULT SWIPE EVENT SWIPES ON CENTER OF THE SCREEN
        driver.executeScript("mobile:swipe",param2);
    }

}
