package Activity;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class verifyPageTitle extends Base {
    
	@Test(priority = 1)
	public void verifyPage() {

		driver.get("http://crm.local:3050/#/Login");

		// verify the title
		assertEquals(driver.getTitle(), "SuiteCRM");
	}
    
}
