package Activity;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class addnewtask extends Baseclass{
		
	@DataProvider
	public Object[][] taskobj(){
		return new Object[][] {
			
			{"Activity1", "1", "//android.widget.TextView[contains(@text, 'Tomorrow')]"},
			{ "Activity2", "2", "//android.widget.TextView[contains(@text, 'Tomorrow')]" },
			{ "Activity3", "3", "//android.widget.TextView[contains(@text, 'Friday')]" } };
	}

    @Test(dataProvider = "taskobj")
    public void Testtodotask(String actvity,String priority,String duedate){
    	
    	   driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/ListButtonNew")).click();
    	   
    	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	   driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailEditTextDescription")).sendKeys(actvity);
    	   
    	   
    	// Locate the priority input and send the priority
   		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailEditTextPriority")).clear();
    	   driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailEditTextPriority")).sendKeys(priority);
    	   
    	   
    	   //click the due date 
    	   driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailButtonDueDate")).click();
    	   
    	   driver.findElement(AppiumBy.xpath(duedate)).click();
    	   
    	   driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailButtonOK")).click();
    	   
    	   List<WebElement> TaskList = driver.findElements(AppiumBy.id("ToDoEditDescription"));
    	   
    	   boolean taskFound = TaskList.stream()
                   .anyMatch(task -> task.getText().equals(actvity));
    	   
    	   assertTrue(taskFound);
    	
    }

}
