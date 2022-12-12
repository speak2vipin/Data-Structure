package com.vipin.algorithm.stack;

import java.util.Stack;

public class AreaBetweenHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {2};
		System.out.println(largestRectangleArea(A));
	}

	public static int largestRectangleArea(int[] A) {
		Stack<Integer> st = new Stack<Integer>();
		int N = A.length;
		int nearestleftMinElement[] = new int[N];
		int nearestRightMinElement[] = new int[N];
		for (int i = 0; i < N; i++) {
			while (!st.isEmpty() && A[st.peek()] >= A[i]) {
				st.pop();
			}
			if (st.isEmpty()) {
				nearestleftMinElement[i] = -1;
			} else {
				nearestleftMinElement[i] = st.peek();
			}
			st.push(i);
		}
		st.clear();
		for (int i = N - 1; i > -1; i--) {
			while (!st.isEmpty() && A[st.peek()] >= A[i]) {
				st.pop();
			}
			if (st.isEmpty()) {
				nearestRightMinElement[i] = -1;
			} else {
				nearestRightMinElement[i] = st.peek();
			}
			st.push(i);
		}
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int l;
			int r;
			if (nearestleftMinElement[i] == -1) {
				l = 0;
			} else {
				l = nearestleftMinElement[i] + 1;
			}
			if (nearestRightMinElement[i] == -1) {
				r = N - 1;
			} else {
				r = nearestRightMinElement[i] - 1;
			}
			ans = Math.max(ans, A[i]* (r-l+1));
		}

		return ans;
	}

}
