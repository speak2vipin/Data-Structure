package com.vipin.algorithm.dynamicprograming;

public class NumberWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberWithGivenSum n = new NumberWithGivenSum();
		System.out.println(n.solve(3, 3));
	}
	
	public int solve(int A, int B) {
        int dp[][] = new int[A+1][B+1];
        for(int j=1; j<=B; j++) {
            dp[1][j] = 1;
        }
        for(int i=2; i<=A; i++) {
            for(int j=1; j<=B; j++) {
                for(int d=0; d<=9; d++) {
                    if(j>=d) {
                        dp[i][j] = dp[i][j] + dp[i-1][j-d];
                    } 
                }
            }
        }
        return dp[A][B];
    }

}
