package com.vipin.algorithm.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[][] = { { 0, 0 }, { 0, 0 } };
		int B[] = { 0, 0 };
		int C[] = { 0, 1 };
		MaximumPath m = new MaximumPath();
		System.out.println(m.solve1(A, B, C));
	}

	int ans = Integer.MIN_VALUE;
	int N = 0;
	int M = 0;

	public int solve1(int[][] A, int[] B, int[] C) {
		N = A.length;
		M = A[0].length;

		int distance[][] = new int[N][M];

		for (int[] dist : distance) {
			Arrays.fill(dist, Integer.MAX_VALUE);
		}

		if (B[0] == C[0] && B[1] == C[1]) {
			return 0;
		}
		Queue<int[]> qe = new LinkedList<>();
		int dx[] = { -1, 0, 1, 0 };
		int dy[] = { 0, 1, 0, -1 };
		qe.offer(new int[] { B[0], B[1] });
		distance[B[0]][B[1]] = 0;
		while (!qe.isEmpty()) {
			int top[] = qe.poll();
			for (int i = 0; i < 4; i++) {
				int x = top[0];
				int y = top[1];
				int count = 0;
				while (canRoll(x + dx[i], y + dy[i], N, M, A)) {
					x = x + dx[i];
					y = y + dy[i];
					count++;
				}
				
				if (distance[top[0]][top[1]] + count < distance[x][y]) {
					distance[x][y] = distance[top[0]][top[1]] + count;
					qe.offer(new int[] { x, y });
				}
			}
		}

		return distance[C[0]][C[1]] == Integer.MAX_VALUE ? -1 : distance[C[0]][C[1]];
	}

	boolean canRoll(int x, int y, int n, int m, int A[][]) {
		return (x > -1 && x < n) && (y > -1 && y < m) && (A[x][y] == 0);
	}

}
