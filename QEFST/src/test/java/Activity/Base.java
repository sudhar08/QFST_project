package Activity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	public void init(){
		WebDriver driver=new FirefoxDriver();
		Actions builder=new Actions(driver);
		WebDriverWait wait;
		Select select;
	}
}
