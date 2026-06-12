package Activity;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	static WebDriver driver=new FirefoxDriver();
	static  Actions builder=new Actions(driver);
	static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	static  Select select;
}
