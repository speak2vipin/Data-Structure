package com.vipin.algorithm.dp;

import java.util.Arrays;
import java.util.HashSet;

public class MinimumObseleteCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumObseleteCharacter m = new MinimumObseleteCharacter();
		String s = "sayhelloworld";
		String dictionary[] = {"hello","world"};
		System.out.println(m.minExtraChar(s, dictionary));
	}

	Integer[] memo;
	HashSet<String> dictionarySet;

	public int minExtraChar(String s, String[] dictionary) {
		int n = s.length();
		memo = new Integer[n];
		dictionarySet = new HashSet<>(Arrays.asList(dictionary));
		return helper(s, 0, n);
	}

	int helper(String s, int start, int n) {
		if (start == n) {
			return 0;
		}
		if (memo[start] != null) {
			return memo[start];
		}
		int ans = 1 + helper(s, start + 1, n);
		for (int end = start; end < n; end++) {
			String sub = s.substring(start, end + 1);
			if (dictionarySet.contains(sub)) {
				ans = Math.min(ans, helper(s, end + 1, n));
			}
		}
		return memo[start] = ans;
	}

}
