package com.ui.pages;

import org.openqa.selenium.By;

import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public final class HomePage extends BrowserUtility {
	private static final By SIGN_IN_LOCATOR = By.xpath("//*[@class=\"login\"]");

	public HomePage(String browserName) {
		super(browserName);
		goToWebsite(JSONUtility.readJSON(QA));
	}

	public LoginPage goToLoginPage() {
		ClickOn(SIGN_IN_LOCATOR);
		maximizeWindow();
		LoginPage loginpage = new LoginPage(getDriver());
		return loginpage;
	}

}
