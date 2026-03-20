package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class LoginPage extends BrowserUtility {
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	final static By EMAIL_LOCATOR = By.id("email");
	final static By PASSWORD_LOCATOR = By.id("passwd");
	final static By SIGN_IN_LOCATOR =  By.id("SubmitLogin");
	
	public MyAccountPage doLoginWith(String emailaddress, String password) {
		enterText(EMAIL_LOCATOR, emailaddress);
		enterText(PASSWORD_LOCATOR, password);
		ClickOn(SIGN_IN_LOCATOR);
		
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;
	
	}
	
}
