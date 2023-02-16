package com.vipin.algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopologicalSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(1);
		a1.add(4);

		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(1);
		a2.add(2);
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(4);
		a3.add(2);
		ArrayList<Integer> a4 = new ArrayList<Integer>();
		a4.add(3);
		a4.add(2);
		ArrayList<Integer> a5 = new ArrayList<Integer>();
		a5.add(5);
		a5.add(2);

		ArrayList<Integer> a6 = new ArrayList<Integer>();
		a6.add(3);
		a6.add(5);
		ArrayList<Integer> a7 = new ArrayList<Integer>();
		a7.add(8);
		a7.add(2);
		ArrayList<Integer> a8 = new ArrayList<Integer>();
		a8.add(8);
		a8.add(6);
		B.add(a1);
		B.add(a2);
		B.add(a3);
		B.add(a4);
		B.add(a5);
		B.add(a6);
		B.add(a7);
		B.add(a8);
		TopologicalSort t = new TopologicalSort();
		System.out.println(t.solve(8, B));

	}

	Map<Integer, ArrayList<Integer>> adj = null;
	int parent[];
	ArrayList<Integer> ans = new ArrayList<Integer>();

	public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
		adj = new HashMap<Integer, ArrayList<Integer>>();
		parent = new int[A + 1];
		Arrays.fill(parent, -1);

		for (ArrayList<Integer> edge : B) {
			adj.computeIfAbsent(edge.get(0), val -> new ArrayList<Integer>()).add(edge.get(1));
		}
		for (int i = 1; i < A + 1; i++) {
			if(parent[i] != -1) {
				continue;
			} else {
				
				if (!dfs(i)) {
					ans.clear();
					break;
				}
			}
		}
		return ans;
	}

	boolean dfs(int node) {
		if (adj.get(node) != null) {
			//parent[node] = node;
			ans.add(node);
			for (int neighbor : adj.get(node)) {
				
				if (parent[neighbor] == -1) {
					
					//ans.add(neighbor);
					parent[neighbor] = node;
					if (!dfs(neighbor)) {
						return false;
					}
				} else if(parent[neighbor] == parent[node]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Colleaction.sort(A);
        int mod = 1000000007;
        int size = A.size();
        int min = 0;
        int max = 0;
        for(int i=0; i<(size/2); i++) {
            max = (max + (A.get(size-1-i) - A.get(i)))%mod; 
        }
        for(int i=0; i<size-1; i=i+2) {
            min = (min + (A.get(i+1)-A.get(i)))%mod;
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(max); ans.add(min);
        return ans;
    }

}
