package com.vipin.algorithm.sorting;

import java.util.Arrays;

public class PaintiangWalls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int paintWalls(int[] cost, int[] time) {
		int n = cost.length;
		int dp[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[i] = new int[] { cost[i], time[i] };
		}
		Arrays.sort(dp, (x, y) -> x[0] - y[0]);
		int m = ((n % 2) == 0 ? (n / 2) : (n / 2) + 1);
		int res = 0;
		for (int i = 0; i < m; i++) {
			res += dp[i][0];
		}
		return res;
	}

}
