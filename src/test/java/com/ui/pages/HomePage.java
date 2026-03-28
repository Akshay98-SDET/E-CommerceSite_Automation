package com.ui.pages;

import static com.constants.Env.QA;

import org.openqa.selenium.By;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;

public final class HomePage extends BrowserUtility {
	private static final By SIGN_IN_LOCATOR = By.xpath("//*[@class=\"login\"]");

	public HomePage(Browser browserName) {
		super(browserName);
		goToWebsite(JSONUtility.readJSON(QA));
		// goToWebsite(PropertiesUtil.getProperty(Env.DEV, "URL"));
	}

	public LoginPage goToLoginPage() {
		ClickOn(SIGN_IN_LOCATOR);
		maximizeWindow();
		LoginPage loginpage = new LoginPage(getDriver());
		return loginpage;
	}

}
