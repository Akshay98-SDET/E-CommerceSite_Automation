package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Browser;

public abstract class BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}

	public BrowserUtility(Browser BrowserName) {
		logger.info("Launching browser" + BrowserName);
		if (BrowserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		} else if (BrowserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
		} else if (BrowserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		}
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public void goToWebsite(String url) {
		logger.info("Loading the url " + url);

		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximising the window");

		driver.get().manage().window().maximize();
	}

	public void ClickOn(By Locator) {
		WebElement element = driver.get().findElement(Locator);
		logger.info("Clicking on element" + Locator);
		element.click();
	}

	public void enterText(By Locator, String text) {
		driver.get().findElement(Locator).sendKeys(text);
	}

	public String getVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}

	public String takeScreenshot(String name) {
		TakesScreenshot screenshotdata = (TakesScreenshot) driver.get();
		File src = screenshotdata.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "//Screenshot//" + name+".png";

		File dest = new File(path);

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
