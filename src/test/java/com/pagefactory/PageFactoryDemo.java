package com.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryDemo {
	
	
	@FindBy(name="q")
	private WebElement searchbox;
	
	private WebDriver driver;

	public PageFactoryDemo(WebDriver driver) {
		PageFactory.initElements(driver, this); //verbose
		this.driver = driver;
	}

	public void findElement10Times() {
		
		long startTime = System.currentTimeMillis();
		for(int i = 0; i< 10 ; i++) {
			searchbox.clear();
			searchbox.sendKeys("Testing mini bytes");
		}
		System.out.println(System.currentTimeMillis() - startTime);
	}
}
