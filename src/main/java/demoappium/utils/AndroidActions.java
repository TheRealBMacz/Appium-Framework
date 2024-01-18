package demoappium.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class AndroidActions extends CommonUtils{

    AndroidDriver driver;

    public AndroidActions(AndroidDriver driver){
        this.driver = driver;
    }

    public void startActivity(String activityName){
        driver.executeScript("mobile:startActivity",ImmutableMap.of("intent",activityName));

    }

    //LONG PRESS ACTION
    public void longPressAction(WebElement element){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)element).getId(),"duration",2000));
    }

    //SCROLL TO END OF SCREEN
    public void scrollToEndOfScreen(){
        boolean canScrollMore;
        do{
            canScrollMore   = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        }while (canScrollMore);
    }

    //SWIPE ACTION
    public void swipeAction(WebElement element, String direction){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)element).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }

    public void scrollToElementText(String text){
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
    }


}
