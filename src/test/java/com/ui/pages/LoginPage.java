package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	final static By EMAIL_LOCATOR = By.id("email");
	final static By PASSWORD_LOCATOR = By.id("passwd");
	final static By SIGN_IN_LOCATOR =  By.id("SubmitLogin"); 
	final static By Title_LOCATOR =  By.id("id_gender1");
	
	private static final By Register_Email_Address = By.id("email_create");
	private static final By Create_Account_Locator = By.id("SubmitCreate");
	
	public MyAccountPage doLoginWith(String emailaddress, String password) {
		enterText(EMAIL_LOCATOR, emailaddress);
		enterText(PASSWORD_LOCATOR, password);
		ClickOn(SIGN_IN_LOCATOR);
		
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;
	
	}
	
	public void RegisterWithEmail() {
		enterText(Register_Email_Address, "akshay.rajendra98@gmail.com");
		ClickOn(Create_Account_Locator);
		ClickOn(Title_LOCATOR);
	}
}
