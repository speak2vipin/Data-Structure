package com.vipin.algorithms.string;

public class NumberOfBOBSubstringInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("bobob"));

	}

	public static int solve(String A) {
		int count = 0;
		int N = A.length();
		for (int i = 0; i < N - 2; i++) {
			if (A.charAt(i) == 'b') {
				if (A.substring(i, i + 3).equals("bob")) {
					count++;
				}
			}
		}
		return count;
	}
}
