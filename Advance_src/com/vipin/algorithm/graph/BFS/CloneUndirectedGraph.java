package com.vipin.algorithm.graph.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneUndirectedGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return node;
		if (visited.containsKey(node))
			return visited.get(node);
		UndirectedGraphNode root = new UndirectedGraphNode(node.label);
		visited.put(node, root);
		for (UndirectedGraphNode neighborNode : node.neighbors) {
			root.neighbors.add(cloneGraph(neighborNode));
		}
		return root;

	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}

}
