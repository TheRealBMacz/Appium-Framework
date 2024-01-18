package demoappium.PageObjects.android;

import com.google.common.collect.ImmutableMap;
import demoappium.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Formpage extends AndroidActions {

    AndroidDriver driver;
    public Formpage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement userNameField;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
    private WebElement femaleOption;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
    private WebElement maleOption;

    @AndroidFindBy(id = "android:id/text1")
    private WebElement countrySelection;


    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement letsShop;

    public  void setNameField(String name) throws InterruptedException {
        userNameField.sendKeys(name);
        driver.hideKeyboard();
        Thread.sleep(3000);
    }

    public void setGender(String gender){
        if(gender.equalsIgnoreCase("male")){
            maleOption.click();
        }else {
            femaleOption.click();
        }
    }

    public void setCountrySelection(String countryName){
        countrySelection.click();
        scrollToElementText(countryName);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();

    }

    public ProductCatalogue clickLetsShop() throws InterruptedException {
        letsShop.click();
        Thread.sleep(3000);
        return new ProductCatalogue(driver);
    }

    public void startActivityScreen(){
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent",
                "com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
    }




}
