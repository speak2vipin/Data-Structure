package com.vipin.algorithm.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PalindromicPartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(palindromicPartition("ababbbabbababa"));
		System.out.println(mincuts("ababbbabbababa"));
		int arr[] = {2,4};
		System.out.println(numFactoredBinaryTrees(arr));
	}
	
	static int palindromicPartition(String str)
    {
        // code here
        return partition(str, 0, str.length()-1);
    }
    
    static int partition(String str, int st, int en) {
        //if(st>=en || isPalindrome(str.substring(st, en+1))) {
          //  return 0;
        //}
        int minPartitions = Integer.MAX_VALUE;
        
        for(int i=st; i<en; i++) {
        	int cuts = partition(str, st, i) + partition(str, i+1, en) + 1;
            minPartitions = Math.min(minPartitions, cuts);
        }
        return minPartitions;
    }
    static boolean generatePalindrome(String s, boolean[][] pal) {
    	
        int n = s.length();
        for(int i=0; i<n; i++) {
        	pal[i][i] = true;
        }
        for(int len = 2; len<=n; len++) {
        	for(int i=0; i<=n-len; i++) {
        		int j = i + len -1;
        		if(s.charAt(i)==s.charAt(j) && (len==2 || pal[i+1][j-1])) {
        			pal[i][j] = true;
        		}
        	}
        }
        return true;
    }
    
    static int mincuts(String s) {
    	if(s==null || s.length()==0) {
    		return 0;
    	}
    	int n = s.length();
    	boolean pal[][] = new boolean[n][n];
    	generatePalindrome(s, pal);
    	int minCutDp[] = new int[n];
    	Arrays.fill(minCutDp, Integer.MAX_VALUE);
    	minCutDp[0] = 0;
    	for(int i=1; i<n; i++) {
    		if(pal[0][i]) {
    			minCutDp[i] = 0;
    		} else {
    			for(int j=i; j>=1; j--) {
    				if(pal[j][i]) {
    					if(minCutDp[j-1] + 1 < minCutDp[i]) {
    						minCutDp[i] = minCutDp[j-1] + 1;
    					}
    				}
    			}
    		}
    	}
    	return minCutDp[n-1];
    }
    
    public static int numFactoredBinaryTrees(int[] arr) {
        int mod = 1000_000_007;
        int N = arr.length;
        Arrays.sort(arr);
        Map<Integer, Long> count = new HashMap<>();
        for(int a : arr) {
            count.put(a, 1l);
        }
        for(int i=1; i<N; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i]%arr[j]==0) {
                    int key = arr[i]/arr[j];
                    if(count.get(key)!=null) {
                        long total = 0l;
                        if(key!=arr[j]) {
                            total = (count.get(arr[i]) + 
                                      (count.get(arr[j]) * count.get(key))%mod)%mod;
                        } 
                        count.put(arr[i], total);
                    }
                }
            }
        }
        long ans = 0;
        for(Long value : count.values()) {
            ans = (ans + value)%mod;
        }
        return (int)ans;
    }
}
