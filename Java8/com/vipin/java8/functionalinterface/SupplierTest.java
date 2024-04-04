package com.vipin.java8.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SupplierTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String countries[] = { "India", "US", "England", "Australia", "Iceland", "Uzbekistan", "Egypt", "UAE" };
		List<String> countryList = Arrays.asList(countries);
		listBeginWith(countryList, (s)->s.startsWith("I"));
		listBeginWith(countryList, (s)->s.endsWith("d"));
		listBeginWith(countryList, (s)->s.startsWith("U") || s.contains("z"));
	}
	private static void listBeginWith(List <String> list, Predicate<String> valid) {
		printNames(() -> "List of countries:");
		list.forEach(country -> {
			if(valid.test(country)) {
				printNames(() -> country);
			}
		});
		
	}
	// A Supplier interface has only one single method called get(). 
	// It does not accept any arguments and returns an object of any data type.
	private static void printNames(Supplier<String> arg) {
		System.out.println(arg.get());
	}

}
