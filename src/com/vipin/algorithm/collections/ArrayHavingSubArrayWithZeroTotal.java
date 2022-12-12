package com.vipin.algorithm.collections;

import java.util.HashSet;
import java.util.Set;

public class ArrayHavingSubArrayWithZeroTotal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int solve(int[] A) {
        int N = A.length;
        Set<Long>set = new HashSet<Long>();
        long [] prefix = new long[N];
        prefix [0] = A[0];
        set.add(prefix[0]);
        for(int i=1;i<N;i++) {
            prefix[i] = prefix[i-1] + A[i];
            // prefix[i]==0 -> True
            // Check whether is there any duplicate element in prefix array. If yes --> true.
            if(prefix[i]==0 || !set.add(prefix[i])) {
            	return 1;
            }
        }
        return 0;
	}

}
