package com.vipin.algorithm.graph.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopologicalSortingByDisjointAcyclicGraphDAG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopologicalSortingByDisjointAcyclicGraphDAG t = new TopologicalSortingByDisjointAcyclicGraphDAG();
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(1);
		a1.add(2);
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(2);
		a2.add(3);
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(3);
		a3.add(1);
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		B.add(a1);
		B.add(a2);
		B.add(a3);
		t.solve(3, B);
		
	}

	Map<Integer, ArrayList<Integer>> adj = null;
	int parent[];
	ArrayList<Integer> ans = new ArrayList<Integer>();

	public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
	        adj = new HashMap<Integer, ArrayList<Integer>>();
	        parent = new int[A+1];
	        Arrays.fill(parent, -1);
	        
	        for(ArrayList<Integer> edge : B) {
	            adj.computeIfAbsent(edge.get(0), val->new ArrayList<Integer>()).add(edge.get(1));
	        }
	        for(int i=1; i<A+1; i++) {
	            if(parent[i]==-1) {
	                parent[i] = i;
	                ans.add(i);
	            }
	            if(!dfs(i)) {
	                ans.clear();
	                break;
	            }
	        }
	        return ans;
	    }

	boolean dfs(int node) {
	        if(adj.get(node)!=null) {
	            for(int neighbor : adj.get(node)) { 
	                if(parent[neighbor]==-1) {
	                    ans.add(neighbor);
	                    parent[neighbor] = node;
	                    if(!dfs(neighbor)) {
	                        return false;
	                    }
	                } else {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }

}
