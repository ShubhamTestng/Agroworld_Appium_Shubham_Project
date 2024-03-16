package Resources;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class iOSApp {

    public static String userName = "systango-bs-2"; 
    public static String accessKey = "J5IofJfeaSEQE3cxdRb3BvrfqAieD5GdqrubiO6uyulqet2MpT"; 

    public String gridURL = "https://systango-bs-2:J5IofJfeaSEQE3cxdRb3BvrfqAieD5GdqrubiO6uyulqet2MpT@mobile-hub.lambdatest.com/wd/hub";

    String DeviceValue;
    String versionValue;
    String PlatformValue;
    public AppiumDriver driver;


    @Test
    public void iOSApp() throws MalformedURLException {
        

            DesiredCapabilities capabilities = new DesiredCapabilities();
            //capabilities.setCapability("build","ParallelSample iOS");
           // capabilities.setCapability("name",platform+" "+device+" "+version);
            capabilities.setCapability("deviceName", "iPhone 11");
            capabilities.setCapability("platformVersion","14");
            capabilities.setCapability("platformName", "IOS");
            capabilities.setCapability("isRealMobile", true);
            //AppURL (Create from proverbial.ipa sample in project)
            capabilities.setCapability("app", "lt://APP1016026231710392174202217");
            capabilities.setCapability("deviceOrientation", "PORTRAIT");
            capabilities.setCapability("console", true);
            capabilities.setCapability("network", true);
            capabilities.setCapability("visual", true);
            capabilities.setCapability("devicelog", true);
            //capabilities.setCapability("geoLocation", "HK");

            String hub = gridURL;
            driver = new AppiumDriver(new URL(hub), capabilities);

       

             
        }
}
