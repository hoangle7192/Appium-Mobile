package testcases.Demo;

import appium.com.actions.commons.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import lombok.SneakyThrows;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Coordinates;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo extends BaseTest {
    public AppiumDriver<MobileElement> driver;

    @Parameters({"portNumber", "platformName", "platformVersion", "appName"})
    @BeforeClass
    public void beforeClass(String portNumber, String platformName, String platformVersion, String appName) {
        startMultipleSeverAppium(portNumber);
        driver = setUpLocal(platformName, platformVersion, portNumber, appName);
    }

    @SneakyThrows
    @Test
    public void TC_01_Click() {
        MobileElement element01 = driver.findElementByXPath("//android.widget.TextView[@text='Basic usage playground']");
        
        Coordinates coordinates = element01.getCoordinates();
        System.out.println("coordinates: " + coordinates);

        Point location = element01.getLocation();
        System.out.println("location: " + location);




        /*element01.click();
        Thread.sleep(5);
        driver.navigate().back();
        System.out.println("Xong click");*/

        MobileElement element02 = driver.findElementByXPath("//android.widget.TextView[@text='Basic usage playground']");
        TouchAction act = new TouchAction(driver);
        act.tap(PointOption.point(0,220)).release();
        //act.tap(ElementOption.element(element02)).release();
        Thread.sleep(5);
        System.out.println("Xong tap");
    }


    @AfterClass
    public void afterClass() {
        closeApp();
    }

}
