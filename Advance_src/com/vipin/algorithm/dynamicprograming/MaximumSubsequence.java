package com.vipin.algorithm.dynamicprograming;

import java.util.Arrays;

public class MaximumSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,5,7,8,5,3,4,2,1};
		int difference = -2;
		MaximumSubsequence m = new MaximumSubsequence();
		System.out.println(m.longestSubsequence(arr, difference));
	}
	
	public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        int res = helper(dp, arr, 1, difference, n);
        return res==0?1:res+1;
    }
    
    int helper(int dp[], int arr[], int index, int difference, int n) {
        if(index==n) {
            return 0;
        }
        if(dp[index]!=-1) {
            return dp[index];
        }
        int count = 0;
        if(arr[index]-arr[index-1]==difference) {
            count = 1 + helper(dp, arr, index+1, difference, n);
        } else {
            count = helper(dp, arr, index+1, difference, n);
        }
        return dp[index] = count;
    }
}
