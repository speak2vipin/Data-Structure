package com.vipin.algorithm.sorting;

import java.util.Arrays;

public class MinAndMaxContest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {Integer.MIN_VALUE,3,Integer.MAX_VALUE};
		System.out.println(solve(A));

	}
	
	public static int[] solve(int[] A) {
        Arrays.sort(A);
        int mod = 1000000007;
        long max = 0;
        long min = 0;
        int N = A.length;
        for(int i=0; i<(N/2); i++) {
            max = (max + (Math.abs((long)A[i]-(long)A[N-1-i]))%mod)%mod;
        }
        for(int i=N-1; i>0; i=i-2) {
            min = (min + (Math.abs((long)A[i]- (long)A[i-1]))%mod)%mod;
        }
        int ans[] = new int[2];
        ans[0] = (int)max%mod;
        ans[1] = (int)min%mod;
        
        return ans;
    }

}
