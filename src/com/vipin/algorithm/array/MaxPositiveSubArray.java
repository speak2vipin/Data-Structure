package com.vipin.algorithm.array;

public class MaxPositiveSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]A = {1,2,-1,-1,-1,6,7};
		System.out.println(solve(A));

	}

	public static int[] solve(int[] A) {
		int N = A.length;
		int prefix[] = new int[N];
		if (A[0] > 0) {
			prefix[0] = 1;
		} else {
			prefix[0] = 0;
		}
		for (int i = 1; i < N; i++) {
			if (A[i] > 0) {
				prefix[i] = prefix[i - 1] + 1;
			} else {
				prefix[i] = 0;
			}
		}
		int maxSize = prefix[0];
		int index = 0;
		for (int i = 1; i < N; i++) {
			if (maxSize < prefix[i]) {
				maxSize = prefix[i];
				index = i;
			}
		}
		int output[] = new int[maxSize];
		System.arraycopy(A, index + 1 - maxSize, output, 0, maxSize);
		return output;
	}
}
