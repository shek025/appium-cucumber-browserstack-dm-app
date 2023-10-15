package stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.screenrecording.CanRecordScreen;
import pages.HomePage;
import io.appium.java_client.MobileElement;

public class steps {

	AndroidDriver<MobileElement> driver;
	Scenario scenario;
	
	HomePage homePage;
		
	@Before
	public void initiazeDriver( ) {
		this.driver = DriverFactory.createAndroidDriverInstance();
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.startRecordingScreen();
		homePage = new HomePage(driver); 
	}
	@Given("User launched Mail+ application")
	public void launchApp() {
		homePage.closeFailOver();
		this.takeScreenShot("launchApp");
		System.out.println("Application launched successfully.");
		recorder();
	}
	
	
	@When("On Newspaper tab, scroll down to Recent issues and scroll right and tap on {string} button")
	public void openRecentIssue(String seeMore) {
		System.out.println("Opening Recent issues and clicking SEE MORE..");
		homePage.openRecentMoreIssues(seeMore);
		this.takeScreenShot("SEE-MORE");

	}
	
	@When("On Archive tab, tap to download Sept {string} edition")
	public void download(String string) {
		homePage.downLoadNewsPaper();
		this.takeScreenShot("StartDownload");
	    
	}
	

	@When("On the paywall carousel, sign with credential provided")
	public void on_the_paywall_carousel_sign_with_credential_provided() {
		takeScreenShot("Before SignIn");
		System.out.println("User Signing in...");
		homePage.signIn();
		takeScreenShot("After SignIn");
	}

	@Then("Wait for the edition to download completed")
	public void verifyDownload() {
		homePage.verifyNewsPaperDownload();
		this.takeScreenShot("AfterDownload");	    
	}
	
	@Given("User is On the downloaded Sept {int} edition")
	public void user_is_On_the_downloaded_Sept_edition(Integer int1) {
		this.launchApp();
		this.openRecentIssue("SEE MORE");
		this.download("27");
		this.verifyDownload();
		homePage.userOnNewsPaper();
		this.takeScreenShot("NewsPaperOpened");
	}

	@When("Navigate to Page {string} on PDF view that displays {string} story \\(Page {int})")
	public void navigate_to_Page_on_PDF_view_that_displays_story_Page(String no, String string, Integer int2) {
		homePage.openPageByNumber(no);
		this.takeScreenShot("GoToStoryPage");

	}

	@When("Tap on the Image Gallery is displayed on top of the page")
	public void tap_on_the_Image_Gallery_is_displayed_on_top_of_the_page() {
		homePage.openImage();
		this.takeScreenShot("ImageGallery");

	}

	@When("Now tap on camera icon to open full screen and traverse through all gallery images")
	public void now_tap_on_camera_icon_to_open_full_screen_and_traverse_through_all_gallery_images() {
		homePage.TraverseThroughImages();
		this.takeScreenShot("NavigateGallery");

	}

	@Then("On last image close the image by clicking on Close button to return to ALB \\(Article Light Box)")
	public void on_last_image_close_the_image_by_clicking_on_Close_button_to_return_to_ALB_Article_Light_Box() {
		homePage.closeImage();
		homePage.closeApp();
		this.takeScreenShot("CloseGallery");

	}
	
	public void takeScreenShot(String name) {
		//Set folder name to store screenshots.
		String destDir = "target/cucumber-reports/screenshots";
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        try {
				FileUtils.copyFile(screenshot, new File("target/cucumber-reports/screenshots/"+name+ ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
	}
	
	public void attachScreenshot(Scenario scenario) {
		
		try {
	        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	        scenario.embed(screenshot, "image/png");
	      } catch (WebDriverException wde) {
	        System.err.println(wde.getMessage());
	      } catch (ClassCastException cce) {
	        cce.printStackTrace();
	      }
	}

	
	public void recorder() {
		
		driver.startRecordingScreen(new AndroidStartScreenRecordingOptions() {
	        @Override
	        public AndroidStartScreenRecordingOptions withTimeLimit(Duration timeLimit) {
	            return super.withTimeLimit(Duration.ofMinutes(5)).withVideoSize("720x1280").withBitRate(2000000);
	        }
	    });
	}
	/*
	@AfterClass
	public void tearDown(Scenario scenario) {
		
		if (scenario.isFailed()) {
		      attachScreenshot(scenario);
		    }
		if (driver != null) {
			driver.quit();
		}
	}
	*/
	
}