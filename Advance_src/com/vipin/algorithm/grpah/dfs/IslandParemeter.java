package com.vipin.algorithm.grpah.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class IslandParemeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[][] = { { 0, 0, 0}, { 1, 1, 1}, { 0, 1, 0 }};
		System.out.println(solve(A));
	}

	public static int solve(int[][] A) {
		Queue<int[]> qe = new LinkedList<>();
		int n = A.length;
		int m = A[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] == 1) {
					qe.offer(new int[] { i, j });
					A[i][j] = 2;
					break;
				}
				if (!qe.isEmpty()) {
					break;
				}
			}
		}
		int x[] = { -1, 0, 1, 0 };
		int y[] = { 0, 1, 0, -1 };
		while (!qe.isEmpty()) {
			int top[] = qe.poll();
			int i = top[0];
			int j = top[1];
			if (A[i][j] != 0) {
				for (int k = 0; k < 4; k++) {
					int newX = i + x[k];
					int newY = j + y[k];

					if (isValid(newX, newY, n, m) && A[newX][j + y[k]] == 1) {
						A[newX][newY] = 2;
						qe.offer(new int[] { newX, newY });
					}
				}
			}
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] == 2) {
					if (i + 1 == n) {
						res++;
					} else {
						if (A[i + 1][j] == 2) {

						} else {
							res++;
						}
					}

					if (i - 1 < 0) {
						res++;
					} else {
						if (A[i - 1][j] == 2) {

						} else {
							res++;
						}
					}
					if (j + 1 == m) {
						res++;
					} else {
						if (A[i][j + 1] == 2) {

						} else {
							res++;
						}
					}
					if (j - 1 < 0) {
						res++;
					} else {
						if (A[i][j - 1] == 2) {

						} else {
							res++;
						}
					}
				}
			}
		}
		return res;
	}

	static boolean isValid(int x, int y, int n, int m) {
		return x > -1 && x < n && y > -1 && y < m;
	}
}
