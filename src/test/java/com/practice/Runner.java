package com.practice;

public class Runner {

	public static void main(String[] args) {
		System.out.println("=========Initial deposit=========");
		
		System.out.println(ThreadLocalDemo.getMoney());
		ThreadLocalDemo.depositMoney("deposited 5000");
		
		System.out.println("=========After depositing the money=========");
		
		System.out.println(ThreadLocalDemo.getMoney());
		ThreadLocalDemo.closeAccount();
		
		System.out.println("=========After closing the account=========");
		System.out.println(ThreadLocalDemo.getMoney());
		
		
		/*
		 * 1. default value of ThreadLocal variable is null
		 * 2. get method helps to get the value (corresponding to the thread)
		 * 3. set method helps to set some value (corresponding to the thread)
		 * 4. remove method helps to safely remove all the resources. (sets it back to default value)
		 */
		
		
	}

}
