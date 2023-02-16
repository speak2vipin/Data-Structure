package com.vipin.algorithm.tree;

public class NoOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NoOfIslands n = new NoOfIslands();
		int A[][] = {
				{0, 0, 1, 0, 1, 0, 1, 1, 1},
			    {0, 1, 0, 0, 1, 1, 1, 0, 1}};
		System.out.println(n.solve(A));
	}

	int N = -1;
	int M = -1;

	public int solve(int[][] A) {
		N = A.length;
		M = A[0].length;
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] == 1) {
					count++;
					dfs(i, j, A);
				}
			}
		}
		return count;
	}

	void dfs(int i, int j, int A[][]) {
		A[i][j] = 2;
		if (i - 1 > -1 && A[i - 1][j] == 1) {
			dfs(i - 1, j, A);
		}
		if (j - 1 > -1 && A[i][j - 1] == 1) {
			dfs(i, j - 1, A);
		}
		if (i + 1 < N && A[i + 1][j] == 1) {
			dfs(i + 1, j, A);
		}
		if (j + 1 < M && A[i][j + 1] == 1) {
			dfs(i, j + 1, A);
		}
		if (i - 1 > -1 && j - 1 > -1 && A[i - 1][j - 1] == 1) {
			dfs(i - 1, j - 1, A);
		}
		if (i + 1 < N && j + 1 < M && A[i + 1][j + 1] == 1) {
			dfs(i + 1, j + 1, A);
		}
		if (i - 1 > -1 && j + 1 < M && A[i - 1][j + 1] == 1) {
			dfs(i - 1, j + 1, A);
		}
		if (i + 1 < N && j - 1 > -1 && A[i + 1][j - 1] == 1) {
			dfs(i + 1, j - 1, A);
		}

	}

}
