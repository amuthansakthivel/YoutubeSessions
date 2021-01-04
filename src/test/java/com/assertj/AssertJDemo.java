package com.assertj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.assertj.core.data.Percentage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertJDemo {
	
	//@Test
	public void stringTest() {
		String temp = "Hello World"; 
		
		String a = "";
		String b= "   ";
	
		Assertions.assertThat(temp)
			  .isNotNull()
			  .as("String is actually empty").isNotEmpty()	
			  .as("String is actually blank").isNotBlank()
			  .isEqualTo("Hello World")
			  .contains("Hello")
			  .doesNotContain("Hi")
			  .containsWhitespaces()
			  .containsIgnoringCase("world")
			  .matches("\\w.*"+" World")
			  .doesNotContainPattern("\\d.*") //0-9 -->does not contains digits
			  .hasSize(11)
			  .hasSizeGreaterThan(10)
			  .hasSizeLessThan(20)
			  .hasSizeBetween(10, 20)
			  .endsWith("World")
			  .isInstanceOf(String.class);
			  
	}
	
	//@Test
	public void numbersTest() {
		int a = 10;
		
		Assertions.assertThat(a)
			.isEqualTo(10)
			.isCloseTo(16, Offset.offset(5)) //10 +- 5 --> 5-15
			.isInstanceOf(Integer.class)
			.isBetween(3, 15)
			.isCloseTo(12, Percentage.withPercentage(30))  // 7 -13 
			.isNotCloseTo(15, Percentage.withPercentage(30))
			.isPositive()
			.isEven()
			.isGreaterThanOrEqualTo(5)
			.isLessThanOrEqualTo(20);
	}

	//@Test
	public void listTest() {
		List<String> list = Arrays.asList("Testing","Mini","Bytes");
		List<String> list2 = Arrays.asList("Testing","Mini");
		List<String> list3 = Arrays.asList("Automation","selenium");
		 
		Assertions.assertThat(list)
			.hasSize(3)
			.hasSizeBetween(2, 15)
			.hasAtLeastOneElementOfType(String.class)
			.isNotEmpty()
			.contains("Testing")
			.doesNotContain("Automation")
			.startsWith("Testing")
			.containsExactlyInAnyOrder("Mini", "Testing","Bytes")
			.containsExactly("Testing","Mini","Bytes")
			.withFailMessage(()->"String is not having size less than 3").allMatch(s->s.length()<3)
			.containsAll(list2)
			.doesNotContainAnyElementsOf(list3);
	}
	
	//@Test
	public void mapTest() {
		Map<String,String> map = new HashMap<>() ;
			
		map.put("name","Amuthan");
		map.put("channel", "Testing mini bytes");
		map.put("game","cricket");
		
		Assertions.assertThat(map)
			.containsEntry("name", "Amuthan")
			.hasSize(5)
			.isNotEmpty()
			.doesNotContainEntry("fav", "football")
			.doesNotContainKey("Game")
			.containsKey("channel")
			.containsValue("cricket");			
		
	}
	
	
	@Test
	public void customClassTest() {
		
		Employee emp1 = new Employee(25, "sachin", 100); //o1 -->age1, name1, salary1
		Employee emp2 = new Employee(25, "sachin", 100); //o2
		
		Assertions.assertThat(emp1)
			.isEqualToComparingFieldByField(emp2)
			.isNotNull()
			.isInstanceOf(Employee.class)
			.hasFieldOrProperty("age")
			.hasFieldOrPropertyWithValue("name", "sachin")
			.extracting(e -> e.age).isNotEqualTo(24);
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
