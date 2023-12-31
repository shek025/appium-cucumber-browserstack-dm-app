package pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * A base class for all the pages within the suite
 */
public abstract class BasePage {
   

    /**
     * The driver
     */
    AndroidDriver<MobileElement> driver;

    protected BasePage(AndroidDriver<MobileElement> driver){
        this.driver = driver;
        // PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(driver, this);
    }
    
    
}