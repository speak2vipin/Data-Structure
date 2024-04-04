package com.vipin.algorithm.graph.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class NodeAtEquidistant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node10 = new Node(10);
		Node node14 = new Node(14);
		Node node12 = new Node(12);
		node12.left = node10;
		node12.right = node14;
		Node node8 = new Node(8);
		Node node4 = new Node(4);
		node8.left = node4;
		node8.right = node12;
		Node node20 = new Node(20);
		Node node22 = new Node(22);
		node20.left = node8;
		node20.right = node22;
		KDistanceNodes(node20, 8, 2);
		

	}

	public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
		// return the sorted list of all nodes at k dist
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
		HashSet<Integer> visited = new HashSet<>();
		Queue<int[]> qe = new LinkedList<>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		formGraph(graph, root, null);
		if (graph.get(target) != null) {
			qe.offer(new int[] { target, 0 });
			visited.add(target);
			while (!qe.isEmpty()) {
				int[] top = qe.poll();
				int element = top[0];
				int distance = top[1];
				if (distance == k) {
					ans.add(element);
					continue;
				}
				if (graph.get(element) != null) {
					for (Integer neighbor : graph.get(element)) {
						if (!visited.contains(neighbor)) {
							qe.offer(new int[] { neighbor, distance + 1 });
							visited.add(neighbor);
						}
					}
				}
			}
		}
		Collections.sort(ans);
		return ans;
	}

	static void formGraph(HashMap<Integer, ArrayList<Integer>> graph, Node node, Node parent) {
		if (node != null && parent != null) {
			ArrayList<Integer> nodeL = graph.getOrDefault(node.data, new ArrayList<Integer>());
			nodeL.add(parent.data);
			graph.put(node.data, nodeL);
			ArrayList<Integer> nodeP = graph.getOrDefault(parent.data, new ArrayList<Integer>());
			nodeP.add(node.data);
			graph.put(parent.data, nodeP);
		}
		if (node != null && node.left != null) {
			formGraph(graph, node.left, node);
		}
		if (node != null && node.right != null) {
			formGraph(graph, node.right, node);
		}
	}

}

class Node {
	int data;
	Node left, right;
	public Node(int data) {
		super();
		this.data = data;
	}
	
}
