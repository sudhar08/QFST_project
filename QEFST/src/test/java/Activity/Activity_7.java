package Activity;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity_7 extends Base{
	
	Map<String,String> map= new HashMap();
//	@BeforeClass
//	public void login() {
//    	driver.get("http://crm.local:3050/#/Login");
//    	builder.pause(2000).perform();
//    	if(driver.getCurrentUrl().equals("http://crm.local:3050/#/Login")) {
//    		WebElement username=driver.findElement(By.xpath("//input[@aria-label='Username']"));
//    		WebElement pass=driver.findElement(By.xpath("//input[@aria-label='Password']"));
//    		WebElement login=driver.findElement(By.xpath("//button[@id='login-button']"));
//    		username.sendKeys("admin");
//    		pass.sendKeys("5Nx#I6BK%r3$8vz0ch");
//    		login.click();
//    	}
//	}
	
    @DataProvider(name = "csvData")
    public Object[][] getCSVData() throws Exception {

        List<Object[]> data = new ArrayList<>();

        BufferedReader br = new BufferedReader(
                new FileReader("src/data/templates/Leads.csv"));
        
        String line;
        br.readLine();
        for(int i=0;i<5;i++){
        	line = br.readLine();
            String[] values = line.split(",");
            data.add(new Object[]{
                    values[0], values[1],values[4], values[5], values[8], values[9], values[11]
                    		, values[12], values[17], values[18], values[19], values[20]
            });
        }
        br.close();
        return data.toArray(new Object[0][]);
    }
    
    @Test(dataProvider="csvData")
	public void addLeads(String fn, String ln, String jt, String dep, String web, String em, String mob, String off, String ac, String ast, String ap, String aco) {
    	
    	//System.out.println(fn+" "+ln+" "+jt+" "+dep+" "+web+" "+em+" "+mob+" "+off+" "+as+" "+ac+" "+ast+" "+ap+" "+aco);
    	builder.pause(5000).perform();
    	driver.get("http://crm.local:3050/#/leads");
    	wait.until(
    		    ExpectedConditions.visibilityOfElementLocated(
    		        By.xpath("//a[@aria-label='Quick Create']")
    		    )
    		);
		WebElement addLeads=driver.findElement(By.xpath("//a[@aria-label='Quick Create']"));
		addLeads.click();
		driver.findElements(By.xpath("//scrm-label[text()=' Create Lead ']")).get(0).click();
		builder.pause(3000).perform();
		driver.findElement(By.xpath("//scrm-label[normalize-space()='First Name']/ancestor::span/following-sibling::span//input")).sendKeys(fn);
		driver.findElement(By.xpath("//scrm-label[normalize-space()='Last Name']/ancestor::span/following-sibling::span//input")).sendKeys(ln);
		driver.findElement(By.xpath("//scrm-dynamic-field[contains(@class,'dynamic-field-type-phone')]//input")).sendKeys(mob);
		driver.findElement(By.xpath("//scrm-dynamic-field[contains(@class,'dynamic-field-name-phone_work')]//input")).sendKeys(off);
		driver.findElement(By.xpath("//scrm-dynamic-field[contains(@class,'dynamic-field-name-title')]//input")).sendKeys(jt);
		driver.findElement(By.xpath("//scrm-dynamic-field[contains(@class,'dynamic-field-name-department')]//input")).sendKeys(dep);
		driver.findElement(By.xpath("//scrm-dynamic-field[contains(@class,'dynamic-field-name-website')]//input")).sendKeys(web);
		driver.findElement(By.xpath("//scrm-dynamic-field[contains(@class,'dynamic-field-name-email_address')]//input")).sendKeys(em);
		driver.findElement(By.xpath("//scrm-dynamic-field[contains(@class,'dynamic-field-name-primary_address_city')]//input")).sendKeys(ac);
		driver.findElement(By.xpath("//scrm-dynamic-field[contains(@class,'dynamic-field-name-primary_address_state')]//input")).sendKeys(ast);
		driver.findElement(By.xpath("//scrm-dynamic-field[contains(@class,'dynamic-field-name-primary_address_postalcode')]//input")).sendKeys(ap);
		driver.findElement(By.xpath("//scrm-dynamic-field[contains(@class,'dynamic-field-name-primary_address_country')]//input")).sendKeys(aco);
		driver.findElement(By.xpath("//scrm-label[normalize-space()='Save']/parent::button")).click();
	}
    @Test(dependsOnMethods="addLeads")
    public void prerequireOfCheck() {
    	builder.pause(3000).perform();
    	driver.get("http://crm.local:3050/#/leads/index?return_module=Leads&return_action=DetailView");
    	builder.pause(3000).perform();
    	List<WebElement> table = driver.findElements(By.xpath("//tbody/tr"));
    	for(WebElement row:table) {
    		List<WebElement> cols = row.findElements(By.xpath("./td"));
    		String name = cols.get(2).getText().trim();
    	    String phone = cols.get(5).getText().trim();
    	    map.put(name, phone);
    	}
    }
    
    @Test(dataProvider="csvData", dependsOnMethods="prerequireOfCheck")
    public void checkPhoneInLeads(String fn, String ln, String jt, String dep, String web, String em, String mob, String off, String ac, String ast, String ap, String aco) {
    	assertEquals(off,map.get(fn+" "+ln));
    }
    
//    
//    @AfterClass
//	public void afterClass() {
//		// close the browser
//		driver.quit();
//	}
    
}
