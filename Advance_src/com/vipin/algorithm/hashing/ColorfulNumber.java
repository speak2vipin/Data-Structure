package com.vipin.algorithm.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ColorfulNumber c = new ColorfulNumber();
		System.out.println(c.colorful(3245));
		
		int A[] = {2,1,2};
		System.out.println(c.noOfSubArray(A));

	}

	public int colorful(int A) {
		ArrayList<Integer> list = new ArrayList<>();
		HashSet<Integer> set = new HashSet<>();
		while (A > 0) {
			list.add(A % 10);
			A = A / 10;
		}
		int N = list.size();
		for (int i = 0; i < N; i++) {
			int prod = 1;
			for (int j = i; j < N; j++) {
				prod = prod * list.get(j);
				if (set.contains(prod)) {
					return 0;
				}
				set.add(prod);
			}
		}
		return 1;
	}

	public int noOfSubArray(int[] A) {
		Set<Integer> set = new HashSet<Integer>();
		long ans = 0;
		int mod = 1000_000_007;
		int i = 0, j = 0;
		int N = A.length;
		while (j < N) {
			while (!set.add(A[j])) {
				set.remove(A[i++]);
			}
			ans = (ans%mod + (j-i+1)%mod)%mod;
			j++;
		}
		return (int) ans;

	}

}


class Solution {
    int mod = 1000000007;
    int[][][] memo = new int[101][101][101];
    
    int find(int pos, int count, int profit, int n, int minProfit, int[] group, int[] profits) {
        if (pos == group.length) {
            // If profit exceeds the minimum required; it's a profitable scheme.
            return profit >= minProfit ? 1 : 0;
        }
        
        if (memo[pos][count][profit] != -1) {
            // Repeated subproblem, return the stored answer.
            return memo[pos][count][profit];
        }
        
        // Ways to get a profitable scheme without this crime.
        int totalWays = find(pos + 1, count, profit, n, minProfit, group, profits);
        if (count + group[pos] <= n) {
            // Adding ways to get profitable schemes, including this crime.
            totalWays += find(pos + 1, count + group[pos], Math.min(minProfit, profit + profits[pos]), n, minProfit, group, profits);
        }
        
        return memo[pos][count][profit] = totalWays % mod;
    }
    
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        // Initializing all states as -1.
        for (int i = 0; i <= group.length; i++) {
            for(int j = 0; j <= n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        
        return find(0, 0, 0, n, minProfit, group, profit);
    }
    
    class Solution {
        int mod = 1000000007;
        int[][][] dp = new int[101][101][101];

        public int profitableSchemes(int n, int minProfit, int[] group, int[] profits) {
            // Initializing the base case.
            for (int count = 0; count <= n; count++) {
                dp[group.length][count][minProfit] = 1;
            }

            for (int index = group.length - 1; index >= 0; index--) {
                for (int count = 0; count <= n; count++) {
                    for(int profit = 0; profit <= minProfit; profit++) {
                        // Ways to get a profitable scheme without this crime.
                        dp[index][count][profit] = dp[index + 1][count][profit];
                        if (count + group[index] <= n) {
                            // Adding ways to get profitable schemes, including this crime.
                            dp[index][count][profit]
                                    = (dp[index][count][profit] + 
                                    		dp[index + 1][count + group[index]][Math.min(minProfit, profit + profits[index])]) % mod;
                        }
                    }
                }
            }

            return dp[0][0][0];
        }
    }
    
    
}
