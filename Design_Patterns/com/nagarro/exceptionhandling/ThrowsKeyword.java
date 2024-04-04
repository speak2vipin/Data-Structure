package com.nagarro.exceptionhandling;

import java.util.ArrayList;
import java.util.HashMap;

public class ThrowsKeyword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThrowsKeyword t = new ThrowsKeyword();
		System.out.println(t.sum(100, 90));
		int nums[] = { 3, 6, 9, 12 };
		System.out.println(t.longestArithSeqLength(nums));
	}

	public int sum(int x, int y) {
		if (x + y < 200) {
			//throw new IllegalArgumentException();
		}
		return x + y;
	}

	public int longestArithSeqLength(int[] nums) {

		int n = nums.length;
		HashMap<Integer, Integer> dp[] = new HashMap[n];
		int maxLen = Integer.MIN_VALUE;
		for (int right = 0; right < n; right++) {
			HashMap<Integer, Integer> indexMap = new HashMap<>();
			dp[right] = indexMap;
			for (int left = 0; left < right; left++) {
				int diff = nums[right] - nums[left];
				dp[right].put(diff, dp[left].getOrDefault(diff, 1) + 1);
				maxLen = Math.max(maxLen, dp[right].get(diff));
			}
		}
		return maxLen;
	}

}
