package testcases.Demo;

import appium.com.actions.commons.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CalculatorDemoLocal extends BaseTest {

    public AppiumDriver<MobileElement> driver;

    @Parameters({"portNumber", "platformName", "platformVersion", "appName"})
    @BeforeClass
    public void beforeClass(String portNumber, String platformName, String platformVersion, String appName) {
        startMultipleSeverAppium(portNumber);
        driver = setUpLocal(platformName, platformVersion, portNumber, appName);
    }

    @Test
    public void TC_01() {
        MobileElement two = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        two.click();
        MobileElement plus = driver.findElementByAccessibilityId("multiply");
        plus.click();
        MobileElement three = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
        three.click();
        MobileElement equals = driver.findElement(By.id("com.google.android.calculator:id/eq"));
        equals.click();
        MobileElement result = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        System.out.println("Result TC_01: " + result.getText());
        Assert.assertEquals(result.getText(), "6");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeApp();
    }
}
