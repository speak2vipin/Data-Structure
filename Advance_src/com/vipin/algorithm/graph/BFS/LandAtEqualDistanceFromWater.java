package com.vipin.algorithm.graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LandAtEqualDistanceFromWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,0,0},{0,0,0},{0,0,0}};
		LandAtEqualDistanceFromWater l = new LandAtEqualDistanceFromWater();
		System.out.println(l.maxDistance(grid));

	}

	 public int maxDistance(int[][] grid) {
			
			int N = grid.length;
			int M = grid[0].length;
			int dist = 0;
			Queue<int[]> land = new LinkedList<int[]>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (grid[i][j] == 1) {
						land.offer(new int[] { i, j });
					}
				}
			}
			
			while (!land.isEmpty()) {
				int size = land.size();
				boolean isVisted = false;
				for (int i = 0; i < size; i++) {
					int index[] = land.poll();

					if (index[0] - 1 > -1 && index[0] - 1 < N && grid[index[0] - 1][index[1]] == 0) {
						isVisted = true;
						grid[index[0] - 1][index[1]] = 1;
						land.offer(new int[] { index[0] - 1, index[1] });
					}
					if (index[0] + 1 > -1 && index[0] + 1 < N && grid[index[0] + 1][index[1]] == 0) {
						isVisted = true;
						grid[index[0] + 1][index[1]] = 1;
						land.offer(new int[] { index[0] + 1, index[1] });
					}
					if (index[1] - 1 > -1 && index[1] - 1 < M && grid[index[0]][index[1] - 1] == 0) {
						isVisted = true;
						grid[index[0]][index[1] - 1] = 1;
						land.offer(new int[] { index[0], index[1] - 1 });
					}
					if (index[1] + 1 > -1 && index[1] + 1 < M && grid[index[0]][index[1] + 1] == 0) {
						isVisted = true;
						grid[index[0]][index[1] + 1] = 1;
						land.offer(new int[] { index[0], index[1] + 1 });
					}
				}
				if(isVisted)
					dist++;
			}
			return dist;
		
		}
}
