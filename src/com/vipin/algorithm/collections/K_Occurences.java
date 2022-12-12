package com.vipin.algorithm.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class K_Occurences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5, B = 2;
		int[] C = { 1, 2, 2, 3, 3 };
		System.out.println(getSum(N, B, C));

	}

	public static int getSum(int A, int B, int[] C) {
		int N = C.length;
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			if (freqMap.containsKey(C[i])) {
				freqMap.put(C[i], freqMap.get(C[i]) + 1);
			} else {
				freqMap.put(C[i], 1);
			}
		}
		long sum = 0;
		for (Entry<Integer, Integer> entry : freqMap.entrySet()) {
			if (entry.getValue() == B) {
				sum += entry.getKey();
			}
		}
		return (int)sum%1000000007;

	}

}
