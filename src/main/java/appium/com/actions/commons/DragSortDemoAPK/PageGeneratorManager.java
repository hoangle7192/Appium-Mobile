package appium.com.actions.commons.DragSortDemoAPK;

import appium.com.pageObjects.DragSortDemoAPK.BasicUsagePageObject;
import appium.com.pageObjects.DragSortDemoAPK.CursorBackedPageObject;
import appium.com.pageObjects.DragSortDemoAPK.HeteroHeightPageObject;
import appium.com.pageObjects.DragSortDemoAPK.HomePageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageGeneratorManager {

    public static HomePageObject getHomePage(AppiumDriver<MobileElement> driver) {
        return new HomePageObject(driver);
    }

    public static BasicUsagePageObject getBasicUsagePage(AppiumDriver<MobileElement> driver) {
        return new BasicUsagePageObject(driver);
    }

    public static HeteroHeightPageObject getHeteroHeightPage(AppiumDriver<MobileElement> driver) {
        return new HeteroHeightPageObject(driver);
    }

    public static CursorBackedPageObject getCursorBackedPage(AppiumDriver<MobileElement> driver) {
        return new CursorBackedPageObject(driver);
    }
}
