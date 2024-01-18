package demoappium.PageObjects.android;

import demoappium.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AndroidActions {

    AndroidDriver driver;
    public ProductCatalogue(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    public List<WebElement> addToCart;


     @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
     private WebElement btnCart;


    public void addItemToCartUsingIndex(int index){
        addToCart.get(index).click();

    }

    public CartPage clickCartBtn() throws InterruptedException {
        btnCart.click();
        Thread.sleep(3000);
        return  new CartPage(driver);
    }


}
