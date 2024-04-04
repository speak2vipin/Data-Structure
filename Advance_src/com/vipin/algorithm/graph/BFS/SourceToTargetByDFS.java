package com.vipin.algorithm.graph.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SourceToTargetByDFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 1, 1, 1, 1, 1 };
		int B = 1;
		int C = 1;
		SourceToTargetByDFS s = new SourceToTargetByDFS();
		System.out.println(s.solve(A, B, C));
		
	}

	Map<Integer, ArrayList<Integer>> adj = null;
	boolean reachable = false;
	boolean vst[] = null;

	public int solve(int[] A, final int B, final int C) {
		int N = A.length;
		vst = new boolean[N+1];
		adj = new HashMap<>();
		for (int i = 1; i < A.length; i++) {
			adj.computeIfAbsent(A[i], val -> new ArrayList<Integer>()).add(A[i]);
			adj.computeIfAbsent(A[i], val -> new ArrayList<Integer>()).add(i + 1);
		}
		dfs(B, C);
		return reachable ? 1 : 0;
	}

	void dfs(int target, int source) {
		ArrayList<Integer> neighbours = adj.getOrDefault(source, new ArrayList<Integer>());
		vst[source] = true;
		for (Integer neighbour : neighbours) {
			if (neighbour == target) {
				reachable = true;
			}
			if (!vst[neighbour]) {
				dfs(target, neighbour);
			}
		}
	}

}
