package demoappium.Tests.android;

import demoappium.TestUtils.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class eCommerceDemoE2E_TC2 extends BaseTest {
    /*@BeforeMethod
    public void preSetup() throws InterruptedException {
        ////adb shell dumpsys window | find "mCurrentFocus"
        Thread.sleep(5000);
        formpage.startActivityScreen();
    }*/

    @BeforeMethod()
    public void FormScreeNavigation(){
        driver.navigate().back();
    }

    @Test(priority = 0)
    public void validateDetailsRequiredToastMessage() throws InterruptedException {
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String toastMessage = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
        Assert.assertEquals(toastMessage,"Please enter your name");
        Thread.sleep(3000);
    }

    @Test(priority = 1,dataProvider = "getData")
    public void fillForm(HashMap<String,String> dataInput) throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys(dataInput.get("name"));
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='"+dataInput.get("gender")+"']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+dataInput.get("country")+"\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+dataInput.get("country")+"']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(3000);
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        //USING ARRAYS [2 DIMENSIONAL]
       //return new Object[] [] {{"Test User","Female","Argentina"},{"Test User2","Male","Argentina"}};

        //PARSE JSON FILE --> JSON STRING (Commons.io)
        //PARSE JSON STRING ---> HASHMAP (JSON)
        //HASHMAP ---> TEST CASE (TESTNG DATA PROVIDER)
        List<HashMap<String,String>> data = getJSONData(System.getProperty("user.dir") + "//src//main/java//demoappium//TestData//eCommerceTC2.json");
        return new Object[] [] {{data.get(0)},{data.get(1)}};

    }
}
