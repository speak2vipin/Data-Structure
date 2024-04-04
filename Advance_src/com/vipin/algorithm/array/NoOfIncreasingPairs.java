package com.vipin.algorithm.array;

import java.util.Arrays;

public class NoOfIncreasingPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A[][] = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
		System.out.println(findLongestChain(A));
		System.out.println(findLongestChainDP(A));
		System.out.println(solve("0100000100"));
	}

	public static int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, (x, y) -> (x[1] - y[1]));
		int n = pairs.length;
		int j = 1;
		int prev = pairs[0][1];
		int count = 1;
		while (j < n) {
			if (pairs[j][0] > prev) {
				count++;
				prev = pairs[j][1];
			}
			j++;
		}
		return count;

	}

	public static int solve(int i, int prev, int[][] pairs, int n, int[][] dp) {
		if (i == n)
			return 0;

		if (dp[i][prev + 1] != -1)
			return dp[i][prev + 1];

		int pick = -1000000000;

		if (prev == -1 || pairs[prev][1] < pairs[i][0])
			pick = 1 + solve(i + 1, i, pairs, n, dp);
		int not_pick = solve(i + 1, prev, pairs, n, dp);

		return dp[i][prev + 1] = Math.max(pick, not_pick);
	}

	public static int findLongestChainDP(int[][] pairs) {
		int n = pairs.length;
		Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
		int[][] dp = new int[n][n + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return solve(0, -1, pairs, n, dp);
	}
	
	public static int solve(String A) {
        int res = 0;
        int n = A.length();
        int index = 0;
        for(int i=n-1; i>-1; i--) {
            if(A.charAt(i)=='0') {
                res = res + (1<<index);
            }
            index++;
        }
        return res;
    }

}
