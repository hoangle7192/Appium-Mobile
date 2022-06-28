package testcases.appiumTechnical;

import appium.com.actions.commons.BaseTest;
import appium.com.actions.commons.SwipeListViewAPK.PageGeneratorManager;
import appium.com.pageObjects.SwipeListViewAPK.ListViewPageObject;
import appium.com.reportConfig.ExtentTestManager;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.lang.reflect.Method;

public class Step20_Swipe_Vertical_And_Horizontal_In_Android extends BaseTest {

    private AppiumDriver<MobileElement> driver;
    private ListViewPageObject listViewPage;
    private static Dimension sizeOfScreen;

    @Parameters({"portNumber", "platformName", "platformVersion", "appName"})
    @BeforeClass
    public void beforeClass(String portNumber, String platformName, String platformVersion, String appName) {
        startMultipleSeverAppium(portNumber);
        driver = setUpLocal(platformName, platformVersion, portNumber, appName);
        listViewPage = PageGeneratorManager.getListViewPage(driver);
    }

    @Test
    public void TC_01_Swipe_Horizontal(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_01_Swipe_Horizontal");

        ExtentTestManager.getTest().log(Status.INFO, "Step01: Get Size Of Screen");
        sizeOfScreen = listViewPage.getSizeOfScreen(driver);
        System.out.println("sizeOfScreen " + sizeOfScreen);


    }

    @Test
    public void TC_02_Swipe_Vertical() {

    }

    @AfterClass
    public void afterClass() {

    }
}
