package com.vipin.algorithm.graph.disjointunion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxDistanceBetweenTwiNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { -1, 0, 0 };
		MaxDistanceBetweenTwiNode m = new MaxDistanceBetweenTwiNode();

		System.out.println(m.solve(A));
		
		int [][]bombs = {{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}};
		System.out.println(m.maximumDetonation(bombs));
	}

	int N = 0;
	int res = 0;

	public int solve(int[] A) {
		N = A.length;
		List<List<Integer>> graph = buildGraph(A);
		boolean visit[] = new boolean[N];
		visit[0] = true;
		dfs(graph, visit, 0);
		return res;

	}

	private List<List<Integer>> buildGraph(int A[]) {
		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] == -1) {
				continue;
			}
			graph.get(i).add(A[i]);
			graph.get(A[i]).add(i);
		}
		return graph;
	}

	int dfs(List<List<Integer>> graph, boolean visit[], int source) {
		int max1 = 0;
		int max2 = 0;
		int max = 0;
		List<Integer> neighbors = graph.get(source);
		for (Integer neighbor : neighbors) {
			if (!visit[neighbor]) {

				visit[neighbor] = true;
				int s = 1 + dfs(graph, visit, neighbor);
				if(s>=max1) {
					max2 = max1;
					max1 = s;
				} else if(s>=max2) {
					max2 = s;
				}
				max = Math.max(max, s);
			}
		}
		res = Math.max(res, max1 + max2);
		return max;
	}
	
	
}
