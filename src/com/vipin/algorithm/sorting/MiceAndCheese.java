package com.vipin.algorithm.sorting;

import java.util.PriorityQueue;

public class MiceAndCheese {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] reward1 = { 1, 1, 3, 4 };
		int[] reward2 = { 4, 4, 1, 1 };
		int k = 2;
		MiceAndCheese m = new MiceAndCheese();
		System.out.println(m.miceAndCheese(reward1, reward2, k));
	}

	public int miceAndCheese(int[] reward1, int[] reward2, int k) {
		int ans = 0;
		for (int i : reward2)
			ans += i;

		PriorityQueue<Integer> minHeap = new PriorityQueue();
		for (int i = 0; i < reward1.length; i++) {
			minHeap.offer(reward1[i] - reward2[i]);
			if (minHeap.size() > k)
				minHeap.poll();
		}
		while (!minHeap.isEmpty())
			ans += minHeap.poll();

		return ans;
	}

}
