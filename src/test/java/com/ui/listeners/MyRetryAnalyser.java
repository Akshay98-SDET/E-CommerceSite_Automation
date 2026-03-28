package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyser implements IRetryAnalyzer {

	private static final int MAX_NUM_ATTEMPTS = 3;
	private int current_attempt = 1;

	@Override
	public boolean retry(ITestResult result) {
		if (current_attempt <= MAX_NUM_ATTEMPTS) {
			current_attempt++;
			return true;
		}
		return false;
	}

}
