package com.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Runner {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/executables/chromedriver.exe");
		driver = new ChromeDriver();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	//@Test
	public void test() {    //3348  , 2312 ,1573
		driver.get("https://google.co.in");
		PageFactoryDemo pfd = new PageFactoryDemo(driver);
		pfd.findElement10Times();
	}
	
	//@Test
	public void test2() {   //4196 , 3342 ,1622
		driver.get("https://google.co.in");
		PageFactoryDemoWithCacheLookUp pfd = new PageFactoryDemoWithCacheLookUp(driver);
		pfd.findElement10Times();
	}
	
	
	@Test 
	public void test3() {  //2069 , 3697 ,2390
		driver.get("https://google.co.in");
		IRecommendNoPageFactoryDemo npfd = new IRecommendNoPageFactoryDemo(driver);
		npfd.findElement10Times();
	}

	
}
