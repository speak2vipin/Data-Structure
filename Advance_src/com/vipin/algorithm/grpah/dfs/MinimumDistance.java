package com.vipin.algorithm.grpah.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A = 6;
		int B[][] = { { 2, 5, 1 }, { 1, 3, 1 }, { 0, 5, 2 }, { 0, 2, 2 }, { 1, 4, 1 }, { 0, 1, 1 } };
		int C = 3;
		int D = 2;
		MinimumDistance m = new MinimumDistance();
		System.out.println(m.solve(A, B, C, D));

	}

	Map<Integer, ArrayList<Edge>> adj = null;

	public int solve(int A, int[][] B, int C, int D) {
		
		long mod = 1000000007;

		adj = new HashMap<>();
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comparator<Edge>() {
			public int compare(Edge e1, Edge e2) {
				return e1.wt - e2.wt;
			}
		});

		for (int[] neighbour : B) {
			adj.computeIfAbsent(neighbour[0], val -> new ArrayList<Edge>()).add(new Edge(neighbour[1], neighbour[2]));
			adj.computeIfAbsent(neighbour[1], val -> new ArrayList<Edge>()).add(new Edge(neighbour[0], neighbour[2]));
		}

		pq.offer(new Edge(C, 0));
		long dist[] = new long[A];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[C] = 0;	
		
		while (!pq.isEmpty()) {
			Edge top = pq.poll();
			if(top.v==D) {
				return (int)(dist[top.v]%mod);
			}
			if(adj.get(top.v)!=null) {
				ArrayList<Edge> l= adj.get(top.v);
				
				for(Edge neighbours : l) {
					int wt = neighbours.wt;
					int v = neighbours.v;
					if(wt+top.wt<dist[v]) {
						dist[v] = wt+top.wt;
						pq.offer(new Edge(v, wt+top.wt));
					}
				}
				
			}
		}
		return -1;
	}
}



/*
 * class Edge { int v; int wt;
 * 
 * Edge(int v, int wt) { this.v = v; this.wt = wt; } }
 */
