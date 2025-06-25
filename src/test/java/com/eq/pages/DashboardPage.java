package com.eq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eq.base.WebDriverKeywords;

public class DashboardPage extends WebDriverKeywords {

	private WebDriver driver;
	
	private By timeAtWorkLocator=By.xpath("//p[contains(normalize-space(),'at Work')]");

	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public String getTimeAtWorkHeader()
	{
		return driver.findElement(timeAtWorkLocator).getText();
	}

}
