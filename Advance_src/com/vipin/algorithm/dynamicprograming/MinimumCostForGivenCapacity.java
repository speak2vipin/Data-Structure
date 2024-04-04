package com.vipin.algorithm.dynamicprograming;

public class MinimumCostForGivenCapacity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 2, 3, 1, 5, 4 };
		int B[] = { 3, 2, 4, 1 };
		int C[] = { 1, 2, 5, 10 };
		
		MinimumCostForGivenCapacity m = new MinimumCostForGivenCapacity();
		System.out.println(m.solve(A, B, C));
	}

	public int solve(final int[] A, final int[] B, final int[] C) {
		int N = B.length;
		int max_capacity = Integer.MIN_VALUE;

		for (int capacity : A) {
			max_capacity = Math.max(max_capacity, capacity);
		}

		//int minCost = Integer.MAX_VALUE;
		//for (int cost : C) {
			//minCost = Math.min(minCost, cost);
		//}

		int dp[] = new int[max_capacity + 1];

		for (int j = 1; j <= max_capacity; j++) {
			int cost = Integer.MAX_VALUE;
			for (int k = 0; k < N; k++) {
				if (B[k] <= j) {
					int temp = C[k] + dp[j - B[k]];
					cost = Math.min(cost, temp);
				}
			}
			dp[j] = cost;
		}
		int ans = 0;
		for(int capacity : A) {
			ans += dp[capacity];
		}
		return ans;
	}
}
