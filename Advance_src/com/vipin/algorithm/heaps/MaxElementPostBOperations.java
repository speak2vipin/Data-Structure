package com.vipin.algorithm.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashSet;

public class MaxElementPostBOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(-2);
		A.add(-4);
		A.add(-8);
		A.add(-16);
		MaxElementPostBOperations m = new MaxElementPostBOperations();
		System.out.println(m.solve(A, 9));
		int in[] = new int[] { -2, -4, -8, -16 };
		System.out.println(m.solve(in, 9));

	}

	public int solve(ArrayList<Integer> A, int B) {
		PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(new Comparator<int[]>() {
			public int compare(int[] x, int[] y) {
				return x[0] - y[0];
			}
		});
		int size = A.size();
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < size; i++) {
			ans = Math.max(ans, A.get(i));
			int array[] = new int[] { A.get(i) + A.get(i), i };
			minHeap.offer(array);
		}
		int states[] = new int[size];

		while (B > 0) {
			int array[] = minHeap.poll();
			int index = array[1];
			states[index] = array[0];
			array[0] = array[0] + A.get(index);
			System.out.println(array[0]);
			minHeap.offer(array);
			B--;
		}
		if (ans < 0) {
			return ans;
		}
		for (int temp : states) {
			ans = Math.max(ans, temp);
		}
		return ans;
	}

	public int solve(int[] A, int B) {
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
		int n = A.length;
		int ans = Integer.MIN_VALUE;
		int[] states = new int[n];

		// pushing next state of all elements into minHeap
		for (int i = 0; i < n; i++) {
			ans = Math.max(A[i], ans);
			minHeap.add(new int[] { A[i] + A[i], i });
		}

		for (int i = 0; i < B; i++) {
			// choosing element contains min value in next state
			int[] temp = minHeap.peek();
			int index = temp[1];
			int val = temp[0];
			states[index] = val;
			minHeap.poll();
			System.out.println(A[index] + val);
			minHeap.add(new int[] { A[index] + val, index });
		}

		// edge case
		if (ans < 0)
			return ans;

		for (int num : states)
			ans = Math.max(num, ans);

		return ans;
	}

	
}
