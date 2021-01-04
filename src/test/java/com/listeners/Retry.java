package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	
	// when ever a test is failed this method retry will be called. If this method return true , the failed 
	//method will be rerun
	
	int counter = 0;
	int limit = 2;

	@Override
	public boolean retry(ITestResult result) {
		if(counter<limit) {
			counter++;
			return true;
		}
		return false;
	}

}
