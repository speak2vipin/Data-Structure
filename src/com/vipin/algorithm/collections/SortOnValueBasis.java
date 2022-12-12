package com.vipin.algorithm.collections;

import java.util.*;
import java.util.Map.Entry;

public class SortOnValueBasis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 2, 2, 1, 2 };
		int[] B = { 1, 3, 4, 4 };
		System.out.println(solution(5, A, B));
	}

	public static int solution(int N, int[] A, int[] B) {
		// write your code in Java SE 8
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int len = A.length;
		for (int i = 0; i < len; i++) {
			if (map.get(A[i]) == null) {
				map.put(A[i], 1);
			} else {
				map.put(A[i], map.get(A[i]) + 1);
			}
			if (map.get(B[i]) == null) {
				map.put(B[i], 1);
			} else {
				map.put(B[i], map.get(B[i]) + 1);
			}
		}

		Collections.sort((List) map.entrySet(), new Comparator<Entry>() {

			public int compare(Entry o1, Entry o2) {
				// TODO Auto-generated method stub
				return (Integer) o2.getValue() - (Integer) o1.getValue();
			}

		});

		Map<Integer, Integer> weightMap = new HashMap<Integer, Integer>();
		int count = 0;
		for (Integer i : map.keySet()) {
			weightMap.put(i, N - count);
			count++;
		}
		int cost = 0;
		for (int j = 0; j < len; j++) {
			cost += weightMap.get(A[j]) + weightMap.get(B[j]);
		}
		return cost;
	}

}
