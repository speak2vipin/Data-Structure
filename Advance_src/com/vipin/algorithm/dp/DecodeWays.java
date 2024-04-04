package com.vipin.algorithm.dp;

public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeWays d = new DecodeWays();
		System.out.println(d.numDecodings("10"));

	}

int dp[] = null;
    
    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n];
        
        helper(s, 0);
        return dp[0];
    }
    
    int helper(String s, int i) {
        if(i>=s.length()) {
            return 1;
        }
        if(dp[i]>0) {
            return dp[i];
        }
        if(s.charAt(i)=='0') {
            return 0;
        }
        int ways = helper(s, i+1);
        if(i+1<s.length() && Integer.parseInt(s.substring(i, i+2))<=26){
        	ways += helper(s, i+2);
        }
        return  dp[i] = ways;
    }
}
