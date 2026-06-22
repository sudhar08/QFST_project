package example;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class browseropen {
	AppiumDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException{
		
		
		File testapp = new File("src/test/resources/Calculator.apk");
		System.out.println(testapp.getAbsolutePath());
		
		UiAutomator2Options options = new UiAutomator2Options(); // initialize the uianimator 

		options.setPlatformName("android"); // set the platform  to the andorid

		options.setAutomationName("UiAutomator2");   // set the automation name 
		options.setApp(testapp.getAbsolutePath());   // set the .apk file path to test the app
		options.noReset();  // it doesn't reset the app
		
		
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");



		// XCUITestOptions options_IOS = new XCUITestOptions(); // initialize the uianimator 

		// options_IOS.setPlatformName("ios"); // set the platform  to the andorid

		// options_IOS.setAutomationName("XCUITest");   // set the automation name 
		// options_IOS.setApp("src/test/resoruces/Calculator.ipa");   // set the .apk file path to test the app
		// options_IOS.noReset();  // it doesn't reset the app





		// ste the url for the appium server
		URL serverurl  =  new URI("http://127.0.0.1:4723").toURL();

		driver = new AndroidDriver(serverurl,options);

	}

	
	@Test
	public void openchome() {
		
		driver.get("https://training-support.net");
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView")).getText(), "Training Support");
		driver.findElement(AppiumBy.accessibilityId("About Us")).click();
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView")).getText(), "About Us");
		
	}

	@AfterClass
	public void teardown(){
		driver.quit();
	}

}
