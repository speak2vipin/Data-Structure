package com.vipin.algorithm.basic;

public class BasicMethodOverride {

	
	public static void main(String[] args) {
		test(null);
	}

	public static void test(Object o) {
		System.out.println("Object method");
	}

	public static void test(String s) {
		System.out.println("String method");
	}
}
