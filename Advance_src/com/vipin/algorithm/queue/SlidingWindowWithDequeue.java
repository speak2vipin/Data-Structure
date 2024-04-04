package com.vipin.algorithm.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeMap;

public class SlidingWindowWithDequeue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int B = 3;
		SlidingWindowWithDequeue s = new SlidingWindowWithDequeue();
		s.slidingMaximum(A, B);

		int X[] = { 2, 5, -1, 7, -3, -1, -2 };
		int Y = 4;
		s.solve(X, Y);
	}

	public int[] slidingMaximum(final int[] A, int B) {
		Deque<Integer> dequeue = new ArrayDeque<>();
		for (int i = 0; i < B; i++) {
			while (!dequeue.isEmpty() && A[dequeue.peekLast()] <= A[i]) {
				dequeue.pollLast();
			}
			dequeue.offerLast(i);
		}
		int N = A.length;
		int ans[] = new int[N - B + 1];
		int index = 0;
		ans[index++] = A[dequeue.peekFirst()];
		for (int i = B; i < N; i++) {
			while (!dequeue.isEmpty() && A[dequeue.peekLast()] <= A[i]) {
				dequeue.pollLast();
			}
			dequeue.offerLast(i);
			if (dequeue.peekFirst() < (i - B + 1)) {
				dequeue.pollFirst();
			}
			ans[index++] = A[dequeue.peekFirst()];
		}
		return ans;
	}

	public int solve(int[] A, int B) { //[2, 5, -1, 7, -3, -1, -2]
		Deque<Integer> maxDequeue = new ArrayDeque<Integer>();
		Deque<Integer> minDequeue = new ArrayDeque<Integer>();
		int N = A.length;
		long sum = 0;
		int mod = 1000_000_007;
		for (int i = 0; i < B; i++) {
			while (!maxDequeue.isEmpty() && A[maxDequeue.peekLast()] <= A[i]) {
				maxDequeue.pollLast();
			}
			maxDequeue.offerLast(i);
			while (!minDequeue.isEmpty() && A[minDequeue.peekLast()] >= A[i]) {
				minDequeue.pollLast();
			}
			minDequeue.offerLast(i);
		}
		sum = (sum + A[maxDequeue.peekFirst()] + A[minDequeue.peekFirst()]) % mod;
		for (int i = B; i < N; i++) {
			while (!maxDequeue.isEmpty() && A[maxDequeue.peekLast()] <= A[i]) {
				maxDequeue.pollLast();
			}
			maxDequeue.offerLast(i);
			while (maxDequeue.peekFirst() < i - B + 1) {
				maxDequeue.pollFirst();
			}
			while (!minDequeue.isEmpty() && A[minDequeue.peekLast()] >= A[i]) {
				minDequeue.pollLast();
			}
			minDequeue.offerLast(i);
			while (minDequeue.peekFirst() < i - B + 1) {
				minDequeue.pollFirst();
			}
			sum = (sum + A[maxDequeue.peekFirst()] + A[minDequeue.peekFirst()]) % mod;
		}
		return (int) sum;
	}
	


}
