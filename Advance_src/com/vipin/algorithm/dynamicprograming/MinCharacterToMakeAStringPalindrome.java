package com.vipin.algorithm.dynamicprograming;

import java.util.Arrays;

public class MinCharacterToMakeAStringPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MinCharacterToMakeAStringPalindrome m = new MinCharacterToMakeAStringPalindrome();
		System.out.println(m.minInsertions("letelt"));
		int []nums = {1,-1,-3,-2,3};
		int k = 3;
		int x = 2;
		System.out.println(m.getSubarrayBeauty(nums, k, x));
	}
	
	int dp[][] = null;
    public int minInsertions(String s) {
        int N = s.length();
        dp = new int[N+1][N+1];
        for(int i=0; i<N+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        String r = new StringBuilder(s).reverse().toString();
        int lcs = lcs(s, r, N, N);
        return N - lcs;
    }
    
    int lcs (String s, String r, int m, int n) {
        
        if(m==0 || n==0) {
            return 0;
        }
        if(dp[m][n]!=-1) {
            return dp[m][n];
        }
        if(s.charAt(m-1)==r.charAt(n-1)) {
            return dp[m][n] = 1 + lcs(s, r, m-1, n-1);
        }
        dp[m][n] = Math.max(lcs(s, r, m-1, n), lcs(s, r, m, n-1));
        return dp[m][n];
    }
    
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int freq[] = new int[101];
        int N = nums.length;
        int len = N - k + 1;
        int ans[] = new int[len];
        int count = x;
        for(int i=0; i<k; i++) {
            freq[nums[i]+50]++;
        }
        int index =0; //[1, -1, -3, -2, 3]
        int c = 1;
        for(int i=0; i<101; ) {
            if(freq[i]!=0) {
                count--;
                
                if(count==0) {
                    ans[index++] = Math.min(i-50, 0);
                    break;
                }
                if((freq[i]-(c++))!=0) {
                	continue;
                }
            } 
            i++;
            c=1;
            
        }
        for(int i=k; i<N; i++) {
            
            if(nums[i-k]>=nums[i] && nums[i-k] != ans[index-1]) {
            	ans[index] = ans[index-1];
            	index++;
            } else if((nums[i-k]>=nums[i] && nums[i-k] == ans[index-1]) || nums[i-k]<nums[i]){
            	freq[nums[i-k]+50]--;
                freq[nums[i]+50]++;
                count = x;
                c = 1;
                for(int j=0; j<101; ) {
                	if(freq[j]!=0) {
                        count--;
                        
                        if(count==0) {
                            ans[index++] = Math.min(j-50, 0);
                            break;
                        }
                        if((freq[j]-(c++))!=0) {
                        	continue;
                        }
                    } 
                    j++;
                    c=1;
                }
            }
        }
        return ans;
    }


}
