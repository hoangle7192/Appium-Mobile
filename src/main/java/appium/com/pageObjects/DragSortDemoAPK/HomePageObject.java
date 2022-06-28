package appium.com.pageObjects.DragSortDemoAPK;

import appium.com.actions.commons.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomePageObject extends BasePage {
    private AppiumDriver<MobileElement> driver;

    public HomePageObject(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
}
