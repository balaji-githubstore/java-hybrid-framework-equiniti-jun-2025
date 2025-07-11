package com.eq.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eq.base.AutomationWrapper;
import com.eq.pages.DashboardPage;
import com.eq.pages.LoginPage;
import com.eq.utils.DataUtils;

public class LoginTest extends AutomationWrapper {
	@Test(dataProviderClass = DataUtils.class, dataProvider = "commonDataProvider",groups = {"login","smoke"})
	public void validLoginTest(String username, String password, String expectedValue) {

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLogin();

		// Assert the text Time at Work
		DashboardPage dashboard = new DashboardPage(driver);
		String actualValue = dashboard.getTimeAtWorkHeader();
		Assert.assertEquals(actualValue, expectedValue);
	}

	@Test(dataProviderClass = DataUtils.class, dataProvider = "commonDataProvider",groups = {"login"})
	public void invalidLoginTest(String username, String password, String expectedError) {

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLogin();

		String actualError = login.getInvalidErrorMessage();
		Assert.assertEquals(actualError, expectedError);
	}
}
