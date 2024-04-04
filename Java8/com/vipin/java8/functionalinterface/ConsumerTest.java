package com.vipin.java8.functionalinterface;

import java.util.Arrays;

public class ConsumerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String countries[] = { "India", "US", "England", "Australia", "Iceland", "Uzbekistan", "Egypt", "UAE" };
		System.out.println("The list of countries:");
		// The Consumer interface has only one single method called accept(). 
		// It accepts a single argument of any data type and does not return any result.
		Arrays.asList(countries).forEach((country) -> System.out.println(country));
	}

}
