package com.vipin.algorithms.tree;

import java.util.HashMap;
import java.util.Map;

public class TwoNodesHavingSumToB {
	Map<Integer, Integer> nodesAndCount = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 7 10 9 20 -1 -1 -1 -1
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);

		TwoNodesHavingSumToB t = new TwoNodesHavingSumToB();
		System.out.println(t.t2Sum(root, 19));

	}

	public int t2Sum(TreeNode A, int B) {
		nodesAndCount = new HashMap<>();
		traversal(A);
		for (Integer value : nodesAndCount.keySet()) {
			nodesAndCount.put(value, nodesAndCount.get(value) - 1);
			if (nodesAndCount.get(B - value) != null && nodesAndCount.get(B - value) > 0) {
				return 1;
			}
			nodesAndCount.put(value, nodesAndCount.get(value) + 1);

		}
		return 0;
	}

	void traversal(TreeNode root) {
		if (root == null) {
			return;
		}
		traversal(root.left);
		nodesAndCount.put(root.val, nodesAndCount.getOrDefault(root.val, 0) + 1);
		traversal(root.right);
	}
}
