package appium.com.actions.commons;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private AppiumDriver<MobileElement> driver;

    protected void startMultipleSeverAppium(String portNumber) {
        try {
            AppiumDriverLocalService service = new AppiumServiceBuilder().usingPort(Integer.parseInt(portNumber)).build();
            service.start();
        } catch (AppiumServerHasNotBeenStartedLocallyException e) {
            e.printStackTrace();
        }
    }

    protected void getMobileDriver(String envName, String platformName, String platformVersion, String portNumber, String appName) {

    }

    protected AppiumDriver<MobileElement> setUpLocal(String platformName, String platformVersion, String portNumber, String appName) {
        try {
            MutableCapabilities caps = new MutableCapabilities();
            //DesiredCapabilities cap = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
            caps.setCapability("autoAcceptAlerts", false);
            caps.setCapability("noReset", "true");
            caps.setCapability(MobileCapabilityType.APP, GlobalConstants.APP_PATH + appName);
            //caps.setCapability("appPackage", "com.saucelabs.mydemoapp.rn");
            //caps.setCapability("appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");

            URL url = new URL("http://127.0.0.1:" + portNumber + "/wd/hub");
            driver = new AppiumDriver<>(url, caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    /*public AppiumDriver<MobileElement> setUpSauceLabs(String platformName, String deviceName, String platformVersion) {
        try {
            MutableCapabilities caps = new MutableCapabilities();
            caps.setCapability("platformName", platformName);
            caps.setCapability("appium:deviceName", deviceName);
            caps.setCapability("appium:deviceOrientation", "portrait");
            caps.setCapability("appium:platformVersion", platformVersion);
            caps.setCapability("appium:app", "http://appium.s3.amazonaws.com/ApiDemos-debug-2015-03-19.apk");
            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("appiumVersion", "1.22.1");
            sauceOptions.setCapability("build", "Demo Appium");
            sauceOptions.setCapability("name", "Tester: HoangLH");
            caps.setCapability("sauce:options", sauceOptions);

            URL url = new URL(GlobalConstants.SAUCE_URL);
            driver = new AppiumDriver<>(url, caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }*/

    public AppiumDriver<MobileElement> getDriverInstance() {
        return this.driver;
    }

    protected void closeApp() {
        //driver.closeApp();
    }

}
