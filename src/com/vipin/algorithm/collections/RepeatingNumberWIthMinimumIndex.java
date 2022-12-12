package com.vipin.algorithm.collections;

import java.util.HashMap;
import java.util.Map;

public class RepeatingNumberWIthMinimumIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {8, 15, 1, 10, 5, 19, 19, 3, 5, 6, 6, 2, 8, 2, 12, 16, 3 };
		System.out.println(solve(A));
	}

	public static int solve(int[] A) {
		int minIndexOfRepeatingNumber = Integer.MAX_VALUE;
		int ans = -1;
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			if (indexMap.containsKey(A[i]) && minIndexOfRepeatingNumber > indexMap.get(A[i])) {
				minIndexOfRepeatingNumber = indexMap.get(A[i]);
				ans = A[i];
			} else {
				indexMap.put(A[i], i);
			}
		}
		return ans;
	}

}
