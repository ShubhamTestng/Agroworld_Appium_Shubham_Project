package extentManager;

import java.net.UnknownHostException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter; // Note the change from ExtentSparkReporter to ExtentHtmlReporter
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    public static ExtentHtmlReporter htmlReporter; // Changed to ExtentHtmlReporter
    public static ExtentReports extent; 
    public static ExtentTest test; 

    public static void setup() throws UnknownHostException {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/target/TestExecutionReport.html");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Functional Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); // Adjusted setting for version 3.0.9
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        String hostname = java.net.InetAddress.getLocalHost().getHostName();
        extent.setSystemInfo("Hostname", hostname);

        // Similarly adjust the OS information retrieval and any other system info you deem necessary
        String osName = System.getProperty("os.name");
        extent.setSystemInfo("OS", osName);

        // Setting the tester name
        extent.setSystemInfo("Tester", "Shubham");

        // Additional relevant system information
        extent.setSystemInfo("Appium Version", "2.0"); // Specify your actual Appium version
        extent.setSystemInfo("Platform Name", "Android");
        extent.setSystemInfo("Platform Version", "13"); // Specify the actual platform version
    }

    public static void endReport() {
        extent.flush();
    }
}
