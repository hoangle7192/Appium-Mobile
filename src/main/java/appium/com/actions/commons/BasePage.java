package appium.com.actions.commons;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    public void sleepInSecond(long timeOutInSecond) {
        try {
            Thread.sleep(timeOutInSecond*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sleepInMiLiSecond(long timeOutInMiLiSecond) {
        try {
            Thread.sleep(timeOutInMiLiSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* ------------------------------------------------------------------Mobile Browser------------------------------------------------------------------*/

    public void backToPage(AppiumDriver<MobileElement> driver) {
        driver.navigate().back();
    }

    protected void hideKeyBoard(AppiumDriver<MobileElement> driver) {
        driver.hideKeyboard();
    }

    public Dimension getSizeOfScreen(AppiumDriver<MobileElement> driver) {
        return driver.manage().window().getSize();
    }


    /* ------------------------------------------------------------------Mobile Element------------------------------------------------------------------*/

    private By getLocator(String locatorType) {
        By by;
        if(locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=")) {
            locatorType = locatorType.substring(6);
            by = MobileBy.xpath(locatorType);
        } else if(locatorType.startsWith("name=") || locatorType.startsWith("Name=") || locatorType.startsWith("NAME=")) {
            locatorType = locatorType.substring(5);
            by = MobileBy.name(locatorType);
        } else if(locatorType.startsWith("id=") || locatorType.startsWith("Id=") || locatorType.startsWith("ID=")) {
            locatorType = locatorType.substring(3);
            by = MobileBy.id(locatorType);
        } else if(locatorType.startsWith("className=") || locatorType.startsWith("ClassName=") || locatorType.startsWith("CLASSNAME=")) {
            locatorType = locatorType.substring(10);
            by = MobileBy.className(locatorType);
        } else if(locatorType.startsWith("AccessibilityId=") ) {
            locatorType = locatorType.substring(16);
            by = MobileBy.AccessibilityId(locatorType);
        } else {
            throw new RuntimeException("Locator Type Is Not Support");
        }
        return by;
    }

    protected MobileElement getMobileElement(AppiumDriver<MobileElement> driver, String locatorType) {
        return driver.findElement(getLocator(locatorType));
    }

    protected List<MobileElement> getListMobileElement(AppiumDriver<MobileElement> driver, String locatorType) {
        return driver.findElements(getLocator(locatorType));
    }

    private String getDynamicLocator(String locatorType, String... dynamicValues) {
        if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH")) {
            locatorType = String.format(locatorType, (Object[]) dynamicValues);
        } else if (locatorType.startsWith("id=") || locatorType.startsWith("Id=") || locatorType.startsWith("ID")) {
            locatorType = String.format(locatorType, (Object[]) dynamicValues);
        } else {
            throw new RuntimeException("Locator Type Is Not Xpath Or ID");
        }
        return locatorType;
    }

    protected void tapByElement(AppiumDriver<MobileElement> driver, String locatorType ) {
        getMobileElement(driver, locatorType).click();
    }

    protected void tapByElement(AppiumDriver<MobileElement> driver, String locatorType, String... dynamicValues) {
        getMobileElement(driver, getDynamicLocator(locatorType, dynamicValues)).click();
    }

    protected void tapElement(AppiumDriver<MobileElement> driver, String locatorType) {

    }

    protected MobileElement getIndexElement(AppiumDriver<MobileElement> driver, String locatorType, String index) {
        return getListMobileElement(driver, locatorType).get(Integer.parseInt(index));
    }

    protected String getTextElement(AppiumDriver<MobileElement> driver, String locatorType) {
        return getMobileElement(driver, locatorType).getText();
    }

    protected String getTextElement(AppiumDriver<MobileElement> driver, String locatorType, String... dynamicValues) {
        return getMobileElement(driver, getDynamicLocator(locatorType, dynamicValues)).getText();
    }

    protected String getElementAttributeValue(AppiumDriver<MobileElement> driver, String locatorType, String attributeValue) {
        return getMobileElement(driver, locatorType).getAttribute(attributeValue);
    }

    protected String getElementAttributeValue(AppiumDriver<MobileElement> driver, String locatorType, String attributeValue, String... dynamicValues) {
        return getMobileElement(driver, getDynamicLocator(locatorType, dynamicValues)).getAttribute(attributeValue);
    }

    protected void dragAndDropElement(AppiumDriver<MobileElement> driver, MobileElement elementSource, MobileElement elementTarget) {
        TouchAction action = new TouchAction(driver);
        action.longPress(ElementOption.element(elementSource)).moveTo(ElementOption.element(elementTarget)).release().perform();
    }

    protected boolean isElementSelected(AppiumDriver<MobileElement> driver, String locatorType) {
        return getMobileElement(driver, locatorType).isSelected();
    }

    protected boolean isElementSelected(AppiumDriver<MobileElement> driver, String locatorType, String... dynamicValues) {
        return getMobileElement(driver, getDynamicLocator(locatorType, dynamicValues)).isSelected();
    }

    protected void checkRadioOrCheckbox(AppiumDriver<MobileElement> driver, String locatorType) {
        if(!isElementSelected(driver, locatorType)) {
            getMobileElement(driver, locatorType).click();
        }
    }

    protected void checkRadioOrCheckbox(AppiumDriver<MobileElement> driver, String locatorType, String... dynamicValues) {
        if(!isElementSelected(driver, locatorType, dynamicValues)) {
            getMobileElement(driver, getDynamicLocator(locatorType, dynamicValues)).click();
        }
    }


    /* ------------------------------------------------------------------Wait------------------------------------------------------------------*/
    protected void waitForElementVisible(AppiumDriver<MobileElement> driver, String locatorType) {
        new WebDriverWait(driver, longTimeout).until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorType)));
    }

    protected void waitForElementVisible(AppiumDriver<MobileElement> driver, String locatorType, String... dynamicValues) {
        new WebDriverWait(driver, longTimeout).until(ExpectedConditions.visibilityOfElementLocated(getLocator(getDynamicLocator(locatorType, dynamicValues))));
    }

    protected void waitForAllElementVisible(AppiumDriver<MobileElement> driver, String locatorType) {
        new WebDriverWait(driver, longTimeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getLocator(locatorType)));
    }

    protected void waitForAllElementVisible(AppiumDriver<MobileElement> driver, String locatorType, String... dynamicValues) {
        new WebDriverWait(driver, longTimeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getLocator(getDynamicLocator(locatorType, dynamicValues))));
    }

    protected void waitForElementInvisible(AppiumDriver<MobileElement> driver, String locatorType) {
        new WebDriverWait(driver, longTimeout).until(ExpectedConditions.invisibilityOfElementLocated(getLocator(locatorType)));
    }

    protected void waitForElementInvisible(AppiumDriver<MobileElement> driver, String locatorType, String... dynamicValues) {
        new WebDriverWait(driver, longTimeout).until(ExpectedConditions.invisibilityOfElementLocated(getLocator(getDynamicLocator(locatorType, dynamicValues))));
    }

    protected void waitForAllElementInvisible(AppiumDriver<MobileElement> driver, String locatorType) {
        new WebDriverWait(driver, longTimeout).until(ExpectedConditions.invisibilityOfAllElements((WebElement) getListMobileElement(driver, locatorType)));
    }

    protected void waitForAllElementInvisible(AppiumDriver<MobileElement> driver, String locatorType, String... dynamicValues) {
        new WebDriverWait(driver, longTimeout).until(ExpectedConditions.invisibilityOfAllElements((WebElement) getListMobileElement(driver, getDynamicLocator(locatorType, dynamicValues))));
    }

    protected void waitForElementClickable(AppiumDriver<MobileElement> driver, String locatorType) {
        new WebDriverWait(driver, longTimeout).until(ExpectedConditions.elementToBeClickable(getLocator(locatorType)));
    }

    protected void waitForElementClickable(AppiumDriver<MobileElement> driver, String locatorType, String... dynamicValues) {
        new WebDriverWait(driver, longTimeout).until(ExpectedConditions.elementToBeClickable(getLocator(getDynamicLocator(locatorType, dynamicValues))));
    }

    private long shortTimeout = 5;
    private long longTimeout = 30;


    /* -----------------------------------------------------------------------------------------------------------------------------------------*/

    public void openDynamicPagesAtPageName(AppiumDriver<MobileElement> driver, String pageName) {
        waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_NAME, pageName);
        tapByElement(driver, BasePageUI.DYNAMIC_PAGE_NAME, pageName);
    }


}
