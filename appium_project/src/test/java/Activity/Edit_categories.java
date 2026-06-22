package Activity;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class Edit_categories extends Baseclass {
	
	private final PointerInput Finger =  new PointerInput(Kind.TOUCH, "finger");
	
	@Test
	public void edit_categories_test() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// find the element and click to open the dropdown
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/ListSpinnerCategory")).click();
		
		// click to add  new categories 
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]")).click();
		
		//it take to the new page add the categories
		
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/CategoryListButtonNew")).click();
		
		//enter the new categories
		driver.findElement(AppiumBy.id("CategoryListItemID")).sendKeys("Hello worls");
		
		// click the ok button in the bottom
		
		driver.findElement(AppiumBy.id("CategoryListButtonOK")).click();
		
		// now navigate to the home page and edit the categories for the activity 2
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Unfiled\"]")).click();
		
	}
	
	
	public void dolongPress(AppiumDriver driver, Point start) {
		
		Sequence action = new Sequence(Finger, 1);
		
		action.addAction(Finger.createPointerMove(Duration.ofMillis(0),Origin.viewport(), start.getX(),start.getY()));
		
		action.addAction(Finger.createPointerDown(0));
		
		action.addAction(new Pause(Finger, Duration.ofMillis(500)));
		
		action.addAction(Finger.createPointerUp(0));
		
		driver.perform(Arrays.asList(action));
		
		
		
	}
	
	@Test(priority = 1)
	public void upadte_taks() {
		Point start_point  = new Point(298,455);
		
		dolongPress(driver, start_point);
		
		driver.findElement(AppiumBy.id("DetailSpinnerCategory")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Hello worls\"]")).click();
		
		
		
		driver.findElement(AppiumBy.id("DetailButtonOK")).click();
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/ListSpinnerCategory")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Hello worls\"]")).click();
		
		List<WebElement> takslist = driver.findElements(AppiumBy.id("ToDoEditDescription"));
		for(WebElement task : takslist) {
			System.out.println(task.getText());
		}
	}
	
	

}
