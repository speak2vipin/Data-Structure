package com.vipin.algorithm.tree;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TreeVerticalTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode t5 = new TreeNode(5);
		TreeNode t8 = new TreeNode(8262);
		t5.left = t8;
		TreeNode t4 = new TreeNode(411);
		t8.left = t4;
		TreeVerticalTraversal t = new TreeVerticalTraversal();
		t.verticalOrderTraversal(t5);

	}

	Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	int minIndex = Integer.MAX_VALUE;
	int maxIndex = Integer.MIN_VALUE;

	public int[][] verticalOrderTraversal(TreeNode A) {
		if (A == null) {
			return new int[1][];
		}
		treeTraversing(A);
		int ans[][] = new int[map.size()][];
		int start = 0;
		for (int i = minIndex; i <= maxIndex; i++) {
			List<Integer> tempList = map.get(i);
			int size = tempList.size();
			int temp[] = new int[size];
			for (int j = 0; j < size; j++) {
				temp[j] = tempList.get(j);
			}
			ans[start] = temp;
			start++;
		}
		return ans;
	}

	void treeTraversing(TreeNode root) {
		/*
		 * if(root==null) { return; } minIndex = Math.min(minIndex, index); maxIndex =
		 * Math.max(maxIndex, index); List<Integer> l = null; if(map.get(index)==null) {
		 * l = new ArrayList<Integer>(); l.add(root.val); map.put(index, l); } else {
		 * map.get(index).add(root.val); } treeTraversing(root.left, index-1);
		 * treeTraversing(root.right, index+1);
		 */
		int index = 0;
		Queue<Pair> qe = new LinkedList<Pair>();
		qe.add(new Pair(0, root));
		while (!qe.isEmpty()) {
			int size = qe.size();
			int sum = (int) (Math.pow(2, 3) - 1);
			for (int i = 0; i < size; i++) {
				Pair temp = qe.poll();
				int tempIndex = temp.index;
				if (temp.treeNode != null) {
					if (temp.treeNode.left != null) {
						qe.add(new Pair(tempIndex - 1, temp.treeNode.left));
					}
					if (temp.treeNode.right != null) {
						qe.add(new Pair(tempIndex + 1, temp.treeNode.right));
					}
				}
				minIndex = Math.min(minIndex, tempIndex);
				maxIndex = Math.max(maxIndex, tempIndex);
				List<Integer> l = null;
				if (map.get(tempIndex) == null) {
					l = new ArrayList<Integer>();
					l.add(root.val);
					map.put(tempIndex, l);
				} else {
					l = map.get(tempIndex);
					l.add(root.val);
					map.put(tempIndex, l);
				}
			}
		}

	}

}

class Pair {
	TreeNode treeNode;
	int index;

	public Pair(int index, TreeNode treeNode) {
		this.index = index;
		this.treeNode = treeNode;
	}
}
