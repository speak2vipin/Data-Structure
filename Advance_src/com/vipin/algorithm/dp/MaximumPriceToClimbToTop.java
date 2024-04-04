package com.vipin.algorithm.dp;

import java.util.Arrays;

public class MaximumPriceToClimbToTop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {8,12,4,3,5};
		System.out.println(solve(A));
	}
	
	 public static int solve(int[] A) {
	        int n = A.length;
	        int dp[] = new int[n];
	        Arrays.fill(dp, -1);
	        return max(0, n, dp, A);
	    }
	    
	    static int max(int index, int last, int dp[], int A[]) {
	        if(index>=last) {
	            return 0;
	        }
	        if(dp[index]!=-1) {
	            return dp[index];
	        }
	        dp[index] = Math.min(A[index] + max(index+2, last, dp, A), max(index+1, last, dp, A));
	        return dp[index];
	    }

}
