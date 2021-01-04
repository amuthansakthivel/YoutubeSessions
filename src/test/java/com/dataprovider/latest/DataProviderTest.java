package com.dataprovider.latest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest  {

	@Test(dataProvider="getData1")
	public void test1(Employee emp) {
		System.out.println(emp.getId());
		System.out.println(emp.getName());

	}

	@Test(dataProvider="getData1")
	public void test2(String username) {
		System.out.println(username);
	}


	@DataProvider
	public static Object[] getData1(Method m) {

		if(m.getName().equalsIgnoreCase("test1")) {

			return new Employee[] {
					new Employee("amuthan","1234"),
					new Employee("testingminibytes","2345")

			};
		}
		else if(m.getName().equalsIgnoreCase("test2")) {
			return new Object[] {"amuthan","testingminibytes"};
		}
		return null;
	}





	/*
	 * 2D object array is not always the return type of data provider
	 */

	//object[][] --> how many iteration you want to run this test
	// second dimension --> how many parameters you want to feed to your test method
	//Object[]
	//String[]
	//Employee[]







}
