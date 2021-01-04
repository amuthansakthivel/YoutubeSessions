package com.assertj;

public class Employee {
	
	int age;
	String name;
	int salary;
	
	public Employee(int age, String name, int salary) {
		this.age = age;
		this.name = name;
		this.salary = salary;
	}
	
	public void printValues() {
		System.out.println(age + " : "+ name + " : "+ salary);
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

}
