package Activity;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class browser_page extends Baseclass {
	
	@Test
	public void  scroll() {
		driver.get("https://training-support.net/webelements");
		
		driver.findElement(
			    AppiumBy.androidUIAutomator(
			        "new UiScrollable(new UiSelector().scrollable(true))" +
			        ".flingForward().scrollTextIntoView(\"To-Do List\")"
			    )
			);
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"To-Do List\"]")).click();
		
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Todo List\"]")));
		 Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Todo List\"]")).getText(),
				"Todo List");
		
	}
	
	@DataProvider(name = "tasksDesc")
	public Object[][] tasks() {
		return new Object[][] { { "Add tasks to list" }, { "Get number of tasks" }, { "Clear the list" } };
	}

	
	static int count = 0;

	@Test(dataProvider = "tasksDesc", dependsOnMethods = "scroll")
	public void addTasks(String task) {
		// Locate the input field
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"todo-input\"]")).sendKeys(task);
		// Click the add button
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"todo-add\"]")).click();

		// Wait until the task is added
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"" + task + "\"]")));

		// Get the list of Web elements
		List<WebElement> tasks = driver
				.findElements(AppiumBy.xpath("//android.view.View//android.view.View//android.widget.TextView"));

		// Text of the web elements
		List<String> tasksDesc = new ArrayList<>();

		// Add the tasks
		for (WebElement t : tasks) {
			tasksDesc.add(t.getText());
		}

		count = tasksDesc.size();

		// Assert whether it contains the task
		assertTrue(tasksDesc.contains(task));

	}

	@Test(dependsOnMethods = "addTasks")
	public void selectTasks() {
		for (int i = 1; i <= count; i++) {
			driver.findElement(AppiumBy.xpath(
					"//android.widget.ListView/android.view.View[" + i + "]/android.view.View/android.widget.CheckBox"))
					.click();
		}

		// Assert the count of the tasks
		 Assert.  assertEquals(count, 5);

	}
	
}
