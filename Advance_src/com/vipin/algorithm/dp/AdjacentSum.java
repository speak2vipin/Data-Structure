package com.vipin.algorithm.dp;

public class AdjacentSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[][] = { { 1, 2, 3, 4, 10, 8, 12 }, { 2, 3, 4, 5, 10, 8, 12 } };
		AdjacentSum s = new AdjacentSum();
		System.out.println(s.adjacent(A));
	}

	public int adjacent(int[][] A) {
		int column = A[0].length;
		// int rows = A.length
		int ans = Integer.MIN_VALUE;
		for (int j = 1; j < column; j++) {
			for (int i = 0; i < 2; i++) {
				if (j < 2) {
					if (i == 0) {
						A[i][j] = Math.max(Math.max(Math.max(A[i][j], A[i][j - 1]), A[i + 1][j - 1]), A[i + 1][j]);
					} else {
						A[i][j] = Math.max(Math.max(Math.max(A[i][j], A[i][j - 1]), A[i - 1][j - 1]), A[i - 1][j]);
					}
				} else {
					if (i == 0) {
						A[i][j] = Math.max(A[i][j] + Math.max(A[i][j - 2], A[i + 1][j - 2]),
								Math.max(A[i][j - 1], A[i + 1][j - 1]));
					} else {
						A[i][j] = Math.max(A[i][j] + Math.max(A[i][j - 2], A[i - 1][j - 2]),
								Math.max(A[i][j - 1], A[i - 1][j - 1]));
					}
				}
				ans = Math.max(ans, A[i][j]);
			}
		}
		return ans;
	}

}
