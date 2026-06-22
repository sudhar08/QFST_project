package example;

import java.lang.classfile.ClassFile.Option;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Activity3 extends Baseclass{
		
	@Test(priority = 1)
	public void calulator_add() {
	
		
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/clr")).click();
		
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_add")).click();
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_9")).click();
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/eq")).click();
		
		//find the result and to the assertion
		Assert.assertEquals(driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText(),"14");
		
		
		
		
	}
	@Test(priority = 2)
	public void calulator_sub() {
//		options.setAppPackage("com.google.android.calculator");
//		options.setAppActivity("com.android.calculator2.Calculator");	
		
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_9")).click();
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_sub")).click();
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/eq")).click();
		
		//find the result and to the assertion
		Assert.assertEquals(driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText(),"4");
	
		
	}
	
	
	@AfterMethod
	public void clearall() {
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/clr")).click();
	}
	

}
