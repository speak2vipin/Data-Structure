package com.vipin.algorithms.array;

public class IncreasingTriplets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []A = {1, 2, 4, 3};
		int []B = {2, 1, 2, 3};
		System.out.println(solve(A));
		System.out.println(solve(B));

	}

	public static int solve(int[] A) {
		
		int N = A.length;
		int sum = 0;
		int[] prefix = new int[N];
		int[] suffix = new int[N];
		for (int i = 1; i < N; i++) {
			int count = 0;
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i]) {
					count++;
				}
			}
			prefix[i] = count;
		}
		for (int i = N - 2; i > -1; i--) {
			int count = 0;
			for (int j = N - 1; j > i; j--) {
				if (A[j] > A[i]) {
					count++;
				}
			}
			suffix[i] = count;
		}

		for (int i = 0; i < N; i++) {
			sum += prefix[i] * suffix[i];
		}
		return sum;
	}

}
