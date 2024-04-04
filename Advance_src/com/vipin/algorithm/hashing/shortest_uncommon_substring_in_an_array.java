package com.vipin.algorithm.hashing;

import java.util.HashMap;
import java.util.HashSet;

public class shortest_uncommon_substring_in_an_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s[] = {"cab","ad","bad","c"};
		for(String st : shortestSubstrings(s))
		System.out.println(st);
		

	}

	public static String[] shortestSubstrings(String[] arr) {
		int l = arr.length;
		String result[] = new String[l];
		System.out.println("g".compareTo("h"));
		System.out.println("h".compareTo("g"));
		HashMap<String, Integer> countMap = new HashMap<>();
		for (String s : arr) {
			int n = s.length();
			HashSet<String> set = new HashSet<String>();
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n+1; j++) {
					String sub = s.substring(i, j);
					set.add(sub);
				}
			}
			for (String sub : set) {
				countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);
			}
		}

		int index = 0;
		for (String s : arr) {
			String temp = "";
			int n = s.length();
			for (int i = 0; i < n; i++) {
				//HashSet<String> set = new HashSet<String>();
				for (int j = i+1; j < n+1; j++) {
					String sub = s.substring(i, j);
					if (countMap.get(sub) == 1) {
						temp = (temp.length() == 0) ? sub
								: (sub.length() == temp.length() ? (sub.compareTo(temp) < 0 ? sub : temp)
										: (sub.length() > temp.length() ? temp : sub));
					}
				}
			}
			result[index++] = temp;
		}
		return result;
	}

}


