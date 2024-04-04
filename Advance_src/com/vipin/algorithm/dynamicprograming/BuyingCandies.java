package com.vipin.algorithm.dynamicprograming;

import java.util.Arrays;

public class BuyingCandies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 2 };
		int B[] = { 5 };
		int C[] = { 10 };
		int D = 99;
		BuyingCandies b = new BuyingCandies();
		System.out.println(b.solve(A, B, C, D));
		int[] input = {-1,-8,0,5,-9};
		System.out.println(b.maxSatisfaction(input));
		System.out.println(b.maxSatisfactionDP(input));
	}

	public int solve(int[] A, int[] B, int[] C, int D) {
		int N = C.length;
		int dp[] = new int[D + 1];
		for (int i = 1; i <= D; i++) {
			int temp = Integer.MIN_VALUE;
			for (int j = 0; j < N; j++) {
				if (C[j] <= i) {
					int sweetness = A[j] * B[j] + dp[i - C[j]];
					temp = Math.max(temp, sweetness);
				}
			}
			dp[i] = (temp == Integer.MIN_VALUE) ? 0 : temp;
		}
		return dp[D];
	}
	
	
	    public int maxSatisfaction(int[] satisfaction) {
	       /*( Arrays.sort(satisfaction);

	        int maxSatisfaction = 0;
	        int suffixSum = 0;
	        for (int i = satisfaction.length - 1; i >= 0 && suffixSum + satisfaction[i] > 0; i--) {
	            // Total satisfaction with all dishes so far.
	            suffixSum += satisfaction[i];
	            // Adding one instance of previous dishes as we add one more dish on the left.
	            maxSatisfaction +=  suffixSum;
	        }
	        return maxSatisfaction;
	        */
	    	 Arrays.sort(satisfaction);
	         int N = satisfaction.length;
	         int maxSatisfaction = 0;
	         int tempSatisfaction = 0;
	         for(int i=N-1; i>=0; i--) {
	             if(tempSatisfaction+satisfaction[i]>=0) {
	                 tempSatisfaction += satisfaction[i];
	                 maxSatisfaction += tempSatisfaction;
	             }
	         }
	         return maxSatisfaction;
	    
	}
	    
	    
	        public int maxSatisfactionDP(int[] satisfaction) {
	            Arrays.sort(satisfaction);
	            
	            int[][] dp = new int[satisfaction.length + 1][satisfaction.length + 2];
	            // Mark all the states initially as 0.
	            for (int i = 0; i <= satisfaction.length; i++) {
	                Arrays.fill(dp[i], 0);
	            }
	            
	            for (int i = satisfaction.length - 1; i >= 0; i--) {
	                for (int j = 1; j <= satisfaction.length; j++) {
	                    // Maximum of two choices:
	                    // 1. Cook the dish at `index` with the time taken as `time` and move on to the next dish with time as time + 1.
	                    // 2. Skip the current dish and move on to the next dish at the same time.
	                    dp[i][j] = Math.max(satisfaction[i] * j + dp[i + 1][j + 1], dp[i + 1][j]);
	                }
	            }
	            
	            return dp[0][1];
	        
	    }

}



class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        boolean dp[][][] = new boolean[n + 1][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n + 1 - length; i++) {
                for (int j = 0; j < n + 1 - length; j++) {
                    for (int newLength = 1; newLength < length; newLength++) {
                        boolean dp1[] = dp[newLength][i];
                        boolean dp2[] = dp[length - newLength][i + newLength];
                        dp[length][i][j] |= dp1[j] && dp2[j + newLength];
                        dp[length][i][j] |= dp1[j + length - newLength] && dp2[j];
                    }
                }
            }
        }
        return dp[n][0][0];
    }
}
