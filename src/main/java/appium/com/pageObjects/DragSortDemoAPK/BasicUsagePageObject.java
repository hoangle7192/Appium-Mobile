package appium.com.pageObjects.DragSortDemoAPK;

import appium.com.actions.commons.BasePage;
import appium.com.actions.commons.DragSortDemoAPK.PageGeneratorManager;
import appium.com.pageUIs.DragSortDemoAPK.BasicUsagePageUI;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BasicUsagePageObject extends BasePage {

    private final AppiumDriver<MobileElement> driver;

    public BasicUsagePageObject(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void dragAndDropSourceToTarget(String sourceIndex, String targetIndex) {
        MobileElement source = getIndexElement(driver, BasicUsagePageUI.DRAG_HANDLE, sourceIndex); // Chick Corea
        MobileElement target = getIndexElement(driver, BasicUsagePageUI.DRAG_HANDLE, targetIndex); // Miles Davis
        dragAndDropElement(driver, source, target);
    }

    public HomePageObject backToHomePage() {
        backToPage(driver);
        return PageGeneratorManager.getHomePage(driver);
    }

}
