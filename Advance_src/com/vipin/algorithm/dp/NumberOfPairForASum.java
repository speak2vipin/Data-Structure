package com.vipin.algorithm.dp;

import java.util.Arrays;

public class NumberOfPairForASum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = { 1, 2, 3 };
		int target = 4;
		System.out.println(combinationSum4(nums, target));
	}

	public static int combinationSum4(int[] nums, int target) {
		Integer dp[] = new Integer[target + 1];
		helper(dp, 0, target, nums);
		
		System.out.println(countOrders(3));
		return 1;
	}

	static int helper(Integer dp[], int sum, int target, int nums[]) {
        if(sum>target) {
            return 0;
        }
        if(sum==target) {
        	return 1;
        }
        if(dp[sum]!=null) {
            return dp[sum];
        } 
        int currentCombinations = 0;
        for(int i=0; i<nums.length; i++) {
            currentCombinations += helper(dp, sum+nums[i], target, nums);
        }
        return dp[sum]=currentCombinations;
    }
	static long mod = 1000_000_007;
	static public int countOrders(int n) {
        long dp[] = new long[n+1];
        Arrays.fill(dp, -1);
        return memoizationBottomToUp(dp, n);
    }
    
    static int memoizationBottomToUp(long dp[], int n) {
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] * ((2*i-1)*i)%mod;
        }
        return (int)dp[n];
    }
}
