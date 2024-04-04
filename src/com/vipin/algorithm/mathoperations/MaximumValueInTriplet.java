package com.vipin.algorithm.mathoperations;

public class MaximumValueInTriplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// max -> (nums[i]-nums[j]) * num[k]
		int nums[] = {12,6,1,2,7};
		System.out.println(maximumTripletValue(nums));
				
	}
	
	public static long maximumTripletValue(int[] A) {
		long res = 0;
		long maxab = 0;
		long maxa = 0;
		for(int a : A) {
			res = Math.max(res, 1l*maxab*a);
			maxab = Math.max(maxab, maxa-a);
			maxa = Math.max(maxa, a);
		}
		return res;
	}
}
