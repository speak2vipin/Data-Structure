package com.vipin.algorithm.dynamicprograming;

import java.util.ArrayList;
import java.util.List;

public class FlipSignToMakeItMinNonNegative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = new ArrayList<Integer>();
		A.add(10);
		A.add(4);
		A.add(3);
		A.add(2);
		A.add(1);
		FlipSignToMakeItMinNonNegative f = new FlipSignToMakeItMinNonNegative();
		System.out.println(f.solve(A));

	}

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int solve(final List<Integer> A) {
		int sum = 0;
		for (Integer temp : A) {
			sum += temp;
		}
		int x = A.size();
		int y;
		if (sum % 2 == 0) {
			y = sum / 2;
		} else {
			y = sum / 2;
		}
		int dp[][] = new int[x + 1][y + 1];
		for (int j = 0; j < y + 1; j++) {
			dp[0][j] = 10001;
		}
		// Arrays.fill(dp, Integer.MAX_VALUE);
		for (int i = 1; i < x + 1; i++) {
			int currValue = A.get(i - 1);
			for (int j = 0; j < y + 1; j++) {
				if (currValue > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i - 1][j - currValue]);
				}
			}
		}
		while (dp[x][y] == 10001) {
			y--;
		}
		
		int sum = 0;
		for (Integer e : A) {
			sum += e;
		}
		int n = A.size();
		sum = sum / 2;
		int dp[][] = new int[n + 1][sum + 1];
		for (int i = 1; i <= sum; i++)
			dp[0][i] = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				dp[i][j] = dp[i - 1][j];
				int val = A.get(i - 1);
				if (j >= val && dp[i - 1][j - val] != Integer.MAX_VALUE) {
					dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j - val]);
				}
			}
		}
		int i = sum;
		while (dp[n][sum] == Integer.MAX_VALUE) {
			sum--;
		}
		return dp[n][sum];
		return dp[x][y];
	}

	public int solveAnother(final List<Integer> A) {
		int sum = 0;
		for (Integer e : A) {
			sum += e;
		}
		int n = A.size();
		sum = sum / 2;
		int dp[][] = new int[n + 1][sum + 1];
		for (int i = 1; i <= sum; i++)
			dp[0][i] = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				dp[i][j] = dp[i - 1][j];
				int val = A.get(i - 1);
				if (j >= val && dp[i - 1][j - val] != Integer.MAX_VALUE) {
					dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j - val]);
				}
			}
		}
		int i = sum;
		while (dp[n][sum] == Integer.MAX_VALUE) {
			sum--;
		}
		return dp[n][sum];
	}
	
	public int solve(final int[] A) {

        int sum = 0;
        for(int val : A){
            sum += val;
        }

        sum = sum / 2;

        int[][] dp = new int[A.length + 1][sum + 1];
        
        /**
        *   With no element the value will be infinite 
        *   Note: Try to avoid Integer.MAX_VALUE
        */
        for(int j = 0 ; j < dp[0].length ; j++){
            dp[0][j] = 9999999;
        }

        /**
        *   Intention is to find the Minimum element to form the sum as (Total sum / 2)
        *   
        *   Meaning Each cell of DP Array: For the current sum [col] and till current elements [row] what is the Minimum elements needed.
        *   Simple Knap Sack Logic
        */
        for(int i = 1 ; i < dp.length ; i++){
            int currentVal = A[i - 1];
            for(int j = 1 ; j < dp[i].length ; j++){
                if(j < currentVal){
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i - 1][j] , 1 + dp[i - 1][j - currentVal]);
                }
            }
        }


        // for(int[] arr : dp){
        //     System.out.println(Arrays.toString(arr));
        // }


       // If the total sum can't be make into half equal sum then look for the sum which can be made using all the values 
       // by moving twards the left from the bottom right corner 
        while (dp[A.length][sum] == 9999999) {
            sum--;
        }

        return dp[A.length][sum];
    }

}
