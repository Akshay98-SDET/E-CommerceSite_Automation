package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;

public class BaseTest {

	protected HomePage homepage;
	private boolean isHeadless = false;
	private boolean islambdaTest = false;
	ITestResult result;

	@BeforeMethod(description = "Load Home Page")
	public void setup() {
		WebDriver lambdaDriver;
		
		if (islambdaTest) {
			lambdaDriver = LambdaTestUtility.initialiseLambdaTestSession("chrome", result.getMethod().getMethodName());
			homepage = new HomePage(lambdaDriver);
		} else {
			
			homepage = new HomePage(Browser.CHROME, isHeadless);
		}
	}

	public BrowserUtility getInstance() {
		return homepage;
	}

	@AfterMethod(description ="Tear down the browser")
	public void tearDown() {
		if (islambdaTest) {
			LambdaTestUtility.quitSession();
		} 
	}

}
