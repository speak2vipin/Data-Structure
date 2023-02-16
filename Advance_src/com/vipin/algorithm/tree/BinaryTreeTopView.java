package com.vipin.algorithm.tree;

import java.util.List;
import java.util.Map;
import java.util.*;

public class BinaryTreeTopView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t4 = new TreeNode(4);
		TreeNode t2 = new TreeNode(2);
		TreeNode t5 = new TreeNode(5);
		TreeNode t1 = new TreeNode(1);
		
		TreeNode t51 = new TreeNode(51);

		t4.left = t2;
		t4.right = t5;
		t2.left = t1;
		t2.right = t51;
		BinaryTreeTopView b = new BinaryTreeTopView();
		b.solve(t4);
		
	}

	Map<Integer, List<Integer>> map = new HashMap<>();
	Queue<NewPair> qe = new LinkedList<NewPair>();
	int maxIndex = Integer.MIN_VALUE;
	int minIndex = Integer.MAX_VALUE;

	public int[] solve(TreeNode A) {
		if (A == null) {
			return new int[1];
		}
		traverse(A);
		int mapSize = map.size();
		int ans[] = new int[mapSize];
		int index = 0;
		for(int i=0; i>=minIndex; i--) {
			ans[index] = map.get(i).get(0);
			index++;
		}
		for(int i=1; i<=maxIndex; i++) {
			ans[index] = map.get(i).get(0);
			index++;
		}
		return ans;
	}

	void traverse(TreeNode root) {
		map.computeIfAbsent(0, value -> new ArrayList<Integer>()).add(root.val);
		qe.offer(new NewPair(root, 0));
		minIndex = Math.min(minIndex, 0);
		maxIndex = Math.min(maxIndex, 0);
		while (!qe.isEmpty()) {
			int size = qe.size();
			for (int i = 0; i < size; i++) {
				NewPair newPair = qe.poll();
				TreeNode temp = newPair.node;
				if (temp.left != null) {
					int leftIndex = newPair.index - 1;
					int leftVal = temp.left.val;
					map.computeIfAbsent(leftIndex, value -> new ArrayList<Integer>()).add(leftVal);
					qe.offer(new NewPair(temp.left, leftIndex));
					minIndex = Math.min(minIndex, newPair.index - 1);
				}
				if (temp.right != null) {
					int rightIndex = newPair.index + 1;
					int rightVal = temp.right.val;
					map.computeIfAbsent(rightIndex, value -> new ArrayList<Integer>()).add(rightVal);
					qe.offer(new NewPair(temp.right, rightIndex));
					maxIndex = Math.max(maxIndex, newPair.index + 1);
				}
				
				
			}
		}
	}

}

class NewPair {
	int index;
	TreeNode node;

	NewPair(TreeNode node, int index) {
		this.node = node;
		this.index = index;
	}
}
