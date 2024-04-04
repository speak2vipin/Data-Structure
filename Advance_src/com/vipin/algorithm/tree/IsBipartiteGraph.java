package com.vipin.algorithm.tree;

import java.util.*;

public class IsBipartiteGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(2);a1.add(5);
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(6);a2.add(7);
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(4);a3.add(8);
		ArrayList<Integer> a4 = new ArrayList<Integer>();
		a4.add(2);a4.add(3);
		ArrayList<Integer> a5 = new ArrayList<Integer>();
		a5.add(0);a5.add(3);
		ArrayList<Integer> a6 = new ArrayList<Integer>();
		a6.add(4);a6.add(7);
		ArrayList<Integer> a7 = new ArrayList<Integer>();
		a7.add(1);a7.add(8);
		ArrayList<Integer> a8 = new ArrayList<Integer>();
		a8.add(3);a8.add(8);
		ArrayList<Integer> a9 = new ArrayList<Integer>();
		a9.add(1);a9.add(3);
		B.add(a1); B.add(a2); B.add(a3); B.add(a4); B.add(a5); B.add(a6); 
		B.add(a7); B.add(a8); B.add(a9);
		IsBipartiteGraph s = new IsBipartiteGraph();
		System.out.println(s.solve(9, B));

	}

	Map<Integer, List<Integer>> adj = null;
	int color[];

	public int solve(int A, ArrayList<ArrayList<Integer>> B) {
		adj = new HashMap<Integer, List<Integer>>();
		color = new int[A];
		Arrays.fill(color, -1);
		for (ArrayList<Integer> edge : B) {
			adj.computeIfAbsent(edge.get(0), val -> new ArrayList<Integer>()).add(edge.get(1));
			adj.computeIfAbsent(edge.get(1), val -> new ArrayList<Integer>()).add(edge.get(0));
		}
		//color[0] = 1;
		for (int i = 0; i < A; i++) {
			if (color[i]==-1) {
				color[i] = 0;
				if(!dfs(i)) {
					return 0;
				}
			}
		}
		return 1;
	}

	boolean dfs(int node) {
		if (adj.get(node) != null) {
			for (int neighbor : adj.get(node)) {
				if (color[neighbor] == -1) {
					color[neighbor] = 1 ^ color[node];
					if (!dfs(neighbor)) {
						return false;
					}
				} else if (color[neighbor] == color[node]) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	

}
