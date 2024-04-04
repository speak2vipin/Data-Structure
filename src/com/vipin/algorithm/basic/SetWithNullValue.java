package com.vipin.algorithm.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SetWithNullValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 HashSet<String> set=new HashSet<String>();

	        set.add(null);

	        set.add("One");

	        for(String s: set)

	            System.out.println(s);
	        
	        Map<Integer, Integer>map = new HashMap();
	        //map.put(null, null);
	        //map.put(null, null);
	       
	        System.out.println(map.size()+" "+map.get(null));

	}

}

