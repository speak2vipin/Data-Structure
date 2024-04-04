package com.vipin.algorithm.grpah.dfs;

import java.util.ArrayList;
import java.util.*;

public class MinCostForRoadsConstruction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A = 3;
		int[][] B = { { 1, 2, 14 }, { 2, 3, 7 }, { 3, 1, 2 } };
		MinCostForRoadsConstruction m = new MinCostForRoadsConstruction();
		System.out.println(m.solve(A, B));

	}

	Map<Integer, ArrayList<Edge1>> adj = null;

	public int solve(int A, int[][] B) {
		int mod = 1000000007;
		int N = B.length;
		adj = new HashMap<>();
		for (int[] edge : B) {
			adj.computeIfAbsent(edge[0], val -> new ArrayList<Edge1>()).add(new Edge1(edge[1], edge[2]));
			adj.computeIfAbsent(edge[1], val -> new ArrayList<Edge1>()).add(new Edge1(edge[0], edge[2]));
		}
		PriorityQueue<Edge1> pq = new PriorityQueue<Edge1>(new Comparator<Edge1>() {

			public int compare(Edge1 e1, Edge1 e2) {
				return e1.wt - e2.wt;
			}
		});

		pq.offer(new Edge1(1, 0));

		boolean visit[] = new boolean[A + 1];
		long cost = 0;
		while (!pq.isEmpty()) {
			Edge1 top = pq.poll();
			
			
			if(!visit[top.v]) {
				visit[top.v] = true;
				cost = (cost + top.wt) % mod;
				ArrayList<Edge1> neighbors = adj.getOrDefault(top.v, new ArrayList<Edge1>());
				for (Edge1 edge : neighbors) {
					pq.offer(new Edge1(edge.v, edge.wt));
				}
			}
		}
		return (int) cost;
	}
}

class Edge1 {
	int v;
	int wt;

	public Edge1(int v, int wt) {
		this.wt = wt;
		this.v = v;
	}
}
