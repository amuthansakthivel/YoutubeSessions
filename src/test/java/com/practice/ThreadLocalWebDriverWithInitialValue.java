package com.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ThreadLocalWebDriverWithInitialValue {
	
	private static ThreadLocal<WebDriver> dr = ThreadLocal.withInitial(()->{
	System.setProperty("webdriver.chrome.driver", "/src/test/resources/executables/chromedriver.exe");
	return new ChromeDriver();
	});
			
	public static WebDriver getDriver() {
		return dr.get();
	}
	
	public static void setDriver(WebDriver driver) {
		dr.set(driver);
	}

	public static void unload() {
		dr.remove();
	}
}
