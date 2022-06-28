package appium.com.reportConfig;

import appium.com.actions.commons.GlobalConstants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(GlobalConstants.PROJECT_PATH + "/extentReportV5/ExtentReport.html");
        reporter.config().setReportName("Sauce Labs Demo App");
        reporter.config().setDocumentTitle("Sauce Labs Demo App");
        reporter.config().setTimelineEnabled(true);
        reporter.config().setEncoding("utf-8");
        reporter.config().setTheme(Theme.DARK);

        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Company", "FreeLancer");
        extentReports.setSystemInfo("Project", "Appium Technical");
        extentReports.setSystemInfo("Team", "Single");
        extentReports.setSystemInfo("Author", "HoangLH");
        extentReports.setSystemInfo("JDK version", GlobalConstants.JAVA_VERSION);
        return extentReports;
    }
}
