package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class Activity_3 extends Base {
	// @BeforeTest
	// public void setup(){
        
    // }
	
	@Test
	public void pickCopyrights() {
	driver.get("http://crm.local:3050/#/Login");

	String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-target='.copyright-suitecrm']"))).getText();
	System.out.println(message);
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
