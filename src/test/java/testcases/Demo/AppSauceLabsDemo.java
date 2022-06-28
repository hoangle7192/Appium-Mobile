package testcases.Demo;

import appium.com.actions.commons.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppSauceLabsDemo extends BaseTest {
    public AppiumDriver<MobileElement> driver;

    @BeforeClass
    public void beforeClass() {

    }

    @Test
    public void TC_01() {

    }

    @AfterClass
    public void afterClass() {
        closeApp();
    }

}
