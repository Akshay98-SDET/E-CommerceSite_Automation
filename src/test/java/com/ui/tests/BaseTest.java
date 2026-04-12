package com.ui.tests;

import org.testng.annotations.BeforeMethod;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;


public class BaseTest {

	HomePage homepage;
	@BeforeMethod(description = "Load Home Page")
	public void setup() {
		homepage = new HomePage(Browser.CHROME);
	}
	
	public BrowserUtility returnInstance() {
		return homepage;
	}

}
