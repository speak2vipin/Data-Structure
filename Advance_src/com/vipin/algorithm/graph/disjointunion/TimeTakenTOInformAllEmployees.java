package com.vipin.algorithm.graph.disjointunion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TimeTakenTOInformAllEmployees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimeTakenTOInformAllEmployees t = new TimeTakenTOInformAllEmployees();
		int n = 6;
		int headID = 2;
		int[] manager = { 2, 2, -1, 2, 2, 2 };
		int informTime[] = { 0, 0, 1, 0, 0, 0 };
		System.out.println(t.numOfMinutes(n, headID, manager, informTime));

	}

	Map<Integer, ArrayList<Integer>> adj = new HashMap<>();

	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

		for (int i = 0; i < n; i++) {
			if (manager[i] != -1)
				adj.computeIfAbsent(manager[i], val -> new ArrayList<>()).add(i);
		}

		int res = 0;
		
		ArrayList<Integer> subordinates = adj.getOrDefault(headID, new ArrayList<Integer>());
		int time = 0;
		for (Integer subordinate : subordinates) {
			time = informTime[headID] + dfs(subordinate, informTime);
			res = Math.max(res, time);
		}
		return time;
	}

	int dfs(int node, int[] informTime) {
		int time = 0;
		ArrayList<Integer> subordinates = adj.getOrDefault(node, new ArrayList<Integer>());
		for (Integer subordinate : subordinates) {
			time += informTime[node] + dfs(subordinate, informTime);
		}
		return time;
	}
	

}
