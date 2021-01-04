package com.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IRecommendNoPageFactoryDemo {
	
	
	private By searchbox = By.name("q");
	
	private WebDriver driver;
	
	public IRecommendNoPageFactoryDemo(WebDriver driver) {
		this.driver = driver;
	}
	
	public void findElement10Times() {
		long startTime = System.currentTimeMillis();
		for(int i = 0; i< 10 ; i++) {
			WebElement element =driver.findElement(searchbox);
			element.clear();
			element.sendKeys("Testing mini bytes");
		}
		System.out.println(System.currentTimeMillis() - startTime);
	}

}
