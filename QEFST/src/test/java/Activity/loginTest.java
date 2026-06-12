package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class loginTest extends Base {
	@Test
	public void login() {
		
		
		driver.get("http://crm.local:3050/#/Login");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.name("username"))).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("5Nx#I6BK%r3$8vz0ch");
		driver.findElement(By.id("login-button")).click();

		//
		wait.until(ExpectedConditions.urlContains("home"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//iframe"))));

		String dashboardText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab0"))).getText();
		assertTrue(dashboardText.contains("SUITECRM DASHBOARD"));
	}

	@AfterClass
	public void afterClass() {
		// close the browser
		driver.quit();
	}

}
