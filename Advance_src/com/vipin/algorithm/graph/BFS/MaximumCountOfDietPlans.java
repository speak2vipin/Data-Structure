package com.vipin.algorithm.graph.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumCountOfDietPlans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int B[][] = { { 1, 5 }, { 4, 6 }, { 18, 3 }, { 4, 5 }, { 15, 9 }, { 15, 4 } };
		int[][] C = { { 13, 20 }, { 7, 20 }, { 8, 19 }, { 13, 7 }, { 13, 8 }, { 2, 19 } };
		
		//	1,5,4,6,15,9  
		//	18,3
		//	13,20,7,8,19,2
		

		MaximumCountOfDietPlans m = new MaximumCountOfDietPlans();
		System.out.println(m.solve(20, B, C));

	}

	Map<Integer, ArrayList<Integer>> adjB = null;
	Map<Integer, ArrayList<Integer>> adjC = null;
	boolean visit[] = null;
	int mod = 1000000007;

	public int solve(int A, int[][] B, int[][] C) {
		adjB = new HashMap<>();
		adjC = new HashMap<>();
		for (int b[] : B) {
			int node = b[0];
			int neighbour = b[1];
			adjB.computeIfAbsent(node, val -> new ArrayList<Integer>()).add(neighbour);
			adjB.computeIfAbsent(neighbour, val -> new ArrayList<Integer>()).add(node);
		}
		for (int c[] : C) {
			int node = c[0];
			int neighbour = c[1];
			if (adjB.keySet().contains(node)) {
				return 0;
			}
			adjC.computeIfAbsent(node, val -> new ArrayList<Integer>()).add(neighbour);
			adjC.computeIfAbsent(neighbour, val -> new ArrayList<Integer>()).add(node);
		}

		visit = new boolean[A + 1];
		int groups = 0;
		for (int i = 1; i <= A; i++) {
			if (!visit[i]) {
				groups++;
				if (adjB.get(i) != null) {
					bfs(i, adjB);
				} else if (adjC.get(i) != null) {
					bfs(i, adjC);
				}
			}
		}

		int ans = (int) (fastPower(2, groups) % mod);

		return ans;
	}

	void bfs(int node, Map<Integer, ArrayList<Integer>> adj) {
		Queue<Integer> qe = new LinkedList<>();
		visit[node] = true;
		qe.offer(node);
		while (!qe.isEmpty()) {
			int top = qe.poll();
			ArrayList<Integer> neighbours = adj.getOrDefault(top, new ArrayList<Integer>());

			for (Integer neighbour : neighbours) {
				if (!visit[neighbour]) {
					visit[neighbour] = true;
					qe.offer(neighbour);
				}
			}
		}
	}

	long fastPower(long base, long p) {
		if (p == 0) {
			return 1;
		}
		if ((p % 2) == 0) {
			return fastPower((base * base) % mod, p / 2) % mod;
		} else {
			return (base % mod * fastPower((base * base) % mod, p / 2) % mod) % mod;
		}
	}

}
