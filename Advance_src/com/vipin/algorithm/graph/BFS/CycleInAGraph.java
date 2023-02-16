package com.vipin.algorithm.graph.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CycleInAGraph {
	Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
	// boolean path[];
	boolean visit[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		B.add(a);
		CycleInAGraph c = new CycleInAGraph();
		System.out.println(c.solve(2, B));

	}

	public int solve(int A, ArrayList<ArrayList<Integer>> B) {

		visit = new boolean[A];
		for (ArrayList<Integer> edges : B) {
			adj.computeIfAbsent(edges.get(0), val -> new ArrayList<Integer>()).add(edges.get(1));
		}
		for (int i = 1; i <= A; i++) {
			boolean path[] = new boolean[A];
			if (!visit[i - 1] && adj.get(i) != null) {

				if (dfs(i, path)) {
					return 1;
				}
			}
		}
		return 0;
	}

	boolean dfs(int node, boolean path[]) {
		visit[node - 1] = true;
		path[node - 1] = true;
		if (adj.get(node) != null) {
			for (int edge : adj.get(node)) {
				if (path[edge - 1]) {
					return true;
				}
				if (!visit[edge - 1] && dfs(edge, path)) {
					return true;
				}
			}
		}
		path[node - 1] = false;
		return false;
	}

}
