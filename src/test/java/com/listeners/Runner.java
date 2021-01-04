package com.listeners;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Runner {

	@BeforeSuite
	public void setUpSuite() {
		//make db connection
		//init your extent reports
		System.out.println("before suite in runner"); }
	
	@AfterSuite
	public void tearDownSuite() {System.out.println("after suite in runner");}
	
	@BeforeMethod
	public void setUp() {System.out.println("before method in runner");}
	
	@AfterMethod
	public void tearDown() {System.out.println("after method in runner"); }
	
	@Test
	public void test1() {System.out.println("test1"); 
	
	}

	@Test
	public void test2() {System.out.println("test2");
	Assert.assertTrue(false);}
	
	@Test
	public void test3() {System.out.println("test3");}

}
