package com.vipin.algorithm.greedyalgorithms;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxAndMinTicketPrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A = 4;
		int B = 3;
		int C[] = { 2, 2, 2 };
		MaxAndMinTicketPrice m = new MaxAndMinTicketPrice();
		m.solve(A, B, C);
	}

	public int[] solve(int A, int B, int[] C) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		for (int c : C) {
			minHeap.offer(c);
			maxHeap.offer(c);
		}

		int res[] = new int[2];

		int person = A;
		int max = 0;
		while (person > 0) {
			person--;
			int top = maxHeap.poll();
			if (top > 1) {
				maxHeap.offer(top-1);
			}
			max += top;
		}

		person = A;
		int min = 0;
		while (person > 0) {
			person--;
			int top = minHeap.poll();
			if (top > 1) {
				minHeap.offer(top-1);
			}
			min += top;
		}
		res[0] = max;
		res[1] = min;
		return res;
	}

}
