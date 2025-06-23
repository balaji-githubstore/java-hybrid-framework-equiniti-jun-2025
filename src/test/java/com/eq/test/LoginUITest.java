package com.eq.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginUITest {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test
	public void titleTest() {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}

	@Test
	public void headerTest() {
		String actualHeader = driver.findElement(By.xpath("//h5")).getText();
		Assert.assertEquals(actualHeader, "Login123");
	}
}
