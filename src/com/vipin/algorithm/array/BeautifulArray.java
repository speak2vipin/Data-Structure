package com.vipin.algorithm.array;

import java.util.PriorityQueue;

public class BeautifulArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 7, 7, 2, 7};
		int k = 9;
		System.out.println(minIncrementOperations(nums, k));
	}

	public static long minIncrementOperations(int[] nums, int k) {
        long ans = 0;
        int n = nums.length;
        long dp[] = new long[n];
        dp[0] = Math.max(0l, k-nums[0]);
        dp[1] = Math.max(0l, k-nums[1]);
        dp[2] = Math.max(0l, k-nums[2]);
        
        for(int i=3; i<n; i++) {
            dp[i] = 
                Math.min(dp[i-3], Math.min(dp[i-2], dp[i-1])) + Math.max(0, k-nums[i]);
        }
        return Math.min(Math.min(dp[n-3], dp[n-2]), dp[n-1]);     
    }

}
