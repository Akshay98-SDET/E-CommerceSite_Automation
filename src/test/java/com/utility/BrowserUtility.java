package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Browser;

public abstract class BrowserUtility {

	private WebDriver driver;

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public BrowserUtility(Browser BrowserName) {
		if (BrowserName == Browser.CHROME) {
			driver = new ChromeDriver();
		} else if (BrowserName == Browser.EDGE) {
			driver = new EdgeDriver();
		} else if (BrowserName == Browser.FIREFOX) {
			driver = new FirefoxDriver();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void goToWebsite(String url) {
		driver.get(url);
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void ClickOn(By Locator) {
		WebElement element = driver.findElement(Locator);
		element.click();
	}

	public void enterText(By Locator, String text) {
		driver.findElement(Locator).sendKeys(text);
	}

	public String getVisibleText(By locator) {
		WebElement element = driver.findElement(locator);
		return element.getText();
	}

}
