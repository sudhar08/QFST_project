package Activity;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity5 {
	
	WebDriver driver=new FirefoxDriver();
	Actions builder=new Actions(driver);
	WebDriverWait wait;
	
	//Select select;
	
 
  @BeforeClass
  public void setup()
  {
	  driver = new FirefoxDriver();
	  driver.get("http://crm.local:3050/#/Login");
	// Set a global 10-second implicit wait timeout threshold
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

  }
  

  @Test(priority =1)
  public void Login() 
  {
	  //Assert the page title() 
	 // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  Assert.assertEquals(driver.getTitle(),"SuiteCRM");
      WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
      username.sendKeys("admin");
      WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
      password.sendKeys("5Nx#I6BK%r3$8vz0ch");

        driver.findElement(By.id("login-button")).click();

      Assert.assertEquals(driver.getTitle(),"SuiteCRM");
      String title = driver.getTitle();
      System.out.println(title);
  }


  @Test(priority =2)
  public void Navbar() 
  {
  WebElement navbar = driver.findElement(By.xpath("//nav[@class='navbar navbar-expand-md navbar-1 ng-tns-c2316037842-2 ng-star-inserted']"));
  String navbar_color = navbar.getCssValue("background-color");

  System.out.println(navbar_color);


  }
  
  @AfterClass
  public void tearDown() 
  {
	  driver.quit();
  }

}
