package com.vipin.algorithm.stack;

import java.util.Stack;

public class AreaOfRectangleFormByHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 1 };
		System.out.println(largestRectangleArea(A));
		System.out.println(largestRectangleAreaScaler(A));
	}

	public static int largestRectangleArea(int[] A) {
		Stack<Integer> st = new Stack<>();
		int n = A.length;
		int res = Integer.MIN_VALUE;
		int minLeftElementIndex[] = new int[n];
		int minRightElementIndex[] = new int[n];

		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && A[st.peek()] >=A[i]) {
				st.pop();
			}
			if (st.isEmpty()) {
				minLeftElementIndex[i] = -1;
			} else {
				minLeftElementIndex[i] = st.peek();
			}
			st.push(i);
		}
		st.clear();
		for (int i = n - 1; i > -1; i--) {
			while (!st.isEmpty() && A[st.peek()] >= A[i]) {
				st.pop();
			}
			if (st.isEmpty()) {
				minRightElementIndex[i] = -1;
			} else {
				minRightElementIndex[i] = st.peek();
			}
			st.push(i);
		}
		for (int i = 0; i < n; i++) {
			int l = 0;
			int r = 0;
			if (minLeftElementIndex[i] == -1) {
				l = 0;
			} else {
				l = minLeftElementIndex[i] + 1;
			}

			if (minRightElementIndex[i] == -1) {
				r = n-1;
			} else {
				r = minRightElementIndex[i] - 1;
			}
			res = Math.max(res, A[i] * (r-l + 1));
		}
		return res;
	}
	
	 public static int largestRectangleAreaScaler(int[] A) {
	        Stack<Integer> st = new Stack<Integer>();
	        int N = A.length;
	        int nearestleftMinElement[] = new int[N];
	        int nearestRightMinElement[] = new int[N];
	        // MINIMUM element index to the left of that element
	        // Store index as we can esily retrieve array element with index from Array.
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
	        
	        // MINIMUM element index to the right of that element
	    
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
