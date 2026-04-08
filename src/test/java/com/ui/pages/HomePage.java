package com.ui.pages;

import static com.constants.Env.QA;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BrowserUtility {
	private static final By SIGN_IN_LOCATOR = By.xpath("//*[@class=\"login\"]");

	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	

	public HomePage(Browser browserName) {
		super(browserName);
		goToWebsite(JSONUtility.readJSON(QA));
		
		// goToWebsite(PropertiesUtil.getProperty(Env.DEV, "URL"));
	}

	public LoginPage goToLoginPage() {
		logger.info("Going to sign up page");
		ClickOn(SIGN_IN_LOCATOR);
		maximizeWindow();
		LoginPage loginpage = new LoginPage(getDriver());
		return loginpage;
	}
	

}
