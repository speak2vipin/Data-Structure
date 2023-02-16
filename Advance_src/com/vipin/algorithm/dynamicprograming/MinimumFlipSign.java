package com.vipin.algorithm.dynamicprograming;

import java.util.Arrays;
import java.util.List;

public class MinimumFlipSign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer dp[][] = new Integer[1][1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		System.out.println(dp[0]);
	}
	
	public int solve(final List<Integer> A) {
		int sum = 0;
		for(Integer temp : A) {
			sum+=temp;
		}
		int x = A.size();
		int y;
		if(sum%2==0) {
			y = sum/2 - 1;
		} else {
			y = sum/2;
		}
		int dp[][] = new int[x+1][y+1];
		for(int j=0; j<y+1; j++) {
			dp[0][j] = 10001;
		}
		Arrays.fill(dp, Integer.MAX_VALUE);
		for(int i=1; i<x+1; i++) {
			int temp = A.get(i-1);
			for(int j=1; j<y+1; j++) {
				if(A.get(i-1)>j) {
					dp[i][j] = dp[i-1][j];
					
				} else {
					dp[i][j] = 
							Math.min(dp[i-1][j], 1 + dp[i-1][j-A.get(i-1)]);
				}
			}
		}
		return dp[x][y];

    }

}
