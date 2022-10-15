package com.vipin.algorithms.array;

public class MultiplyRestElementOfArrayWithoutDivision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1,2,3,4, 5};
		System.out.println(solve(A));

	}

	public static int[] solve(int[] A) {
		int N = A.length;
		int ANS[] = new int[N];
		int prefix[] = new int[N];
		int suffix[] = new int[N];
		prefix[0] = A[0];
		for (int i = 1; i < N; i++) {
			prefix[i] = prefix[i - 1] * A[i];
		}
		suffix[N - 1] = A[N - 1];
		for (int i = N - 2; i > -1; i--) {
			suffix[i] = suffix[i + 1] * A[i];
		}
		ANS[0] = suffix[1];
		ANS[N - 1] = prefix[N - 2];
		for (int i = 1; i < N - 2; i++) {
			ANS[i] = prefix[i - 1] + suffix[i + 1];
		}
		return ANS;
	}

}
