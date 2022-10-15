package com.vipin.algorithms.array;

import java.util.HashSet;
import java.util.Set;

public class LongestSubarrayLengthWithSumZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {3,3,4,-5,-2,2,1,-3,3,-1,-4,-1};
		System.out.println(longestSubArrayLength(A));

	}
	
	static int longestSubArrayLength(int A[]) {
		int ans = -1;
		int N = A.length;
		int p[] = new int[N];
		p[0] = A[0];
		for(int i=1;i<N;i++) {
			p[i] = A[i] + p[i-1];
			if(p[i] == 0) {
				ans = Math.max(ans, i+1);
			}
		}
		Set<Integer>set = new HashSet<Integer>();
		for(int i=0;i<N;i++) {
			set.add(p[i]);
		}
		if(set.size()==N) {
			return ans;
		}
		for(int i=0;i<N; i++) {
			for(int j=i+1;j<N;j++) {
				if(p[i]==p[j]) {
					ans = Math.max(ans, j-i+1);
				}
			}
		}
		return ans;
	}

}
