package example;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Baseclass {
	AppiumDriver driver;
	WebDriverWait wait;
	UiAutomator2Options options = new UiAutomator2Options();
	
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		
		File testapp = new File("src/test/resources/Calculator.apk");
		
		options.setPlatformName("android"); // set the platform  to the andorid

		options.setAutomationName("UiAutomator2");   // set the automation name 
		options.setApp(testapp.getAbsolutePath());   // set the .apk file path to test the app
		options.noReset();
		
		URL serverurl  =  new URI("http://127.0.0.1:4723").toURL();

		driver = new AndroidDriver(serverurl,options);

	}
	

	
	
	@AfterClass
	public void teardown(){
		driver.quit();
	}
	
}
