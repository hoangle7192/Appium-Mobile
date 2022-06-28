package appium.com.pageObjects.DragSortDemoAPK;

import appium.com.actions.commons.BasePage;
import appium.com.pageUIs.DragSortDemoAPK.CursorBackedPageUI;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.List;

public class CursorBackedPageObject extends BasePage {

    private final AppiumDriver<MobileElement> driver;

    public CursorBackedPageObject(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public boolean isTextAvailable(String textValue) {
        boolean result = false;
        List<MobileElement> elements = getListMobileElement(driver, CursorBackedPageUI.TEXT_VALUE);
        for (MobileElement element : elements) {
                if (element.getText().equals(textValue)) {
                    result = true;
                    break;
                } else {
                    throw new RuntimeException("This textValue is Unavaiable");
                }
            }
        return result;
    }

    public void dragAndDropSourceToTarget(String sourceIndex, String targetIndex) {
        MobileElement source = getIndexElement(driver, CursorBackedPageUI.DRAG_HANDLE, sourceIndex); // Brad Mehldau
        MobileElement target = getIndexElement(driver, CursorBackedPageUI.DRAG_HANDLE, targetIndex); // Miles Davis
        dragAndDropElement(driver, source, target);
    }

    public void deleteText(String indexValue) {
        waitForElementClickable(driver, CursorBackedPageUI.REMOVE_ICON, indexValue);
        tapByElement(driver, CursorBackedPageUI.REMOVE_ICON, indexValue);
    }

    public boolean isTextUnavailable(String textValue) {
        boolean result = false;
        List<MobileElement> elements = getListMobileElement(driver, CursorBackedPageUI.TEXT_VALUE);
        for (MobileElement element : elements) {
                if (!element.getText().equals(textValue)) {
                    result = true;
                    break;
                } else {
                    throw new RuntimeException("This textValue is still Available");
                }
            }
        return result;
    }
}
