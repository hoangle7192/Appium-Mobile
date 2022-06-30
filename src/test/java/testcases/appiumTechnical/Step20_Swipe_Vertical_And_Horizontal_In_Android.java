package testcases.appiumTechnical;

import appium.com.actions.commons.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Step20_Swipe_Vertical_And_Horizontal_In_Android extends BaseTest {

    private AppiumDriver<MobileElement> driver;
    static Dimension size;

    @Parameters({"portNumber", "platformName", "platformVersion", "appName"})
    @BeforeClass
    public void beforeClass(String portNumber, String platformName, String platformVersion, String appName) {
        startMultipleSeverAppium(portNumber);
        driver = setUpLocal(platformName, platformVersion, portNumber, appName);
    }

    @Test
    public void TC_01_swipingHorizontal() {
        MobileElement androidSys = driver.findElementByXPath("android.widget.TextView[@text='Android System']");

        MobileElement image = driver.findElementsByName("android.widget.ImageView").get(2);

        TouchAction act = new TouchAction(driver);
        act.longPress(PointOption.point(androidSys.getLocation().getX(), androidSys.getLocation().getY()))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3)))
                .moveTo(PointOption.point(image.getLocation().getX(), image.getLocation().getY()))
                .release()
                .perform();
    }

    @Test
    public void TC_02_Swipe_Vertical() {

    }

    //@Test
    public void TC_03_Swipe_Vertical() {
//Get the size of screen.
        size = driver.manage().window().getSize();
        System.out.println("size: " + size);

        //Find startx point which is at right side of screen.
        int startx = (int) (size.width * 0.70);
        System.out.println("startx; " + startx);

        //Find endx point which is at left side of screen.
        int endx = (int) (size.width * 0.30);
        System.out.println("endx; " + endx);

        //Find vertical point where you wants to swipe. It is in middle of screen height.
        int starty = size.height / 2;
        System.out.println("starty; " + starty);

        //Swipe from Right to Left.
        TouchAction act = new TouchAction(driver);
        act.longPress(PointOption.point(startx, starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3)))
                .moveTo(PointOption.point(endx, starty))
                .release()
                .perform();
    }

    @AfterClass
    public void afterClass() {

    }
}
