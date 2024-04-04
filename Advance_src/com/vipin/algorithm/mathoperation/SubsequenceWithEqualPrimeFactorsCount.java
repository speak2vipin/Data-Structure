package com.vipin.algorithm.mathoperation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubsequenceWithEqualPrimeFactorsCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {2, 3, 2, 3};
		SubsequenceWithEqualPrimeFactorsCount s = new SubsequenceWithEqualPrimeFactorsCount();
		System.out.println(s.solve(A));

	}
	
	public int solve(int[] A) {
        int n = A.length;
        int maxNum = Integer.MIN_VALUE;
        for(int a : A) {
            maxNum = Math.max(maxNum, a);
        }
       
        int primeFactorsCount[] = populatePrimeFactors(maxNum);
        
        int B[] = new int [n];
        for(int i=0; i<n; i++) {
            B[i] = primeFactorsCount[A[i]];
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for(int i=0; i<n; i++) {
            if(B[i]!=0) {
                freq.put(B[i], freq.getOrDefault(B[i], 0)+1);
            }
        }
        int mod = (int) (1e9+7);
        int res = 0;
        for(int key : freq.keySet()) {
            int val = freq.get(key);
            res = (res + (2<<(val-1)) - 1)%mod;
        }
        return res;
    }

    int [] populatePrimeFactors(int n) {
        int sieve[] = calulateSieve(n);

        int primeFactors[] = new int[n+1];
        for(int i=2; i<=n; i++) {
            if(sieve[i]==1) {
                primeFactors[i] = primeFactors[i-1] + 1;
            } else {
                primeFactors[i] = primeFactors[i-1];
            }
        }
        return primeFactors;
    }

    int [] calulateSieve(int num) {
        int sieve[] = new int[num+1];
        Arrays.fill(sieve, 1);
        for(int i=2; i*i<=num; i++) {
            if(sieve[i]==1) {
                for(int j=2*i; j<=num; j+=i) {
                    sieve[j] = 0;
                }
            }
        }
        return sieve;
    }

}

 class Solution {
	   

		public int solve(int[] A, int[] B, int C) {
			int N = A.length;
			int totalSum = 0;
			for (int a : A) {
				totalSum += a;
			}
			int dp[][] = new int[N + 1][totalSum + 1];
			for (int i = 0; i < N + 1; i++) {
				dp[i][0] = 0;
			}
			for (int j = 1; j < totalSum + 1; j++) {
				dp[0][j] = Integer.MAX_VALUE;
			}

			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < totalSum + 1; j++) {
					int choice = Integer.MAX_VALUE;
					if (j - A[i - 1] >= 0 && dp[i - 1][j - A[i - 1]] != Integer.MAX_VALUE) {
						choice = B[i - 1] + dp[i - 1][j - A[i - 1]];
					}
					dp[i][j] = Math.min(choice, dp[i - 1][j]);
				}
			}
			for (int j = totalSum; j > -1; j--) {
				if (dp[N][j] <= C) {
					return j;
				}
			}
			return 0;
		}
	}
 
