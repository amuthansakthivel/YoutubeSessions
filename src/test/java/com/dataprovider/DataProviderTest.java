package com.dataprovider;


import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderTest {

	@Test(dataProvider="getData2")
	public void test1(String value) {
		
		
		System.out.println(value);
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] {
			{"amuthan"},
			{"testing mini bytes"}
		};
	}

	@Test(dataProvider="getData2")
	public void test2(Employee emp) {
		System.out.println(emp.getId() + " : "+ emp.getName());
	}

	@DataProvider
	public Employee[] getData1() {

		return new Employee[] {
				new Employee("Amuthan", "123"),
				new Employee("Sachin", "234")
		};
	}

	@DataProvider
	public Object[] getData2(Method m) {
		if(m.getName().equals("test2")){
			return new Employee[] {
					new Employee("Amuthan", "123"),
					new Employee("Sachin", "234")
			};
		}
		else if(m.getName().equalsIgnoreCase("test1")) {
			return new String[] {"amuthan", "sakthivel"};
		}
		return null;


	}


	@Test
	public void dummytest() {
		String[] a = {"amuthan","testing"};
		
		
		for(int i=0;i<a.length;i++) {
			System.out.println("enter username");
			System.out.println("enter password");
			System.out.println("login");
			Assert.assertEquals(true, false);
		}
	}

}
