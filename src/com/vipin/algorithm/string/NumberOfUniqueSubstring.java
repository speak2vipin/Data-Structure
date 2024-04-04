package com.vipin.algorithm.string;

import java.util.Arrays;
import java.util.HashSet;

public class NumberOfUniqueSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NumberOfUniqueSubstring n = new NumberOfUniqueSubstring();
		System.out.println(n.partitionString("sssss"));
		n.countMinSquares(5);

	}
	
	public int partitionString(String s) {
        int count = 0;
        int i=0;
        int l = s.length();
        HashSet<Character> set = new HashSet<>();
        while(i<l) { 
        	count++;
            while(i<l) {
                if(set.add(s.charAt(i))) {
                	i++;
                } else {
                	break;
                }
            }
            set.clear();
        }
        return count;  
    }
	
	public int countMinSquares(int A) {
        int dp[] = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1; i<A+1; i++) {
            for(int j=1; j<=Math.sqrt(i); j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i-(j*j)]);
            }
        }
        return dp[A];
    }


}
