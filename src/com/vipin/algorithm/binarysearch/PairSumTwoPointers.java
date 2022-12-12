package com.vipin.algorithm.binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairSumTwoPointers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 2, 4, 4, 5, 6, 8, 10 };
		System.out.println(solve(A, 6));
	}

	public static int solve(int[] A, int B) {
		 /*
	        long mod = 1000000007;
	        int st = 0;
	        int en = A.length-1;
	        long count = 0;
	        while(st<en) {
	            if(A[st]+A[en]==B) {
	                int cSt = 1;
	                while((st+cSt) < en && A[st]==A[st+cSt]) {
	                    cSt++;
	                }
	                //st = st + cSt;
	                int cEn = 1;
	                while((en-cEn > st) && A[en-cEn]==A[en]) {
	                    cEn++;
	                }
	                en = en - cEn;
	                count += cSt*cEn;
	            } else if(A[st]+A[en]<B) {
	                st++;
	            } else {
	                en--;
	            }
	        }
	        return (int)(count%mod); 
	        */

			int mod = 1000 * 1000 * 1000 + 7;
			int l = 0, r = A.length - 1, ans = 0;
			while (l < r) {
				int sum = A[l] + A[r];
				if (sum == B) {
					int count = 0, prev = r;
					while (prev > l && A[r] == A[prev]) {// count duplicate values from right pointer
						count++;
						prev--;
					}
					ans = (ans + count) % mod;
					l++;
				} else if (sum < B) {
					l++;
				} else if (sum > B) {
					r--;
				}
			}
			return ans;
	}
	

	public int[] solve1(int[] A, int B) {
		int i = 0;
		int j = 1;
		int[] ps = new int[A.length];
		ps[0] = A[0];
		for (int k = 1; k < A.length; k++) {
			ps[k] = ps[k - 1] + A[k];
		}

		while (i < A.length && j < A.length) {
			int sum = Integer.MAX_VALUE;
			if (i == 0)
				sum = ps[j];
			else
				sum = ps[j] - ps[i - 1];
			if (sum == B) {
				return Arrays.copyOfRange(A, i, j + 1);
			} else if (sum < B) {
				j++;
			} else
				i++;
		}

		return new int[] { -1 };
	}
	
	 public int solve(int[] A) {
	     
	        int N =A.length;
	        long p[] = new long[N];
	        for(int i=0; i<N; i++) {
	            if(i==0) {
	                p[i] = A[i];
	            } else {
	                p[i] = p[i-1] + A[i];    
	            }
	            if(p[i]==0) {
	                return 1;
	            }
	        }
	        Set<Long> prefixSet = new HashSet<Long> ();
	        for(int i=0; i<N; i++) {
	            if(prefixSet.contains(p[i])) {
	                return 1;
	            } else {
	            	prefixSet.add(p[i]);
	            }
	        }
	        return 0;
	 }
}
