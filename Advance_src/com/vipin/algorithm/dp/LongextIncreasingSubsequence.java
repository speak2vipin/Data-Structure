package com.vipin.algorithm.dp;

import java.util.Arrays;

import com.vipin.algorithm.tree.MaximumPath;

public class LongextIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LongextIncreasingSubsequence lis = new LongextIncreasingSubsequence();
		int nums1[] = {1,3,7,1,7,5}; 
		int nums2[] = {1,9,2,5,1};
		System.out.println(lis.maxUncrossedLines(nums1, nums2));

	}

	int dp[][] = null;

	public int maxUncrossedLines(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		dp = new int[len1][len2];
		for(int x[] : dp) {
			Arrays.fill(x, -1);
		}
		helper(nums1, nums2, 0, 0);
		return dp[0][0];

	}

	int helper(int num1[], int num2[], int i, int j) {
		if (i == num1.length || j == num2.length) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		int val = 0;
		if (num1[i] == num2[j]) {
			val = 1 + helper(num1, num2, i + 1, j + 1);
		} else {
			val = Math.max(helper(num1, num2, i + 1, j), helper(num1, num2, i, j + 1));
		}
		return dp[i][j] = val;
	}

}
