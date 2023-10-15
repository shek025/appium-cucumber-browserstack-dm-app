package framework;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class DriverFactory {
    
	protected static final Logger LOG = LoggerFactory.getLogger(DriverFactory.class);
    
	public static AndroidDriver<MobileElement> createAndroidDriverInstance() {

    	 AndroidDriver<MobileElement> driver = null;

        try {

        	// DesiredCapabilities caps = new DesiredCapabilities();
            
        	URL url = null;
        	/*
            String platformName = System.getProperty("platformName");
            String appPackage = System.getProperty("appPackage");
            String appActivity = System.getProperty("appActivity");
            String udid = System.getProperty("udid");
            String browserstackUserID = System.getProperty("browserstackUserID");
            String browserstackKey = System.getProperty("browserstackKey");
            String browserstackAppID = System.getProperty("browserstackAppID");
            String browserstackDevice = System.getProperty("browserstackDevice");
            String browserstackOS = System.getProperty("browserstackOS");
            String executionMode = System.getProperty("executionMode");
            
            */
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:platformVersion", "13");
            caps.setCapability("appium:deviceName", "emulator-5554");
            caps.setCapability("appium:app", "C:\\Users\\shek0\\Downloads\\8.2.2.20(744802).apk");
            caps.setCapability("appium:noReset", true);
            caps.setCapability("appium:ensureWebviewsHavePages", true);
            caps.setCapability("appium:nativeWebScreenshot", true);
            caps.setCapability("appium:newCommandTimeout", 3600);
            caps.setCapability("appium:connectHardwareKeyboard", true);
            
            url = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver<MobileElement>(url, caps);
    	    /*
            switch (executionMode) {
                case "Local":
                	url = new URL(System.getProperty("appiumUrl"));
                	caps.setCapability(MobileCapabilityType.UDID,udid);
          		    caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
          		    caps.setCapability("appPackage",appPackage);
          	        caps.setCapability("appActivity",appActivity);
          	        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
          	    
          		    driver = new AndroidDriver<MobileElement>(url, caps);
                    break;
                    
                case "Remote":
                	  url = new URL(System.getProperty("browserstackUrl"));
                	  caps.setCapability("browserstack.user", browserstackUserID);
            	      caps.setCapability("browserstack.key", browserstackKey);
            	      caps.setCapability("app", browserstackAppID);
            	      caps.setCapability("device", browserstackDevice);
            	      caps.setCapability("os_version", browserstackOS);

                      driver = new AndroidDriver<MobileElement>(url, caps);
                      break;

                default:
                     LOG.info("Execution Mode must be provided");
            }
            */
               driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
               LOG.info( "Android Driver Creation Completed");
               
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return driver;
    }
}