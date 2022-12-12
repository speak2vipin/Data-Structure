package com.vipin.algorithm.hashing;

import java.util.HashSet;
import java.util.Set;

public class MaximumScoreSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int nums[] = {4,2,4,5,6};
		int nums[] = {187,470,25,436,538,809,441,167,477,110,275,133,666,345,411,459,490,266,987,965,
				429,166,809,340,467,318,125,165,809,610,31,585,970,306,42,189,169,743,78,810,70,382,
				367,490,787,670,476,278,775,673,299,19,893,817,971,458,409,886,434};
		System.out.println(maximumUniqueSubarray(nums));
	}

	public static int maximumUniqueSubarray(int[] nums) {
		int score = 0;
		int maxScore = 0;
		int j=0;
		Set<Integer> intSet = new HashSet<Integer>();
		int i = 0;
		while(i<nums.length) {
			if (intSet.add(nums[i])) {
				score += nums[i];
				i++;
			} else {
				maxScore = score > maxScore ? score : maxScore;
				intSet.remove(nums[j]);
				score-=nums[j];
				j++;
			}	
		}
		maxScore = score > maxScore ? score : maxScore;
		return maxScore;

	}

}
