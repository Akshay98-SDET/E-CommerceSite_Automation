package com.ui.tests;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojos.User;

public class LoginTest {
	HomePage homepage;

	@BeforeMethod(description = "Load Home Page")
	public void setup() {
		homepage = new HomePage(CHROME);
	}

	@Test(description = "Verify login for valid user", priority = 1, groups = { "e2e",
			"Sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginDataProvider")
	public void loginTest(User user) {
		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAdrress(), user.getPassword()).getUserName(),
				"Akshay J");
	}

}