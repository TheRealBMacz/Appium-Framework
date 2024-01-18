package demoappium.PageObjects.ios;

import demoappium.utils.IOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AlertView extends IOSActions {
    IOSDriver driver;
    public AlertView(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Text-Entry'`]")
    private WebElement textEntry;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell")
    private WebElement textBox;

    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement acceptPopup;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")
    private WebElement confirmMenuItem;

    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH[c] 'A message'")
    private WebElement confirmMessage;

    @iOSXCUITFindBy(iOSNsPredicate ="label == 'Confirm'")
    private WebElement confirmBtn;

    public void fillTextLabel(String name){
        textEntry.click();
        textBox.sendKeys(name);
        acceptPopup.click();
    }

    public String getConfirmMessage(){
        confirmMenuItem.click();
       return confirmMessage.getText();
    }

}
