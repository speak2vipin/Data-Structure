package com.vipin.algorithm.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NearestOneIn2DArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[][] = { { 0, 0, 0, 1 }, { 0, 0, 1, 1 }, { 0, 1, 1, 0 } };
		NearestOneIn2DArray n = new NearestOneIn2DArray();
		System.out.println(n.solve(A));
	}

	int ans[][] = null;

	public int[][] solve(int[][] A) {
		int N = A.length;
		int M = A[0].length;
		int dx[] = { -1, 0, 0, 1 };
		int dy[] = { 0, -1, 1, 0 };
		Queue<int[]> qe = new LinkedList<int[]>();
		ans = new int[N][M];

		for (int i = 0; i < N; i++) {
			Arrays.fill(ans[i], -1);
			for (int j = 0; j < M; j++) {
				if (A[i][j] == 1) {
					ans[i][j]=0;
					qe.offer(new int[] { i, j });
				}
			}
		}
		int level = 0;
		while (!qe.isEmpty()) {
			int size = qe.size();
			for (int i = 0; i < size; i++) {
				int temp[] = qe.poll();
				for (int k = 0; k < 4; k++) {
					if (temp[0] + dx[k] > -1 && temp[0] + dx[k] < N && temp[1] + dy[k] > -1 && temp[1] + dy[k] < M
							&& ans[temp[0] + dx[k]][temp[1] + dy[k]] == -1) {
						ans[temp[0] + dx[k]][temp[1] + dy[k]] = 1 + level;
						qe.offer(new int[] { temp[0] + dx[k], temp[1] + dy[k] });
					}
				}
				
			}
			level++;
		}

		return null;
	}

}
