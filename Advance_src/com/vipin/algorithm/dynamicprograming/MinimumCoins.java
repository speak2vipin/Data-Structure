package com.vipin.algorithm.dynamicprograming;

import java.util.Arrays;

public class MinimumCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins[] = { 2 };
		int MinimumCoins = 3;
		MinimumCoins m = new MinimumCoins();
		System.out.println(m.coinChange(coins, MinimumCoins));
	}

	public int coinChange(int[] coins, int amount) {
		int dp[] = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			int temp = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (i < coins[j]) {
					continue;
				} else {
					if(dp[Math.max(0, i - coins[j])] !=-1)
					      temp = Math.min(temp, dp[Math.max(0, i - coins[j])] + 1);
				}
			}
			dp[i] = (temp == Integer.MAX_VALUE) ? -1 : temp;
		}
		return dp[amount];

	}

	public int coinChange1(int[] coins, int amount) {
		if (coins == null || coins.length == 0)
			return -1;
		if (amount == 0)
			return 0;
		int[] temp = new int[amount + 1];
		Arrays.fill(temp, -1);
		temp[0] = 0;
		for (int c : coins)
			if (c >= 0 && c <= amount)
				temp[c] = 1;
		for (int n = 1; n <= amount; n++) {
			if (temp[n] != -1)
				continue;
			temp[n] = Integer.MAX_VALUE;
			for (int c : coins) {
				if (n - c >= 0 && temp[n - c] != -1)
					temp[n] = Math.min(temp[n], temp[n - c] + 1);
			}
			if (temp[n] == Integer.MAX_VALUE)
				temp[n] = -1;
		}
		return temp[amount];
	}
}
