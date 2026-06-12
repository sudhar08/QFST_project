package Activity;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class Activity2 extends Base {

//get the url
	@Test
	public void getCurrenturl() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		driver.get("http://crm.local:3050/#/Login");
		
		WebElement element = driver.findElement(
				By.xpath("/html/body/app-root/div/scrm-login-ui/div/form/div[1]/div/scrm-logo-ui/scrm-image/img"));

		String value = element.getAttribute("src");

		System.out.println("SRC Value : " + value);
		// Assert statements
		assertEquals(value, "http://crm.local:3050/legacy/themes/default/images/company_logo.png");

	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}
