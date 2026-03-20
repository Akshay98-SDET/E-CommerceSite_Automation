package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public abstract class BrowserUtility {
	
	private WebDriver driver;

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public BrowserUtility(String BrowserName) {
		if(BrowserName.equalsIgnoreCase("chrome")) {
			driver =  new ChromeDriver();
		} 
		else if(BrowserName.equalsIgnoreCase("edge")) {
			driver =  new EdgeDriver();
		}
		else {
			System.out.println("Enter valid browser");
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
