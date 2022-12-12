package com.vipin.algorithm.array;

public class MinSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 5, 9, 10, 4, 7, 8 };
		int B[]	= { 5, 6, 4, 7, 2, 5 };
		System.out.println(solve(A, B));

	}

	public static int solve(int[] A, int[] B) {
		int sum = -1;
		int N = A.length;

		int tempSum = 0;
		for (int j = 1; j < N - 1; j++) {
			int min = 0;
			int max = 0;
			for (int i = 0; i < j; i++) {
				if (A[i] < A[j]) {
					if (min == 0) {
						min = B[i];
					} else {
						min = min < B[i] ? min : B[i];
					}
				}
			}
			if (min != 0) {
				for (int i = j + 1; i < N; i++) {
					if (A[j] < A[i]) {
						if (max == 0) {
							max = B[i];
						} else {
							max = max < B[i] ? max : B[i];
						}
					}
				}
			}
			if (min != 0 && max != 0) {
				tempSum = min + max + B[j];
				sum = sum==-1? tempSum : (sum > tempSum ? tempSum : sum);
			}
		}
		return sum;
	}

}
