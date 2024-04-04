package com.vipin.algorithm.dp;

import java.util.Arrays;

public class Dp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dp dp = new Dp();
		int a[] = {1,2,3,4,1};
		System.out.println(dp.minCost("aabaa", a));
	}

	int dp[] = null;

	public int minCost(String colors, int[] neededTime) {
		int n = colors.length();
		dp = new int[n];
		Arrays.fill(dp, -1);
		//return helper(colors, neededTime, 0);
		return topDown(colors, neededTime, n-1, 0, 'A');
		//return calculateMinCost(n-1, colors, neededTime, dp, 'A', 0);
	}

	int helper(String c, int[] n, int i) {
		if (i >= n.length) {
			return 0;
		}
		if (dp[i] != -1) {
			return dp[i];
		}
		int val1 = Integer.MAX_VALUE;
		int val2 = Integer.MAX_VALUE;
		for (int j = i; j < c.length(); j++) {
			if (j + 1 < c.length() && c.charAt(j) == c.charAt(j + 1)) {
				val1 = n[j] + helper(c, n, j + 2);
				val2 = n[j + 1] + helper(c, n, j + 2);
			}
		}
		return dp[i] = ((val1 == val2) && (val1 == Integer.MAX_VALUE)) ? 0 : Math.min(val1, val2);
	}
	
	int bottomUp(String c, int[]time) {
		int N = c.length();
		int dp[] = new int[N+1];
		char prevLetter = 'A';
		int prevTime = 0;
		
		for(int i=1; i<=N; i++) {
			if(c.charAt(i-1)==prevLetter) {
				dp[i] = dp[i-1] + Math.min(prevTime, time[i-1]);
				prevTime = Math.max(prevTime, time[i-1]);
			} else {
				dp[i] = dp[i-1];
				prevLetter = c.charAt(i-1);
				prevTime = time[i-1];
			}
		}
		return dp[N];
	}
	int topDown(String s, int time[], int index, int prevTime, char prevLetter) {
        if(index<0) {
            return 0;
        }
        if(dp[index]!=-1) {
            return dp[index];
        }
        if(s.charAt(index)==prevLetter) {
            return dp[index] = topDown(s, time, index-1, Math.max(prevTime, time[index]) ,prevLetter) + Math.min(prevTime, time[index]);
            // Hold the maximum value and add minimum value to the cost
        } else {
            return dp[index] =  topDown(s, time, index-1, time[index], s.charAt(index));
        }
    }
	private int calculateMinCost(int i, String colorSequence, int[] timeRequired, int[] memo, char previousColor, int previousTime) {
        if (i < 0) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        if (colorSequence.charAt(i) == previousColor) {
            return memo[i] = calculateMinCost(i - 1, colorSequence, timeRequired, memo, colorSequence.charAt(i), Math.max(timeRequired[i], previousTime)) + Math.min(timeRequired[i], previousTime);
        } else {
            return memo[i] = calculateMinCost(i - 1, colorSequence, timeRequired, memo, colorSequence.charAt(i), timeRequired[i]);
        }
    }
	
	class Solution {
	    public boolean checkValidString(String s) {
	        int n = s.length();
	        if (n == 0) return true;
	        boolean[][] dp = new boolean[n][n];

	        for (int i = 0; i < n; i++) {
	            if (s.charAt(i) == '*') dp[i][i] = true;
	            if (i < n-1 &&
	                    (s.charAt(i) == '(' || s.charAt(i) == '*') &&
	                    (s.charAt(i+1) == ')' || s.charAt(i+1) == '*')) {
	                dp[i][i+1] = true;
	            }
	        }

	        for (int size = 2; size < n; size++) {
	            for (int i = 0; i + size < n; i++) {
	                if (s.charAt(i) == '*' && dp[i+1][i+size] == true) {
	                    dp[i][i+size] = true;
	                } else if (s.charAt(i) == '(' || s.charAt(i) == '*') {
	                    for (int k = i+1; k <= i+size; k++) {
	                        if ((s.charAt(k) == ')' || s.charAt(k) == '*') &&
	                                (k == i+1 || dp[i+1][k-1]) &&
	                                (k == i+size || dp[k+1][i+size])) {
	                            dp[i][i+size] = true;
	                        }
	                    }
	                }
	            }
	        }
	        return dp[0][n-1];
	    }
	}

}
