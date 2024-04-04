package com.vipin.algorithm.graph.disjointunion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NoOfDetonatorsBlasts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int bombs[][] = {{855,82,158},
						 {17,719,430},
						 {90,756,164},
						 {376,17,340},
						 {691,636,152},
						 {565,776,5},
						 {464,154,271},
						 {53,361,162},
		
			 {278,609,82},{202,927,219},{542,865,377},{330,402,270},{720,199,10},{986,697,443},{471,296,69},{393,81,404},{127,405,177}};
		NoOfDetonatorsBlasts d = new NoOfDetonatorsBlasts();
		System.out.println(d.maximumDetonation(bombs));
	}

	Map<Integer, List<Integer>> adj = new HashMap<>();
	boolean visit[] = null;
	int count = 0;
	int res = Integer.MIN_VALUE;

	public int maximumDetonation(int[][] bombs) {
		
		int N = bombs.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i==j) {
                    continue;
                }
				int cx1 = bombs[i][0];
				int cy1 = bombs[i][1];
				int r1 = bombs[i][2];
				int cx2 = bombs[j][0];
				int cy2 = bombs[j][1];
				long dist = 1l * (cx1 - cx2) * (cx1 - cx2) + 1l * (cy1 - cy2) * (cy1 - cy2);

				if (1l * r1 * r1 >= dist) {
					adj.computeIfAbsent(i, val -> new ArrayList<Integer>()).add(j);
				} 
	        }
		}

		int answer = 0;
        for (int i = 0; i < N; i++) {
        	visit = new boolean[N];
        	if (!visit[i]) {
				count = 1;
				dfs(i);
				answer = Math.max(answer, count);
        	}
        }
		return answer;
	}	

	void dfs(int node) {
		visit[node] = true;
		if (adj.get(node) != null) {
			for (Integer neighbour : adj.get(node)) {
				if (!visit[neighbour]) {
					count++;
					dfs(neighbour);
				}
			}
		}
	}
	
	
	/*private int bfs(int i, Map<Integer, List<Integer>> graph) {
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(i);
        visited.add(i);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int neib : graph.getOrDefault(cur, new ArrayList<>())) {
                if (!visited.contains(neib)) {
                    visited.add(neib);
                    queue.offer(neib);
                }
            }
        }
        return visited.size();
    }*/
}
