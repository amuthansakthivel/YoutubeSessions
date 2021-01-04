package com.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLocatorsDemo {
	
	private WebDriver driver;
	
	public DynamicLocatorsDemo(WebDriver driver) {
		
	}
	
	//div[text()='Amazon Prime Music']/parent::a
	
	private String menuitem = "//div[text()='%value%']/parent::a";
	
	public void clickMenu(String value) {
		driver.findElement(By.xpath(menuitem.replace("%value%", value)));
		
	}

}
