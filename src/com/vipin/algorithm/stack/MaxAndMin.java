package com.vipin.algorithm.stack;

import java.util.Stack;

public class MaxAndMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 4, 7, 3, 8 };
		MaxAndMin m = new MaxAndMin();
		System.out.println(m.solveSuccess(A));

	}

	public int solve(int[] A) {
		int N = A.length;
		int min;
		int max;
		long sum = 0;

		for (int i = 0; i < N; i++) {
			min = A[i];
			max = A[i];
			for (int j = i; j < N; j++) {
				// WITH ONE LESS LOOP i.e. O(n2)
				System.out.print(A[j] + " ");
				min = Math.min(min, A[j]);
				max = Math.max(max, A[j]);

				sum += max - min;
			}
			System.out.println();
		}
		return (int) (sum % 1000000007);
	}

	public int solveSuccess(int[] A) {
		int N = A.length;

		int mod = 1000000007;
		int NSLI[] = NSLI(A);
		int NSRI[] = NSRI(A);

		int NGLI[] = NGLI(A);
		int NGRI[] = NGRI(A);
		long tempSum = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			long maxSubArrayCount = (1l * (NGRI[i] - i) * (i - NGLI[i]) + mod) % mod;
			long minSubArrayCount = (1l * (NSRI[i] - i) * (i - NSLI[i]) + mod) % mod;
			tempSum = (A[i] * (maxSubArrayCount - minSubArrayCount)) % mod;
			sum = (int) (sum + tempSum) % mod;
		}

		return (sum + mod) % mod;
	}

	int[] NSLI(int A[]) {

		Stack<Integer> st = new Stack<>();
		int N = A.length;
		int nearestSmallerLeftIndex[] = new int[N];
		for (int i = 0; i < N; i++) {
			while (!st.isEmpty() && A[st.peek()] >= A[i]) {
				st.pop();
			}
			if (st.isEmpty()) {
				nearestSmallerLeftIndex[i] = -1;
			} else {
				nearestSmallerLeftIndex[i] = st.peek();
			}
			st.push(i);
		}
		st.clear();
		return nearestSmallerLeftIndex;
	}

	int[] NSRI(int A[]) {

		Stack<Integer> st = new Stack<>();
		int N = A.length;
		int nearestSmallerRightIndex[] = new int[N];
		for (int i = N - 1; i > -1; i--) {
			while (!st.isEmpty() && A[st.peek()] >= A[i]) {
				st.pop();
			}
			if (st.isEmpty()) {
				nearestSmallerRightIndex[i] = N;
			} else {
				nearestSmallerRightIndex[i] = st.peek();
			}
			st.push(i);
		}
		st.clear();
		return nearestSmallerRightIndex;
	}

	int[] NGLI(int A[]) {

		Stack<Integer> st = new Stack<>();
		int N = A.length;
		int nearestGreaterLeftIndex[] = new int[N];
		for (int i = 0; i < N; i++) {
			while (!st.isEmpty() && A[st.peek()] <= A[i]) {
				st.pop();
			}
			if (st.isEmpty()) {
				nearestGreaterLeftIndex[i] = -1;
			} else {
				nearestGreaterLeftIndex[i] = st.peek();
			}
			st.push(i);
		}
		st.clear();
		return nearestGreaterLeftIndex;
	}

	int[] NGRI(int A[]) {

		Stack<Integer> st = new Stack<>();
		int N = A.length;
		int nearestGreaterRightIndex[] = new int[N];
		for (int i = N - 1; i > -1; i--) {
			while (!st.isEmpty() && A[st.peek()] <= A[i]) {
				st.pop();
			}
			if (st.isEmpty()) {
				nearestGreaterRightIndex[i] = N;
			} else {
				nearestGreaterRightIndex[i] = st.peek();
			}
			st.push(i);
		}
		st.clear();
		return nearestGreaterRightIndex;
	}

}
