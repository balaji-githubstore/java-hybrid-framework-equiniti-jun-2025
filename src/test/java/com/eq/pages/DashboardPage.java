package com.eq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

	private WebDriver driver;
	
	private By timeAtWorkLocator=By.xpath("//p[contains(normalize-space(),'at Work')]");

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTimeAtWorkHeader()
	{
		return driver.findElement(timeAtWorkLocator).getText();
	}

}
