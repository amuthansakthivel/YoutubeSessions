package com.practice;

public class ThreadLocalStringWithInitialValue {
	
	private static ThreadLocal<String> bank = ThreadLocal.withInitial(()->"amuthan");
	
	public static String getMoney() {
		return bank.get();
	}
	
	public static void depositMoney(String money) {
		bank.set(money);
	}
	
	public static void closeAccount() {
		bank.remove();
	}

}
