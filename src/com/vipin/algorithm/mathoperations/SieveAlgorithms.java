package com.vipin.algorithm.mathoperations;

import java.util.Arrays;

public class SieveAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(26));
		int a[] = { 2,2,3,3,1,1,7,4};
		int b[][] = {{1,6},{5,7},{4,7},{8,8}};
		System.out.println(solve(a, b));
	}

	public static int solve(int A) {
		if (A == 2) {
			return 1;
		}
		boolean sieve[] = new boolean[A + 1];
		Arrays.fill(sieve, true);
		sieve[0] = false;
		sieve[1] = false;
		for (int i = 2; i < A + 1; i++) {
			if (sieve[i]) {
				for (int j = 2 * i; j < A + 1; j += i) {
					sieve[j] = false;
				}
			}
		}
		for (int i = 2; i < A + 1; i++) {
			if (sieve[i] && sieve[A - i]) {
				return 2;
			}
		}
		return -1;
	}

	public static int[] solve(int[] A, int[][] B) {
		int sieve[] = new int[10001];
		Arrays.fill(sieve, -1);
		sieve[0] = 1;
		sieve[1] = 1;
		for (int i = 2; i < 10001; i++) {
			if (sieve[i] == -1) {
				for (int j = 2 * i; j*j < 10001; j += i) {
					sieve[j] = 1;
				}
			}
		}
		int res[] = new int[B.length];
		int prefix[] = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			if (i == 0) {
				if (sieve[A[i]] == -1) {
					prefix[i] = 1;
					continue;
				}
			} else {
				if (sieve[A[i]] == -1) {
					prefix[i] = prefix[i - 1] + 1;
				} else {
					prefix[i] = prefix[i - 1];
				}
			}
		}
		int index = 0;
		for (int i = 0; i < B.length; i++) {
			int temp[] = B[i];
			if(temp[0]==1 && temp[1]==1) {
				res[i] = 0;
			} else {
				if (temp[0] == 1) {
					res[i] = prefix[temp[1] - 1];
				} else {
					res[i] = prefix[temp[1] - 1] - prefix[temp[0] - 2];
				}
			}
		}
		return res;
	}

}
