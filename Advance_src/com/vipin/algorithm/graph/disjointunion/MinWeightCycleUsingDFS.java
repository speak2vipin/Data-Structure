package com.vipin.algorithm.graph.disjointunion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinWeightCycleUsingDFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A = 4;
		int[][] B = { { 1, 2, 2 }, { 2, 3, 3 }, { 3, 4, 1 }, { 4, 1, 4 }, { 1, 3, 15 } };
		
		MinWeightCycleUsingDFS m = new MinWeightCycleUsingDFS();
		System.out.println(m.solve(A, B));

	}

	Map<Integer, ArrayList<int[]>> adj = null;
	int ans = Integer.MAX_VALUE;

	public int solve(int A, int[][] B) {
		boolean visit[] = new boolean[A + 1];
		adj = new HashMap<>();
		for (int b[] : B) {
			int u = b[0];
			int v = b[1];
			int w = b[2];
			adj.computeIfAbsent(u, val -> new ArrayList<int[]>()).add(new int[] { v, w });
			adj.computeIfAbsent(v, val -> new ArrayList<int[]>()).add(new int[] { u, w });
		}
		for (int i = 1; i <= A; i++) {
			if(!visit[i]) {
				boolean path[] = new boolean[A + 1];
				dfs(i, 0, 0, path);
			}
		}
		return ans==Integer.MAX_VALUE ? -1 : ans;

	}

	void dfs(int source, int prev, int weight, boolean path[]) {
		if (path[source]) {
			System.out.println("Cycle : " + weight);
			ans = Math.min(ans, weight);
			return;
		}
		path[source] = true;

		ArrayList<int[]> neighbour = adj.getOrDefault(source, new ArrayList<int[]>());
		for (int temp[] : neighbour) {
			int node = temp[0];
			int nodeWeight = temp[1];
			if(node!=prev)
				dfs(node, source, weight + nodeWeight, path);
		}
		path[source] = false;
	}

}
