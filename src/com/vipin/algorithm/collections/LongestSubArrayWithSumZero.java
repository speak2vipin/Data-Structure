package com.vipin.algorithm.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubArrayWithSumZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1,2,-2,4,-4};
		int B[] = {-19, 8, 2, -8, 19, 5, -2, -23};
		lszero(A);
		lszero(B);
	}

	public static int[] lszero(int[] A) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int N = A.length;
		int prefix[] = new int[N];
		prefix[0] = A[0];
		// Calculate prefix array. Just to check whether it has any duplicate element
		for (int i = 1; i < N; i++) {
			prefix[i] = prefix[i - 1] + A[i];
		}
		int len = 0;
		int indexS = -1, indexE = -1;
		for (int i = 0; i < N; i++) {
			if (!map.containsKey(prefix[i])) {
				map.put(prefix[i], i);
			} else {
				// Check length is greater than existing length. It could be for any other element or could be for same element but length is greater.
				// 1 ,2, 1, 4, 5, 1 -> Elements should be from duplicate_element_index + 1
				// Length = (i-j+1)
				if (len < i - (map.get(prefix[i]) + 1) + 1) {
					indexS = map.get(prefix[i]) + 1;
					indexE = i;
					len = i - (map.get(prefix[i]) + 1) + 1;
				}
			}
		}
		// if len=0 then return empty array
		if (len == 0) {
			int ans[] = {};
			return ans;
		}
		int ans[] = new int[len];
		System.arraycopy(A, indexS, ans, 0, len);
		return ans;
	}
	
	int [] sum() {
		return null;
	}

}
