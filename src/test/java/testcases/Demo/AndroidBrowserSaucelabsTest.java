package testcases.Demo;

import java.net.MalformedURLException;
import java.net.URL;

import appium.com.actions.commons.GlobalConstants;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Android Browser Sauce Labs Test.
 */
public class AndroidBrowserSaucelabsTest{
    public static final String USERNAME = GlobalConstants.SAUCE_USERNAME;
    public static final String ACCESS_KEY = GlobalConstants.SAUCE_ACCESS_KEY;
    public static final String URL = "https://"+USERNAME+":" + ACCESS_KEY + "@ondemand.apac-southeast-1.saucelabs.com:443/wd/hub";
    public static AndroidDriver<?> mobiledriver;

    @BeforeTest
    public void beforeTest( ) throws MalformedURLException
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S8 Plus FHD GoogleAPI Emulator");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.22.1");
        capabilities.setCapability("newCommandTimeout", 2000);
        mobiledriver = new AndroidDriver<>(new URL(URL), capabilities);
    }

    @AfterTest
    public void afterTest( )
    {
        mobiledriver.quit();
    }

    @Test
    public static void launchBrowser(){
        mobiledriver.get("http://appium.io/");
        Assert.assertEquals(mobiledriver.getCurrentUrl(), "http://appium.io/", "URL Mismatch");
        Assert.assertEquals(mobiledriver.getTitle(), "Appium: Mobile App Automation Made Awesome.", "Title Mismatch");
    }
}
