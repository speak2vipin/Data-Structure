package com.vipin.algorithm.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DiffOfMaxAndMinInSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {7, 8, 6, 4, 6 };
		DiffOfMaxAndMinInSubsequence d = new DiffOfMaxAndMinInSubsequence();
		System.out.println(d.solve(A));
	}
	//4 6 6
	  //  6
	//4   6
	//4 6 6
	  //6 6
	 
	//4 6
	  //6
	
	
	public int solve(int[] A) {
        Arrays.sort(A);
        long maxSum = 0;
        long minSum = 0;
        long mod = 1000_000_007;
        int N = A.length;
        for(int i=0; i<N; i++) {
        	
        	maxSum = (maxSum + (A[i]*(long)(Math.pow(2, i)))%mod)%mod;
        }
        for(int i=0; i<N; i++) {
        	int index = N-1-i;
        	minSum = (minSum + (A[i]* (long)(Math.pow(2, index)))%mod)%mod;
        }
        return (int)((maxSum - minSum + mod)%mod);
    }

}
