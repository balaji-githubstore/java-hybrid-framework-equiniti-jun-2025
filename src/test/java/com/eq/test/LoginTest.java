package com.eq.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eq.base.AutomationWrapper;
import com.eq.utils.DataUtils;

public class LoginTest extends AutomationWrapper {
	@Test(dataProviderClass = DataUtils.class,dataProvider = "commonDataProvider")
	public void validLoginTest(String username,String password,String expectedValue)
	{
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//Assert the text Time at Work
		String actualValue=driver.findElement(By.xpath("//p[contains(normalize-space(),'at Work')]")).getText();
		Assert.assertEquals(actualValue, expectedValue);
	}
	
	@Test(dataProviderClass = DataUtils.class,dataProvider = "commonDataProvider")
	public void invalidLoginTest(String username,String password,String expectedError)
	{
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		String actualError=driver.findElement(By.xpath("//p[contains(normalize-space(),'Invalid')]")).getText();
		Assert.assertEquals(actualError, expectedError);
	}
}


