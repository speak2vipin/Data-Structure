package com.vipin.algorithm.graph.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindSafeNodeInGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][] = {{0},{2,3,4},{3,4},{0,4},{}};
		
		FindSafeNodeInGraph f = new FindSafeNodeInGraph();
		List<Integer> res = f.eventualSafeNodes(graph);
		for(Integer val : res) {
			System.out.println(val);
		}
	}
	
	/*Map<Integer, ArrayList<Integer>> adj = null;
    boolean visit[] = null;
    int[] ans = null;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        adj = new HashMap<>();
        int n = graph.length;
        visit = new boolean[n];
        ans = new int[n];
        for(int i=0; i<n; i++) {
            for(int node : graph[i]) {
            	//if(i!=node)
            		adj.computeIfAbsent(i, val->new ArrayList<Integer>()).add(node);
            }
        }
        for(int i=0; i<n; i++) {
            if(!visit[i]) {
                dfs(i, new HashSet<Integer>());
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(ans[i]==1) {
                res.add(i);
            }
        }
        return res;
    }
    
    boolean dfs(int node, Set<Integer> path) {
        path.add(node);
        visit[node]=true;
        if(adj.get(node)!=null) {
            ArrayList<Integer> neighbors = adj.get(node);
            for(Integer neighbor : neighbors) {
                if(path.contains(neighbor)){
                    return true;
                }
                if(dfs(neighbor, path)) {
                    return true;
                }
            }
        }
        path.remove(node);
        ans[node]=1;
        return false;
    }
}*/

	
	public boolean dfs(int node, List<List<Integer>> adj, boolean[] visit, boolean[] inStack) {
        // If the node is already in the stack, we have a cycle.
        if (inStack[node]) {
            return true;
        }
        if (visit[node]) {
            return false;
        }
        // Mark the current node as visited and part of current recursion stack.
        visit[node] = true;
        inStack[node] = true;
        for (int neighbor : adj.get(node)) {
            if (dfs(neighbor, adj, visit, inStack)) {
                return true;
            }
        }
        // Remove the node from the stack.
        inStack[node] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            for (int node : graph[i]) {
                adj.get(i).add(node);
            }
        }

        boolean[] visit = new boolean[n];
        boolean[] inStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            dfs(i, adj, visit, inStack);
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!inStack[i]) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
}


/*class Solution {
    public boolean dfs(int node, List<List<Integer>> adj, boolean[] visit, boolean[] inStack) {
        // If the node is already in the stack, we have a cycle.
        if (inStack[node]) {
            return true;
        }
        if (visit[node]) {
            return false;
        }
        // Mark the current node as visited and part of current recursion stack.
        visit[node] = true;
        inStack[node] = true;
        for (int neighbor : adj.get(node)) {
            if (dfs(neighbor, adj, visit, inStack)) {
                return true;
            }
        }
        // Remove the node from the stack.
        inStack[node] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            for (int node : graph[i]) {
                adj.get(i).add(node);
            }
        }

        boolean[] visit = new boolean[n];
        boolean[] inStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            dfs(i, adj, visit, inStack);
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!inStack[i]) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
}*/
