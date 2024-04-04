package com.vipin.algorithm.graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfClosedIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NoOfClosedIslands n = new NoOfClosedIslands();
		int input[][] = { { 1, 1, 1, 1, 1, 1, 1, 0 }, 
						  { 1, 0, 0, 0, 0, 1, 1, 0 }, 
						  { 1, 0, 1, 0, 1, 1, 1, 0 },
						  { 1, 0, 0, 0, 0, 1, 0, 1 }, 
						  { 1, 1, 1, 1, 1, 1, 1, 0 } };
		System.out.println(n.closedIsland(input));

	}

	int noOfIslands = 0;
	int N = 0;
	int M = 0;
	boolean isClosed = true;

	public int closedIsland(int[][] grid) {
		N = grid.length;
		M = grid[0].length;
		int count = 0;
		boolean visit[][] = new boolean[N][M];
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < M - 1; j++) {
				if (grid[i][j] == 0 && !visit[i][j]) {
					isClosed = true;
					bfs(grid, visit, i, j);
					if (isClosed) {
						count++;
					}
				}
			}
		}
		return count;
	}

	void bfs(int grid[][], boolean visit[][], int i, int j) {

		Queue<int[]> qe = new LinkedList<>();
		qe.offer(new int[] { i, j });
		int dx[] = { -1, 0, 1, 0 };
		int dy[] = { 0, 1, 0, -1 };
		while (!qe.isEmpty()) {
			int top[] = qe.poll();
			int x = top[0];
			int y = top[1];
			visit[x][y] = true;
			for (int index = 0; index < 4; index++) {
				if (x + dx[index] < 0 || x + dx[index] > N || y + dy[index] < 0 || y + dy[index] > M) {
					isClosed = false;
				} else if (grid[x + dx[index]][y + dy[index]] == 0 && !visit[x + dx[index]][y + dy[index]]) {
					qe.offer(new int[] { x + dx[index], y + dy[index] });
				}
			}
		}
	}

}
