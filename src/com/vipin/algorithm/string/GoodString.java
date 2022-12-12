package com.vipin.algorithm.string;

public class GoodString {
	public static void main(String[] args) {
		System.out.println(makeGood("leEeetcode"));
	}

	public static String makeGood(String s) {
		StringBuilder sb = new StringBuilder();
		int N = s.length();
		int i = 0;
		while (i < N - 1) {
			if (s.charAt(i) == s.charAt(i + 1) + 32) {
				int j = i;
				int x = 1;
				while (j - x > -1 && j + x < N) {
					if (s.charAt(j - x) == s.charAt(j + x) + 32) {
						x++;
						continue;
					} else {
						break;
					}
				}
				sb.append(s.substring(0, j - x + 1));
				i = j + x + 1;
			} else {
				i++;
			}
		}
		return sb.toString();
	}
}
