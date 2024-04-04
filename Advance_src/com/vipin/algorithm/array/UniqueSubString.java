package com.vipin.algorithm.array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class UniqueSubString {

	/*
	 * Complete the 'substringCalculator' function below.
	 *
	 * The function is expected to return a LONG_INTEGER. The function accepts
	 * STRING s as parameter.
	 */
	// static long res = 0;
	
	public static void main(String[] args) {
		String s = "abcdapqrc";
		System.out.println(substringCalculator(s));
	}
	
	public static long substringCalculator(String s) {
		// Write your code here
		long res = 0;
		int n = s.length();
		res = (1l * n * (n + 1)) / 2;
		Map<Character, ArrayList<Integer>> map = new HashMap<>();

		int st = 0;
		while (st < n) {
			char letter = s.charAt(st);
			map.computeIfAbsent(letter, val -> new ArrayList<Integer>()).add(st);
			if (map.get(letter).size() > 1) {
				res = reduceCount(map.get(letter), s, res);
			}
			st++;
		}
		return res;
	}

	static long reduceCount(ArrayList<Integer> indexList, String s, long res) {
		int size = indexList.size();
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				int count = countCommonSubString(indexList.get(i), indexList.get(j), s);
				res = res - ((1l * count * (count + 1)) / 2);
			}
		}
		return res;
	}

	static int countCommonSubString(int i, int j, String s) {
		int count = 0;
		while (i < s.length() && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i++;
			j++;
			count++;
		}
		return count;
	}
	
	

}
