package com.vipin.algorithm.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		KthLargestElement k = new KthLargestElement(3, new int[] { 4, 5, 8, 2 });
		System.out.println(k.add(3));
		System.out.println(k.add(5));
		System.out.println(k.add(10));
		System.out.println(k.add(9));
		System.out.println(k.add(4));

	}

	PriorityQueue<Integer> heap = null;

	int k = 0;
	int nums[] = null;

	public KthLargestElement(int k, int[] nums) {
		this.k = k;
		this.nums = nums;
		heap = new PriorityQueue<>(Collections.reverseOrder());

		for (int num : nums) {
			heap.offer(num);
		}
		while (heap.size() > k) {
			heap.poll();
		}
	}

	public int add(int val) {
		heap.offer(val);
		while (heap.size() > k) {
			heap.poll();
		}
		return heap.peek();
	}

}
