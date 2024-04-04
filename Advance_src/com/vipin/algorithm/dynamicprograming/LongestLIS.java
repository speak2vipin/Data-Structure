package com.vipin.algorithm.dynamicprograming;

import java.util.Arrays;

public class LongestLIS {

	public static void main(String[] args) {
		int nums[] = {1,3,5,4,7};
		
		System.out.println(findNumberOfLIS(nums));
	}
	static int max = 1;
	public static int findNumberOfLIS(int[] nums) {
        int l = nums.length;
        int dp[] = new int[l];
        Arrays.fill(dp, 0);
        helper(nums, l-1, dp);
        int res = 0;
        for(int val : dp) {
        	if(val==max) {
        		res++;
        	}
        }
        return res;
    }
    
    static int helper(int nums[], int index, int dp[]) {
        if(index==0) {
        	return dp[index] = 1;
        }
        if(dp[index]!=0) {
            return dp[index];
        }
        int temp = 1;
        if(nums[index]>nums[index-1]) {
            temp = 1 + helper(nums, index-1, dp);
        } else {
            temp = helper(nums, index-1, dp);
        }
        max = Math.max(max, temp); 
        return dp[index] = temp;
    }
}

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] length = new int[n];
        int[] count = new int[n];
        
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = 0;
                    }
                    if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }
        
        int maxLength = 0;
        int result = 0;

        for (int len : length) {
            maxLength = Math.max(maxLength, len);
        }

        for (int i = 0; i < n; i++) {
            if (length[i] == maxLength) {
                result += count[i];
            }
        }
        
        return result;
    }
}
