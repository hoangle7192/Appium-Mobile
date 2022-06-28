package appium.com.actions.commons;

import java.io.File;

public class GlobalConstants {
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String JAVA_VERSION = System.getProperty("java.version");

    public static final String APP_PATH = PROJECT_PATH + File.separator + "Apps" + File.separator;
    public static final String CALCULATOR_APP_PATH = PROJECT_PATH + File.separator + "Apps" + File.separator + "com.google.android.calculator_v8.2_Android-6.0.apk";
    public static final String SAUCE_DEMO_APP_PATH = PROJECT_PATH + File.separator + "Apps" + File.separator + "MyDemoAppRN.apk";
    public static final String DRAG_SORT_APP_PATH = PROJECT_PATH + File.separator + "Apps" + File.separator + "DragSortDemos.apk";

    public static final String SAUCE_USERNAME = "oauth-anhhuho7777-78638";
    public static final String SAUCE_ACCESS_KEY = "21b2607c-0f13-4dcc-b2a8-cd477cb2888c";
    public static final String SAUCE_URL = "https://" + SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY + "@ondemand.apac-southeast-1.saucelabs.com:443/wd/hub";


    public static final int LONG_TIME_OUT = 30;
    public static final int SHORT_TIME_OUT = 10;
}
