package com.staticblocks;

import java.util.HashMap;
import java.util.Map;

public class Runner {
	
	private static String a = "Testing mini bytes" ;
	
	private static Map<String,String> map = new HashMap<>();
	
	//eager initialization 
	static {
		map.put("channel", "TMB");
		a =" amuthan1";
	}
	static {
		a =" amuthan";
		map.put("author", "amuthan");
	}
	
	public static void main(String[] args) {
		System.out.println(a);
		System.out.println(map);
	
	}

}
