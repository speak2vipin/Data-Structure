package com.vipin.java8.functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String countries[] = { "India", "US", "England", "Australia", "Iceland", "Uzbekistan", "Egypt", "UAE" };
		List<String> countryList = Arrays.asList(countries);
		System.out.println(getBeginWith(countryList, (s)->s.startsWith("I")));
		System.out.println(getBeginWith(countryList, (s)->s.endsWith("d")));
		System.out.println(getBeginWith(countryList, (s)->s.startsWith("U") || s.contains("z")));
	}

	private static List getBeginWith(List<String> countryList, Predicate<String> valid) {
		List<String> selected = new ArrayList<>();
		countryList.forEach(country -> {
			if (valid.test(country)) {
				selected.add(country);
			}
		});
		return selected;
	}

}
