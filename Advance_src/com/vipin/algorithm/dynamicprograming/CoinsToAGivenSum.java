package com.vipin.algorithm.dynamicprograming;

public class CoinsToAGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 9;
		int sum = 30;
		int[] coins = { 3, 14, 2, 4, 8, 5, 6, 11, 13 };
		CoinsToAGivenSum c = new CoinsToAGivenSum();
		System.out.println(c.count(coins, N, sum));
		System.out.println(c.tabulation(coins, N, sum));
	}

	long dp[] = null;
	public long count(int coins[], int N, int sum) {
		long total = 0;
		return helper(coins, sum, N-1);
	}

	long helper(int coins[], int sum, int index) {
		if (index<0 || sum<0) {
			return 0;
		}
		if (sum==0) {
			return 1;
		}
		return helper(coins, sum-coins[index], index) + helper(coins, sum, index-1);
	}
	
	long tabulation(int coins[],  int n, int sum) {
		int dp[][] = new int[n+1][sum+1];
		dp[0][0] = 1;
		for(int i=1; i<=n; i++) {
			for(int j=0; j<sum+1; j++) {
				dp[i][j] += dp[i-1][j];
				if(j-coins[i-1]>=0) {
					dp[i][j] += dp[i][j-coins[i-1]];
				}
			}
		}
		return dp[n][sum];
	}

}
