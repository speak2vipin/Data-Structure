package com.vipin.java8.functionalinterface;

import java.util.function.Function;

public class FunctionTest {
	public static void main(String[] args) {
		String countries[] = {"India", "US", "England", "Australia"};
		Function<String[], String> converter = (all) -> {
			StringBuffer names = new StringBuffer();
			for(String n : all) {
				names.append(n);
				names.append('\n');
			}
			return names.toString();
		};
		// Function Interface has a method named as apply(). 
		// It can accept an object of any datatype and return of any datatype
		System.out.println(converter.apply(countries));
	}

}
