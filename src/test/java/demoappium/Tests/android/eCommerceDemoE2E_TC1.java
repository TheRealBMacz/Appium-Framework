package demoappium.Tests.android;

import demoappium.PageObjects.android.CartPage;
import demoappium.PageObjects.android.ProductCatalogue;
import demoappium.TestUtils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommerceDemoE2E_TC1 extends BaseTest {

    ProductCatalogue productCatalogue;
    CartPage cartPage;
    @Test(groups = {"Smoke"})
    public void addToCart() throws InterruptedException {
       formpage.setNameField("Test User");
       formpage.setGender("female");
       formpage.setCountrySelection("Argentina");
       productCatalogue =  formpage.clickLetsShop();
       productCatalogue.addItemToCartUsingIndex(0);
       productCatalogue.addItemToCartUsingIndex(0);
       cartPage = productCatalogue.clickCartBtn();
       double productsSum = cartPage.getProductsSum();
       double cartSum = cartPage.getCartAmount();
       Assert.assertEquals(productsSum,cartSum);
       cartPage.longPressTermsAndConditions();
       cartPage.clickCloseBtn();
       cartPage.clickCheckBox();
       cartPage.clickOnProceedBtn();
    }

}
