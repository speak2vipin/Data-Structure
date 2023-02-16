package com.vipin.algorithm.graph.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSameLabels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 4;
		int [][] edges = {{0,1},{1,2},{0,3}};
		
		String labels = "bbbb";
		CountSameLabels c = new CountSameLabels();
		int output[] = c.countSubTrees(n, edges, labels);
		for(int i : output) {
			System.out.println(i);
		}
	}
	
	int ans[];
    String input = null;;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        input = labels;
        ans = new int[n];
        Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
        for(int[] edge : edges) {
            adj.computeIfAbsent(edge[0], (val -> new ArrayList<Integer>())).add(edge[1]);
            adj.computeIfAbsent(edge[1], (val -> new ArrayList<Integer>())).add(edge[0]);
        }
        helper(adj, 0, -1);
        return ans;
    }
    
    int[] helper(Map<Integer, List<Integer>> adj , int root, int parent) {
        
        int nodeCounts[] = new int[26];
        // Increase count of current character by 1 in alphabet array
        nodeCounts[input.charAt(root)-'a']=1;
        if(adj.get(root)==null) {
        	return nodeCounts;
        } else {
        	List<Integer>l = adj.get(root);
        	int tempNodeCount[] = new int[26];
        	for(int i=0; i<l.size(); i++) {
        		int childRoot = l.get(i);
        		if(parent==childRoot) {
        			continue;
        		}
        		tempNodeCount = helper(adj, childRoot, root);
        		// Add the child alphabet array to current array
            	for(int j=0; j<26; j++) {
            		nodeCounts[j] += tempNodeCount[j]; 
            	}
        	}
        	
        	// Create output
        	ans[root] = nodeCounts[input.charAt(root)-'a'];
        	return nodeCounts;
        	
        }
    }

}





class Solution {
    public int[] dfs(int node, int parent, Map<Integer, List<Integer>> adj,
            char[] labels, int[] ans) {
        // Store count of all alphabets in the subtree of the node.
        int[] nodeCounts = new int[26];
        nodeCounts[labels[node] - 'a'] = 1;

        if (!adj.containsKey(node))
            return nodeCounts;
        for (int child : adj.get(node)) {
            if (child == parent) {
                continue;
            }
            int[] childCounts = dfs(child, node, adj, labels, ans);
            // Add frequencies of the child node in the parent node's frequency array.
            for (int i = 0; i < 26; i++) {
                nodeCounts[i] += childCounts[i];
            }
        }

        ans[node] = nodeCounts[labels[node] - 'a'];
        return nodeCounts;
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }

        int[] ans = new int[n];
        char[] label = labels.toCharArray();
        dfs(0, -1, adj, label, ans);
        return ans;
    }
}