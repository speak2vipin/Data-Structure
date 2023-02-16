package com.vipin.algorithm.heaps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ContestAvg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 13, 4, 10, 17, 6, 16 };
		ContestAvg c = new ContestAvg();
		System.out.println(c.solve(A));
	}
	
	// TC -  
	// SC = 4*N
	public int[] solve(int[] A) {

		int N = A.length;
		ArrayList<Integer> l = new ArrayList<Integer>();
		Collections.reverse(l);
		PriorityQueue<Integer> pqMin = new PriorityQueue<Integer>();
		PriorityQueue<Integer> pqMax = new PriorityQueue<Integer>(Collections.reverseOrder());
		Map<Integer, Integer> mapMin = new HashMap<Integer, Integer>();
		Map<Integer, Integer> mapMax = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			pqMin.offer(A[i]);
			pqMax.offer(A[i]);
			mapMin.put(A[i], mapMin.getOrDefault(A[i], 0) + 1);
			mapMax.put(A[i], mapMax.getOrDefault(A[i], 0) + 1);
		}
		for (int i = 0; i < N; i++) {

			int num1 = validNum(pqMin, mapMin, mapMax);

			int num2 = validNum(pqMax, mapMax, mapMin);

			int avg = (num1 + num2) / 2;

			pqMin.offer(num1 + avg);
			mapMin.put(num1 + avg, mapMin.getOrDefault(num1 + avg, 0) + 1);
			pqMax.offer(num2 - avg);
			mapMax.put(num2 - avg, mapMax.getOrDefault(num2 - avg, 0) + 1);

			pqMin.offer(num2 - avg);
			mapMin.put(num2 - avg, mapMin.getOrDefault(num2 - avg, 0) + 1);
			pqMax.offer(num1 + avg);
			mapMax.put(num1 + avg, mapMax.getOrDefault(num1 + avg, 0) + 1);
		}
		int i = 0;
		while (!pqMin.isEmpty()) {
			int top = pqMin.poll();
			if (mapMin.get(top) != null && mapMin.get(top) > 0) {
				A[i++] = top;
				mapMin.put(top, mapMin.get(top) - 1);
			}
		}
		return A;

	}

	int validNum(PriorityQueue<Integer> pqMin, Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
		int num = -1;
		int freq = -1;
		while (!pqMin.isEmpty()) {
			num = pqMin.poll();
			freq = map1.get(num);
			if (freq > 0) {
				if (freq == 1) {
					map1.remove(num);
					map2.remove(num);
				} else {
					map1.put(num, freq - 1);
					map2.put(num, freq - 1);
				}
				break;
			} else {
				map1.remove(num);
				map2.remove(num);
			}
		}
		return num;
	}
}
