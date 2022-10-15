package com.vipin.algorithms.array;

public class MinNoOfSwapRequiredToMakeAllNumberTogetherLesserThanB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class Solution {
		public int solve(int[] A, int B) {

			int n = A.length;
			// count of elements which are less than equals to B
			int count = 0;
			for (int i = 0; i < n; i++)
				if (A[i] <= B)
					count++;

			// count of elements which are greater than equals to B
			int bad = 0;
			for (int i = 0; i < count; i++)
				if (A[i] > B)
					bad++;
			
			int ans = bad;
			for (int i = 0, j = count; j < n; i++, j++) {

				// exclude count of previous window
				if (A[i] > B)
					bad--;

				// include count of current window
				if (A[j] > B)
					bad++;

				// Update ans
				ans = Math.min(ans, bad);
			}
			return ans;
		}
	}

}
