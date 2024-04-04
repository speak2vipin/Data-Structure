package com.vipin.algorithm.grpah.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFSWithBitMask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int graph[][] = {{1,2,3},{0},{0},{0}};
		System.out.println(shortestPathLength(graph));
	}

	public static int shortestPathLength(int[][] graph) {
		int n = graph.length;
		if (n == 1) {
			return 0;
		}
		int finalState = (1 << n) - 1;
		int visit[][] = new int[n][finalState + 1];
		Queue<int[]> qe = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			qe.offer(new int[] { i, 1 << i });
		}
		int shortestPath = 0;
		while (!qe.isEmpty()) {
			shortestPath++;
			int size = qe.size();

			for (int k = 0; k < size; k++) {
				int top[] = qe.poll();
				int node = top[0];
				int state = top[1];

				for (int neighbor : graph[node]) {
					int newState = state | (1 << neighbor);
					if (visit[neighbor][newState] == 0) {
						if (finalState == newState) {
							return shortestPath;
						}
						qe.offer(new int[] { neighbor, newState });
						visit[neighbor][newState] = 1;
					}
				}
			}
		}
		return shortestPath;
	}

}
