package com.vipin.algorithm.stack;

import java.util.Stack;

public class SortArrayByStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 1, 10, 15, 6, 4 };
		int B[] = { 201, 2, 6, 3, 10 };
		solve(A);

	}

	public static int[] solve(int[] A) {
		Stack<Integer> st = new Stack<Integer>();
		int N = A.length;
		for (int i = 0; i < N; i++) {
			st.push(A[i]);
		}
		if (st.isEmpty()) {
			return A;
		}
		sort(st);
		for (int i = 0; i < N; i++) {
			A[i] = st.pop();
			System.out.println(A[i]);
		}
		return A;
	}

	static void sort(Stack<Integer> st) {
		if (st.size() == 1) {
			return;
		}
		Stack<Integer> st_1 = new Stack<Integer>();
		Stack<Integer> st_2 = new Stack<Integer>();
		int size;
		while (st.size() != 0) {
			size = st.size();
			if (size % 2 == 1) {
				st_1.push(st.pop());
			} else {
				st_2.push(st.pop());
			}
		}
		sort(st_1);
		sort(st_2);
		mergeTwoStackInSortedStack(st_1, st_2, st);
	}

	static void mergeTwoStackInSortedStack(Stack<Integer> s1, Stack<Integer> s2, Stack<Integer> st) {
		Stack<Integer> finalStack = new Stack<Integer>();
		while (!s1.isEmpty() && !s2.isEmpty()) {
			if (s1.peek() < s2.peek()) {
				finalStack.push(s1.pop());
			} else {
				finalStack.push(s2.pop());
			}
		}
		if (s1.isEmpty()) {
			mergeStack(s2, finalStack);
		}
		if (s2.isEmpty()) {
			mergeStack(s1, finalStack);
		}

		while (!finalStack.isEmpty()) {
			st.push(finalStack.pop());
		}
	}

	static void mergeStack(Stack<Integer> s1, Stack<Integer> st) {
		while (!s1.isEmpty()) {
			st.push(s1.pop());
		}
	}

}
