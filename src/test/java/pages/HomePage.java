package pages;


import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


/**
 * Home page
 */
public class HomePage extends BasePage {

   
    public void downloadPaper() {
    	    	 	
    	// String nxt = "Next ❯";
    	
    	String archive = "Tap me to open the archive";
    	String reader = "Tap me to get out of the reader";
    	String menu = "Tap me to open the settings menu";
      	    	
    	// close paper   	
    	
    	/*
    	 * Closing the open page and signing out
    	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\""+archive+"\"]")).click();
    	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\""+reader+"\"]/android.view.ViewGroup")).click();    	
    	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\""+menu+"\"]/android.widget.TextView")).click();
    	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")).click();
    	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.widget.TextView")).click();
    	*/ 	    	 	
    }


    public HomePage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }
    
    public void scrollHorizontal() {
    	// scroll horizontal
    	new TouchAction((PerformsTouchActions)driver)
    	.press(PointOption.point(650,850))
    	.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
    	.moveTo(PointOption.point(50 ,850))
    	.release()
    	.perform();
    }
    public void openRecentMoreIssues (String seeMoreText) {
    	String text = "Recent issues"; 
    	
    	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))").click();
    	
    	// Locate SEE MORE Option by scrolling horizontal
    	scrollHorizontal();
    	scrollHorizontal();

    	// click see more
    	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+seeMoreText+"\").instance(0))").click();

    	
    }
    
    public void closeFailOver() {
    	// failOver.click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")).click();
    }
    
    public void downLoadNewsPaper() {
    	// click download
    	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup")).click();
    }
    
    public void signIn() {
    	String signIn = "Sign in";
    	// click sign in
    	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+signIn+"\").instance(0))").click();
    	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText")).clear();
    	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText")).sendKeys("twilightsp2708@gmail.com");
    	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[4]/android.widget.EditText")).sendKeys("National123!");
    	driver.findElement(By.className("android.widget.Button")).click();
    	System.out.println("User SignedIn successfully...");
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    public void verifyNewsPaperDownload() {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Assert.assertTrue(driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Tap me to open the sections menu\"]/android.view.ViewGroup/android.view.ViewGroup")).isEnabled());
    	System.out.println("News paper downloaded successfully...");
    }
    
    public void userOnNewsPaper() {
    	String you = "YOU";
    	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+you+"\").instance(0))").click();
    }
    
    public void openPageByNumber(String no) {
    	MobileElement pageNoElement = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView"));
    	
    	while( ! pageNoElement.getText().contains(no)) {
    		new TouchAction((PerformsTouchActions)driver)
        	.press(PointOption.point(650,850))
        	.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
        	.moveTo(PointOption.point(50 ,850))
        	.release()
        	.perform();  		
    	}    	
    	// Open 13th page
    	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout")).click();
    }
    
    public void openImage() {
    	// Open Image
    	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[4]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[2]")).click();
    }
    
    public void TraverseThroughImages() {
    	
    	MobileElement noOfPhotosElement = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView"));
    	System.out.println("Displaying "+ noOfPhotosElement.getText() + " photos");

    	new TouchAction((PerformsTouchActions)driver)
    	.press(PointOption.point(600,600))
    	.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
    	.moveTo(PointOption.point(100 ,600))
    	.release()
    	.perform(); 	
    	System.out.println("Displaying "+ noOfPhotosElement.getText() + " photos");    	
    }
    
    public void closeImage() {
    	// close the photo
    	System.out.println("Closing photos...");
    	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView")).click();
    }
    
    public void closeApp() {
    	// Close app
    	driver.closeApp();
    	
    }

}
