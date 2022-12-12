package com.vipin.algorithm.array;

public class AbsoluteMaximumWith4ArrayAndOnePairOfIandJ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 1, 2, 3, 4 };
		int B[] = { -1, 4, 5, 6 };
		int C[] = { -10, 5, 3, -8 };
		int D[] = { -1, -9, -6, -10 };
		//System.out.println(solve(A, B, C, D));
		int P[] = { 1, 2 };
		int Q[] = { 3, 6 };
		int R[] = { 10, 11 };
		int S[] = { 1, 6 };
		System.out.println(solve(P, Q, R, S));

	}

	public static int solve(int[] A, int[] B, int[] C, int[] D) {
		int N = A.length;
		int sum = Integer.MIN_VALUE;
		int maxSum=0;
		int minSum=0;
		for (int i = 0; i <= 31; i++) {
			for (int j = 0; j < N; j++) {
				int tempSum = 0;
				maxSum = Integer.MIN_VALUE;
				minSum = Integer.MAX_VALUE;
				if (((i << 0) & 1) == 1) {
					tempSum += A[j];
				} else {
					tempSum += (-1) * A[j];
				}
				if (((i << 1) & 1) == 1) {
					tempSum += B[j];
				} else {
					tempSum += -1 * B[j];
				}
				if (((i << 2) & 1) == 1) {
					tempSum += C[j];
				} else {
					tempSum += -1 * C[j];
				}
				if (((i << 3) & 1) == 1) {
					tempSum += D[j];
				} else {
					tempSum += -1 * D[j];
				}
				if (((i << 4) & 1) == 1) {
					tempSum += j;
				} else {
					tempSum += (-1) * j;
				}
				maxSum = Math.max(maxSum, tempSum);
				minSum = Math.min(minSum, tempSum);

			}
			sum = Math.max(sum, maxSum-minSum);
			

		}
		return sum;
	}

}
