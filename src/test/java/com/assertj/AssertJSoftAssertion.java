package com.assertj;

import org.assertj.core.api.BDDAssertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class AssertJSoftAssertion {
	
	//@Test
	public void assertSoftlyTest() {
		SoftAssertions softly = new SoftAssertions();
		
		softly.assertThat("Hello world")
			.isNotEmpty()
			.hasSize(5)
			.contains("Hello");
		
		System.out.println("Hi");
		
		softly.assertAll();
			
	}
	
	@Test
	public void assertBDDStyleTest() {
		BDDAssertions.then("Hello world")
			.hasSize(11)
			.containsIgnoringCase("hello");
			
		
	}
	
	
	
	
	
	
	
	

}
