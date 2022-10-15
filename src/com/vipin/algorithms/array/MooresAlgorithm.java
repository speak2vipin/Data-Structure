package com.vipin.algorithms.array;

public class MooresAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.floor(5/2));
		System.out.println(Math.floor(8/6));
		System.out.println(Math.floor(8/5));
		System.out.println(2>(8/5));
	}

	public static int majorityElement(final int[] A) {
		int N = A.length;
		int ans = A[0];
		int count = 1;
		// Implementation of Moore's algorithm. Deleting elemnt in pair
		for (int i = 1; i < N; i++) {
			if (A[i] == ans) {
				count++;
			} else if (count != 0) {
				count--;
			} else {
				ans = A[i];
				count = 1;
			}
		}
		// Moores' algorithm is not always right so just to double check whether answer
		// is correct only or not.
		for (int i = 0; i < N; i++) {
			if (A[i] == ans) {
				count++;
			}
		}
		if (count > Math.floor(N/2)) {
			return ans;
		}
		return -1;
	}

}
