package com.assertj;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class FrameworkAssertion extends AbstractAssert<FrameworkAssertion, String>{

	public FrameworkAssertion(String value) {
		super(value, String.class);
	}

	
	public static FrameworkAssertion assertThat(String value) {
		return new FrameworkAssertion(value);
		
	}
	
	public AbstractAssert stringCheck() {
		
			isNotNull();
			if(!actual.contains("Hello")) {
				failWithMessage("Does not contains element");
			}
			
		return this ;
	}
}
