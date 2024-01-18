package demoappium.PageObjects.android;

import demoappium.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AndroidActions{

    AndroidDriver driver;
    public CartPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice" )
    public List<WebElement> productPrices;

    @AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalCartAmount;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement termsAndConditions;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement btnClose;


    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement checkBox;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement btnProceed;

    public double getProductsSum(){
        double cartSum =0;

        for (int i = 0; i < productPrices.size(); i++) {
            double productPrice = getFormattedAmountFromString(productPrices.get(i).getText().trim());
            cartSum = cartSum + productPrice;
        }
        return cartSum;
    }

    public double getCartAmount(){
        return  getFormattedAmountFromString(totalCartAmount.getText().trim());
    }

    public void longPressTermsAndConditions(){
        longPressAction(termsAndConditions);
    }

    public void clickCloseBtn(){
        btnClose.click();
    }

    public void clickCheckBox(){
        checkBox.click();
    }

    public void clickOnProceedBtn() throws InterruptedException {
        btnProceed.click();
        Thread.sleep(6000);
    }

}
