package com.vipin.algorithm.bitmanipulations;

public class MaximumAndOperationResult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 13, 18, 23, 56, 81, 20, 4, 24, 93 };
		System.out.println(solve(A));

	}

	static int solve(int[] A) {
		int N = A.length;
		int ans = 0;
		for (int i = 31; i > -1; i--) {
			int count = 0;
			for (int temp : A) {
				if (((temp >> i) & 1) == 1) {
					count++;
				}
			}
			if (count >= 2) {
				ans = ans | (1 << i);
				for (int j = 0; j < N; j++) {
					if (((A[j] >> i) & 1) != 1) {
						A[j] = 0;
					}
				}
			}
		}
		return ans;
	}

	public int solve(int A) {
		int i = 0, ind = 0, sum = 0;
		while (A != 0) {
			if (((A) & 1) == 0) {
				sum = sum + (1 << i);
			} else
				ind = i;
			i++;
			A = A >> 1;
		}
		return (1 << ind + 1) ^ sum;
	}
}
