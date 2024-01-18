package demoappium.PageObjects.ios;

import demoappium.utils.IOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends IOSActions {

    IOSDriver driver;
    public HomePage(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility="Alert Views")
    private WebElement alertView;



    public AlertView clickOnAlertView(){
        alertView.click();
        return new AlertView(driver);

    }







}
