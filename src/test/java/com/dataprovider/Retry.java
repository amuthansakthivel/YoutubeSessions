package com.dataprovider;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	//when it return true the failed methd will be retried
	
	int count=0;
	int limit= 2;

	@Override
	public boolean retry(ITestResult result) {
		if(count<limit) {
			count++;
			return true;
		}
		return false;
	}

}
