package com.vipin.algorithm.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		LongestPalindromicSubsequence l = new LongestPalindromicSubsequence();
		// System.out.println(l.longestPalindromeSubseq("bbbab"));

		int A[] = { 12, 7 };
		int B[] = { 7, 1, 6, 17, 2, 19, 10 };
		l.solve(A, B);

		String[] words = { "acca", "bbbb", "caca" };
		String target = "aba";
		System.out.println(l.numWays(words, target));
	}

	int n = 0;

	public int longestPalindromeSubseq(String s) {
		n = s.length();
		int dp[][] = new int[n][n];
		evaluate(dp, 0, n - 1, s);
		return evaluate(dp, 0, n - 1, s);
		// return dp[n-1][n-1];
	}

	int evaluate(int dp[][], int i, int j, String s) {
		System.out.println(i + " " + j + " " + dp[i][j] + " " + s.substring(i, j + 1));
		if (dp[i][j] != 0) {
			return dp[i][j];
		}
		if (i > j) {
			return 0;
		}
		if (i == j) {
			return 1;
		}
		if (s.charAt(i) == s.charAt(j)) {
			dp[i][j] = 2 + evaluate(dp, i + 1, j - 1, s);
		} else {
			dp[i][j] = Math.max(evaluate(dp, i + 1, j, s), evaluate(dp, i, j - 1, s));
		}

		return dp[i][j];
	}

	public int[] solve(int[] A, int[] B) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int a : A) {
			map.put(a, map.getOrDefault(a, 0) + 1);
		}
		int ans[] = new int[A.length];
		int index = 0;
		for (int b : B) {
			while (map.get(b) != null && map.get(b) > 0) {
				ans[index++] = b;
				map.put(b, map.get(b) - 1);
			}
		}
		Arrays.sort(A);
		for (int a : A) {
			if (map.get(a) != null && map.get(a) > 0) {
				ans[index++] = a;
			}
		}

		return ans;
	}

	int mod = 1000000007;
	Integer dp[][] = null;
	long count[][];
	int maxLength = 0;

	public int numWays(String[] words, String target) {
		//int mod = 1000000007;
		maxLength = words[0].length();
		count = new long[1000][26];
		for(String word : words) {
			maxLength = Math.max(maxLength, word.length());
			for(int i=0; i<word.length(); i++) {
				count[i][word.charAt(i)-'a']++;
			}
		}
		dp = new Integer[maxLength][target.length()];
		return calculate(target, 0, 0);

	}

	int calculate(String target, int j, int i) {
		if (i == target.length()) {
			return 1;
		}
		if (j == maxLength) {
			return 0;
		}
		if (dp[j][i] != null) {
			return dp[j][i];
		}
		int res = 0;
		int index = target.charAt(i)-'a';
		if (count[j][index] > 0) {
			res = (int) ((count[j][index] * calculate(target, j + 1, i + 1 )) % mod);
		}
		res = (res + calculate(target, j+1, i)) % mod;
		dp[j][i] = res;
		return dp[j][i];
	}

}
