package Activity;

import org.openqa.selenium.By;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	assertEquals(message,"© Supercharged by SuiteCRM");
	}
	
	// @AfterTest
	// public void teardown() {
	// 	driver.quit();
	// }

}
