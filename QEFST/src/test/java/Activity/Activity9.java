package Activity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Activity9 extends Base {
	@Test
	public void checking_Leads() {
		driver.get("http://crm.local:3050/#/home");

		WebElement element = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Leads']"))));
		builder.moveToElement(element).perform();

		WebElement viewlead = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='View Leads']"))));
		viewlead.click();

	     WebElement ele = 	wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//scrm-module-title[normalize-space()='LEADS']"))));
	     
	     Assert.assertEquals(ele.getText(), 
	     	 "LEADS");
		
		
		

		List<WebElement> colmunname = driver
				.findElements(By.xpath("//table[contains(@class ,'list-view-table')]//tr/td[3]"));
		List<WebElement> colmunuser = driver
				.findElements(By.xpath("//table[contains(@class ,'list-view-table')]//tr/td[8]"));

		for (WebElement cell : colmunname) {
			System.out.println(cell.getText());
		}

		for (WebElement cell : colmunuser) {
			System.out.println(cell.getText());
		}

	}

	@AfterClass
	public void afterClass() {
		// close the browser
		driver.quit();
	}

}
