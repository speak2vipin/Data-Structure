package com.vipin.algorithm.dp;

import java.util.Arrays;

public class Number_of_Dice_Rolls_With_Target_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Number_of_Dice_Rolls_With_Target_Sum n = new Number_of_Dice_Rolls_With_Target_Sum();
		System.out.println(n.numRollsToTarget(2, 6, 7));
	}
	int dp[][] = null;
    int mod = 1000_000_007;

	public int numRollsToTarget(int n, int k, int target) {
		dp = new int[n+1][target+1];
        //for(int d[] : dp) {
          //  Arrays.fill(d, -1);
        //}
        dp[0][0] = 1;
        //return bootomUp(n, k, target);
        return topDown(n, k, target);
    }
    
    int helper(int n, int k, int target) {
        if(n<0 || target<0) {
            return 0;
        }
        if(dp[n][target]!=-1) {
            return dp[n][target];
        }
        int ways = 0;
        for(int i=1; i<=k; i++) {
            if(i<=target) {
                ways = (ways + helper(n-1, k, target-i))%mod;
            }
        }
        return dp[n][target] = ways;
    }
    
    int topDown(int n, int f, int target) {
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<target+1; j++) {
                int ways = 0;
                for(int k=1; k<f+1; k++) {
                    if(k<=j) {
                        ways = (ways + dp[i-1][j-k])%mod;;
                    }
                }
                dp[i][j] = ways;
            }
        }
        return dp[n][target];
    }
}
