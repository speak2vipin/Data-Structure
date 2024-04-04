package com.vipin.algorithm.basic;

import java.util.*;

public class LInkHashMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> stocks = new LinkedHashMap<>(16, 0.75f, true);


	    stocks.put("Apple", 123);

	    stocks.put("BMW", 54);

	    stocks.put("Google", 87);

	    stocks.put("Microsoft", 232);

	    stocks.put("Oracle", 76);

	 

	    stocks.get("Google");

	    stocks.get("BMW");

	 

	    System.out.println(stocks);
	}

}

