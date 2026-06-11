package Activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Activity_3 extends Base {
	@BeforeTest
	public void setup(){
        driver.get("http://crm.local:3050/#/Login");
    }
	
	@Test
	public void pickCopyrights() {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-target='.copyright-suitecrm']"))).getText();
	System.out.println(message);
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
