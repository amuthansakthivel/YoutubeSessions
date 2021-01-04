package com.practice;

public class ThreadLocalSubClassDemo extends ThreadLocal<String>{
	
	@Override
	protected String initialValue() {
		return "abcd";
	}
	
	public static ThreadLocal<String> myThreadLocal = new ThreadLocal<String>() {
		@Override
		protected String initialValue() {
			return "abcdef";
		}
	};

}
