package com.vipin.algorithm.dynamicprograming;

import java.util.ArrayList;

public class UnboundedKnapsackProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>();

		A.add(1);
		A.add(5);
		A.add(2);
		A.add(5);
		A.add(6);
		UnboundedKnapsackProblem un = new UnboundedKnapsackProblem();
		System.out.println(un.solve(A));
	}

	public int solve(ArrayList<Integer> A) {
		int N = A.size();
		int dp[] = new int[N + 1];
		dp[0] = 0;
		for (int i = 1; i <= N; i++) {
			for (int l = 1; l <= i; l++) {
				dp[i] = Math.max(dp[i], A.get(l - 1) + dp[i - l]);
				//System.out.print(" " + dp[i]);
			}
			//System.out.println();
		}
		return dp[N];
	}
}
