package com.practice;

import org.openqa.selenium.WebDriver;

public class ThreadLocalWebDriverDemo {
	
	private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();
	
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
