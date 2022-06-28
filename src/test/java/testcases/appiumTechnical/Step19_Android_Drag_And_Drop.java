package testcases.appiumTechnical;

import appium.com.actions.commons.BaseTest;
import appium.com.actions.commons.DragSortDemoAPK.PageGeneratorManager;
import appium.com.pageObjects.DragSortDemoAPK.BasicUsagePageObject;
import appium.com.pageObjects.DragSortDemoAPK.CursorBackedPageObject;
import appium.com.pageObjects.DragSortDemoAPK.HeteroHeightPageObject;
import appium.com.pageObjects.DragSortDemoAPK.HomePageObject;
import appium.com.reportConfig.ExtentTestManager;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Step19_Android_Drag_And_Drop extends BaseTest {

    private AppiumDriver<MobileElement> driver;
    private HomePageObject homePage;
    private BasicUsagePageObject basicUsagePage;
    private HeteroHeightPageObject heteroHeightPage;
    private CursorBackedPageObject cursorBackedPage;

    @Parameters({"portNumber", "platformName", "platformVersion", "appName"})
    @BeforeClass
    public void beforeClass(String portNumber, String platformName, String platformVersion, String appName) {
        startMultipleSeverAppium(portNumber);
        driver = setUpLocal(platformName, platformVersion, portNumber, appName);
        homePage = PageGeneratorManager.getHomePage(driver);

    }

    @Test
    public void TC_01_Basic_Usage(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_01_Basic_Usage");

        ExtentTestManager.getTest().log(Status.INFO, "Step01: Open \"Basic usage playground\" Page");
        homePage.openDynamicPagesAtPageName(driver, "Basic usage playground");
        basicUsagePage = PageGeneratorManager.getBasicUsagePage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Step02: Drag and drop \"Chick Corea\" move to \"Miles Davis\"");
        basicUsagePage.dragAndDropSourceToTarget("2", "4");
        basicUsagePage.sleepInMiLiSecond(5);

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Back to HomePage");
        homePage = basicUsagePage.backToHomePage();
    }

    //@Test
    public void TC_02_Hetero_Height(Method method)  {
        ExtentTestManager.startTest(method.getName(), "TC_02_Hetero_Height");

        ExtentTestManager.getTest().log(Status.INFO, "Step01: Open \"Heteroheight\" Page");
        homePage.openDynamicPagesAtPageName(driver, "Heteroheight");
        heteroHeightPage = PageGeneratorManager.getHeteroHeightPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Step02: Drag and drop \"Kurt Rosenwinkel\" move to \"Herbie Hancock\"");
        heteroHeightPage.dragAndDropSourceToTarget("3", "7");
        heteroHeightPage.sleepInMiLiSecond(5);

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Back to HomePage");
        homePage = heteroHeightPage.backToHomePage();
    }

    //@Test
    public void TC_03_Cursor_Backed(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_03_Cursor_Backed");

        ExtentTestManager.getTest().log(Status.INFO, "Step01: Open \"Cursor_Backed\" Page");
        homePage.openDynamicPagesAtPageName(driver, "CursorAdapter");
        cursorBackedPage = PageGeneratorManager.getCursorBackedPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Step02: Confirm text \"Brad Mehldau\" is available");
        Assert.assertTrue(cursorBackedPage.isTextAvailable("Brad Mehldau"));

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Drag and drop \"Brad Mehldau\" move to \"Miles Davis\"");
        cursorBackedPage.dragAndDropSourceToTarget("0", "4");
        cursorBackedPage.sleepInMiLiSecond(5);

        ExtentTestManager.getTest().log(Status.INFO, "Step04: Delete text \"Brad Mehldau\" ");
        cursorBackedPage.deleteText("4");

        ExtentTestManager.getTest().log(Status.INFO, "Step05: Confirm text \"Brad Mehldau\" is Unavailable");
        Assert.assertTrue(cursorBackedPage.isTextUnavailable("Brad Mehldau"));

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeApp();
    }
}
