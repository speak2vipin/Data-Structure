package com.vipin.algorithm.dp;

import java.util.ArrayList;

public class MonotonousString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MonotonousString m = new MonotonousString();
		System.out.println(m.minFlipsMonoIncr("00110"));
	}
	
	public int minFlipsMonoIncr(String s) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		Integer X[][] = A.toArray(new Integer[4][]);
        int L = s.length();
        int count=0;
        int dp[] = new int[L];  
        if(s.charAt(0)=='1') {
            count++;
        }
        for(int i=1; i<L; i++) {
            if(s.charAt(i)==1) {
                count++;
                dp[i] = dp[i-1];
            } else {
                dp[i] = Math.min(count, dp[i-1]+1);
            }
        }
        return dp[L-1];
    }

}
