package com.vipin.algorithm.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class NodesWithEqualDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		TreeNode root5 = new TreeNode(5);
		TreeNode root1 = new TreeNode(1);
		TreeNode root6 = new TreeNode(6);
		TreeNode root2 = new TreeNode(2);
		TreeNode root0 = new TreeNode(0);
		TreeNode root8 = new TreeNode(8);
		TreeNode root7 = new TreeNode(7);
		TreeNode root4 = new TreeNode(4);
		//root.left = root5;
		root.right = root1;
		//root5.left = root6;
		//root5.right = root2;
		//root1.left = root0;
		root1.right = root8;
		//root2.left = root7;
		root8.right = root4;
		
		distanceK(root, root1, 2);

	}
	
	class Solution {
	    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
	        Map<Integer, List<Integer>> graph = new HashMap<>();
	        dfsBuild(root, null, graph);
	        
	        List<Integer> answer = new ArrayList<>();
	        Set<Integer> visited = new HashSet<>();
	        Queue<int[]> queue = new LinkedList<>();
	        
	        // Add the target node to the queue with a distance of 0
	        queue.add(new int[]{target.val, 0});
	        visited.add(target.val);
	        
	        while (!queue.isEmpty()) {
	            int[] cur = queue.poll();
	            int node = cur[0], distance = cur[1];
	            
	            // If the current node is at distance k from target,
	            // add it to the answer list and continue to the next node.
	            if (distance == k) {
	                answer.add(node);
	                continue;
	            }
	            
	            // Add all unvisited neighbors of the current node to the queue.
	            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
	                if (!visited.contains(neighbor)) {
	                    visited.add(neighbor);
	                    queue.add(new int[]{neighbor, distance + 1});
	                }
	            }
	        }
	        
	        return answer;
	    }
	    
	    // Recursively build the undirected graph from the given binary tree.
	    private void dfsBuild(TreeNode cur, TreeNode parent, Map<Integer, List<Integer>> graph) {
	        if (cur != null && parent != null) {
	            int curVal = cur.val, parentVal = parent.val;
	            graph.putIfAbsent(curVal, new ArrayList<>());
	            graph.putIfAbsent(parentVal, new ArrayList<>());
	            graph.get(curVal).add(parentVal);
	            graph.get(parentVal).add(curVal);
	        }
	        
	        if (cur != null && cur.left != null) {
	            dfsBuild(cur.left, cur, graph);
	        }
	        
	        if (cur != null && cur.right != null) {
	            dfsBuild(cur.right, cur, graph);
	        }
	    }
	}

}
