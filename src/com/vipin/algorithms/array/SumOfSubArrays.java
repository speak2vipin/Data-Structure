package com.vipin.algorithms.array;

public class SumOfSubArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static long subarraySum(int[] A) {
        long ans = 0L;
        int len = A.length;
        for(int i=0;i<len;i++) {
            ans += A[i]*(i+1)*(len-i);
        }
        return ans;
    }

}
