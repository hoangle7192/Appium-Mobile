package appium.com.pageObjects.SwipeListViewAPK;

import appium.com.actions.commons.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ListViewPageObject extends BasePage {

    private final AppiumDriver<MobileElement> driver;

    public ListViewPageObject(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
}
