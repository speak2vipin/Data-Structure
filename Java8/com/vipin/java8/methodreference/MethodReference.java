package com.vipin.java8.methodreference;

import java.util.Arrays;

public class MethodReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String countries[] = {"India", "England", "South Africa", "Qatar"};
		Arrays.asList(countries).forEach(System.out :: println);;
		
	}

}


