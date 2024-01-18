package demoappium.Tests.ios;

import demoappium.PageObjects.ios.AlertView;
import demoappium.TestUtils.IOSBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSBasics_TC_1 extends IOSBaseTest {

    @Test
    public void IOSBasicsTest(){

        AlertView alertView = homePage.clickOnAlertView();
        alertView.fillTextLabel("Hello World");
       String alertMessage = alertView.getConfirmMessage();
        Assert.assertEquals(alertMessage,"A message should be short, complete sentence");

    }
}
