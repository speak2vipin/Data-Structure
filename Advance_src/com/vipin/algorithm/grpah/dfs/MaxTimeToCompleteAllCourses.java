package com.vipin.algorithm.grpah.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MaxTimeToCompleteAllCourses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int r[][] = {{1,5},{2,5},{3,5},{3,4},{4,5}};
		int time[] = {1,2,3,4,5};
		System.out.println(minimumTime(n, r, time));
	}
	
	public static int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for(int r []: relations) {
            int source = r[0];
            int dest = r[1];
            adj.computeIfAbsent(source, val -> new ArrayList<Integer>()).add(dest);
        }
        int indegree[] = new int[n+1];
        
        for(int r[] : relations) {
            int source = r[0];
            int dest = r[1];
            indegree[dest]++;
        }
        Queue<Integer> qe = new LinkedList<>();
        int maxTime[] = new int[n+1];
        for(int i=1;i<n+1; i++) {
            if(indegree[i]==0) {
                qe.offer(i);
                maxTime[i] = time[i-1];
            }
        }
        while(!qe.isEmpty()) {
            int top = qe.poll();
            ArrayList<Integer> neighbors = 
                adj.getOrDefault(top, new ArrayList<Integer>());
            for(int neighbor : neighbors) {
                maxTime[neighbor] = Math.max(maxTime[neighbor], 
                                             time[neighbor-1] + maxTime[top]);
                indegree[neighbor]--;
                if(indegree[neighbor]==0) {
                    qe.add(neighbor);
                }
            } 
        }
        int ans = Integer.MIN_VALUE;
        for(int i=1; i<n+1; i++) {
            ans = Math.max(ans, maxTime[i]);
        }
        return ans;
    }
	
	 boolean dfs(List<List<Integer>> adj, int node, int visit[], int path[]) {
	        visit[node] = 1;
	        path[node] = 1;
	        List<Integer> neighbors = adj.get(node);
	        for(Integer n : neighbors) {
	            if(visit[n]==0 && dfs(adj, n, visit, path)) {
	                return true;
	            } else if(path[n]==1) {
	                return true;
	            }
	        }
	        path[node] = 0;
	        return false;
	    }

}

