package appium.com.pageObjects.DragSortDemoAPK;

import appium.com.actions.commons.BasePage;
import appium.com.actions.commons.DragSortDemoAPK.PageGeneratorManager;
import appium.com.pageUIs.DragSortDemoAPK.HeteroHeightPageUI;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HeteroHeightPageObject extends BasePage {

    private final AppiumDriver<MobileElement> driver;

    public HeteroHeightPageObject(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void dragAndDropSourceToTarget(String sourceIndex, String targetIndex) {
        MobileElement source = getIndexElement(driver, HeteroHeightPageUI.DRAG_HANDLE, sourceIndex); // Kurt Rosenwinkel
        MobileElement target = getIndexElement(driver, HeteroHeightPageUI.DRAG_HANDLE, targetIndex); // erbie Hancock
        dragAndDropElement(driver, source, target);
    }

    public HomePageObject backToHomePage() {
        backToPage(driver);
        return PageGeneratorManager.getHomePage(driver);
    }
}
