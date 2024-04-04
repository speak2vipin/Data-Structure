package com.vipin.algorithm.mathoperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class AllGCDPairGivenArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int A[] = { 2, 2, 2, 2, 8, 2, 2, 2, 10};
		AllGCDPairGivenArray a  = new AllGCDPairGivenArray();
		System.out.println(a.allGcdpair(A));

	}
// 2, 2, 2, 2, 8, 2, 2, 2, 10
	public int[] allGcdpair(int[] arr) {
		int n = arr.length;
		ArrayList<Integer> list = new ArrayList<>();
		Integer[] A = new Integer[n];
		int index = 0;
		for (int a : arr)
			A[index++] = a;
		// Sorting the array in descending order
		Arrays.sort(A, Collections.reverseOrder());
		list.add(A[0]);
		list.add(A[1]);
		HashMap<Integer, Integer> gcdPairs = new HashMap<>();
		gcdPairs.put(gcd(list.get(0), list.get(1)), 2);
		for (int i = 2; i < n; i++) {
			if (gcdPairs.containsKey(A[i]))
				if (gcdPairs.get(A[i]) == 0)
					gcdPairs.remove(A[i]);
				else
					gcdPairs.put(A[i], gcdPairs.get(A[i]) - 1);
			else {
				// res.add(A[i]);
				for (int j = list.size() - 1; j >= 0; j--) {
					int tempGCD = gcd(list.get(j), A[i]);
					if (!gcdPairs.containsKey(tempGCD))
						gcdPairs.put(tempGCD, 2);
					else
						gcdPairs.put(tempGCD, gcdPairs.get(tempGCD) + 2);
				}
				list.add(A[i]);
			}
		}
		int[] response = new int[list.size()];
		int ptr = 0;
		for (int a : list)
			response[ptr++] = a;
		return response;
	}

	public int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

}
