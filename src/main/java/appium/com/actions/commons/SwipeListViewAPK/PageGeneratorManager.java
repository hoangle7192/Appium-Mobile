package appium.com.actions.commons.SwipeListViewAPK;

import appium.com.pageObjects.SwipeListViewAPK.ListViewPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageGeneratorManager {

    public static ListViewPageObject getListViewPage(AppiumDriver<MobileElement> driver) {
        return new ListViewPageObject(driver);
    }
}
