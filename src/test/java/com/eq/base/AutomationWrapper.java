package com.eq.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class AutomationWrapper {
	protected WebDriver driver;
	public int a=10;

	@BeforeMethod(alwaysRun = true)
	@Parameters({"browser"})
	public void setup(@Optional("ch") String browserName) {
		
		if(browserName.equalsIgnoreCase("edge"))
		{
//			System.setProperty("webdriver.edge.driver", "driver/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("ff"))
		{
//			System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@AfterMethod(alwaysRun = true)
	public void teardown() {
		driver.quit();
	}

}
