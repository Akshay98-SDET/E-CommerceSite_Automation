package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojos.User;

@Listeners(com.ui.listeners.TestListener.class)

public class LoginTest extends BaseTest {

	@Test(description = "Verify login for valid user", priority = 1, groups = { "e2e",
			"Sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginDataProvider")
	public void loginJSONTest(User user) {
		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAdrress(), user.getPassword()).getUserName(),
				"Akshay J");
	}

	@Test(description = "Verify login for valid user", priority = 1, groups = { "e2e",
			"Sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginCSVDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyser.class)
	public void loginCSVTest(User user) {

		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAdrress(), user.getPassword()).getUserName(),
				"Akshay J");
	}

	@Test(description = "Verify login for valid user", priority = 1, groups = { "e2e",
			"Sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyser.class)
	public void loginExcelTest(User user) {
		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAdrress(), user.getPassword()).getUserName(),
				"Akshay J");
	}

	@Test(description = "Register with email")
	public void createAccount() {
		homepage.goToLoginPage().RegisterWithEmail();
	}

}