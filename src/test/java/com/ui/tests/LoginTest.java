package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;

public class LoginTest {
	HomePage homepage;
	
	@BeforeMethod(description = "Home Page launch")
	public void setup() {
		homepage = new HomePage("chrome");
	}
	
	@Test (description = "Veify login for valid user", priority = 1, groups = {"e2e", "Sanity"})
	public void loginTest() {
		String userName = homepage.goToLoginPage().doLoginWith("jexakag141@pazuric.com", "Akshay@1998").getUserName(null);
		Assert.assertEquals(userName, "Akshay J");
	}

}