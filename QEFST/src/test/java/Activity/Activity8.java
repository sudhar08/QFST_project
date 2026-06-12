package Activity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Activity8 extends Base {
	@SuppressWarnings("null")
	@Test(priority = 1)
	public void importAccountsTest() {

		driver.get("http://crm.local:3050/#/home");

		// Accounts and View Accounts elements
		WebElement accounts = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span[text()='Accounts']]")));
		// Actions
		builder.moveToElement(accounts).perform();

		// Wait until the import element is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span[text()='Import Accounts']]")));

		// Clicking the Import Accounts Web Element
		driver.findElement(By.xpath("//a[span[text()='Import Accounts']]")).click();

		// Wait until we switch to the frame
		wait.until(ExpectedConditions.urlContains("import"));

		// Switch to iframe
		driver.switchTo().frame(0);

		// Wait until the text is visible
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.module-title-text")))
				.getText();
		// Assert the Import Accounts page opens
		assertTrue(text.contains("Upload Import File"));
	}

	@Test(priority = 2)
	public void importFiles() {
		// File initialization
		File f = new File("src/data/templates/Accounts.csv");

		// Locating the web element and importing the file
		driver.findElement(By.id("userfile")).sendKeys(f.getAbsolutePath());
		// Clicking the next button
		driver.findElement(By.id("gonext")).click();
		driver.findElement(By.id("gonext")).click();
		System.out.println("Step 1 completed");

		// Wait until the next button shows
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2.module-title-text"),
				"Step 2: Confirm Import File Properties"));
		driver.findElement(By.id("gonext")).click();
		System.out.println("Step 2 completed");

		// Wait until the next button shows
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2.module-title-text"),
				"Step 3: Confirm Field Mappings"));
		// Clicking the next button
		builder.scrollByAmount(0, 1820).click(driver.findElement(By.id("gonext"))).build().perform();
		System.out.println("Step 3 completed");

		// Wait until the import now button shows
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("importnow"))));
		// Clicking the import button
		builder.scrollByAmount(0, 500).click(driver.findElement(By.id("importnow"))).build().perform();

		// Redirect to the View Account page
		driver.get("http://crm.local:3050/#/accounts/index?return_module=Accounts&return_action=DetailView");

		// Assert shape of table
		List<WebElement> accTableRows = driver.findElements(By.xpath("//table[@role='table']/tbody/tr"));
		List<WebElement> accTableCols = driver.findElements(By.xpath("//table[@role='table']/thead/tr/th"));
		assertEquals(9, accTableCols.size());
		assertTrue(accTableRows.size() >= 5);
	}
	
	@Test(priority = 3)
	public void displayOddRows() {
		List<WebElement> accTableRows = driver.findElements(By.xpath("//table[@role='table']/tbody/tr"));
		List<WebElement> accTableCols = driver.findElements(By.xpath("//table[@role='table']/thead/tr/th"));
		
		// Fetching the count of the rows of the table
		int size = accTableRows.size();
		
		// Print the names of the odd rows of the table
		for(int i = 1;i<=size;i+=2) {
			System.out.println(driver.findElement(By.xpath("//table[contains(@class,'list-view-table')]//tr["+i+"]/td[3]")).getText());
		}
	}

	// @AfterClass
	// public void afterClass() {
	// 	// close the browser
	// 	driver.quit();
	// }

}
