package com.vipin.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode right8 = new TreeNode(8);
		TreeNode left0 = new TreeNode(0);
		TreeNode left6 = new TreeNode(6);
		TreeNode left4 = new TreeNode(4);
		TreeNode left7 = new TreeNode(7);
		TreeNode right2 = new TreeNode(2, left4, left7);
		TreeNode left1 = new TreeNode(1, left0, right8);
		TreeNode right5 = new TreeNode(5, left6, right2);
		TreeNode root = new TreeNode(3, left1, right5);
		flatten(root);
	}

	public static void flatten(TreeNode root) {
		if (root != null) {
			Queue<TreeNode> tQueue = new LinkedList<TreeNode>();
			//tQueue.offer(root);
			TreeNode temp = null;
			enqueueTreeNode(tQueue, root);
			while (tQueue.size() != 0) {
				if (temp == null) {
					temp = new TreeNode(tQueue.poll().val);
					root = temp;
				} else {
					temp.right = new TreeNode(tQueue.poll().val);
					temp = temp.right;
				}
			}
		}
		System.out.println("In end");
	}

	static void enqueueTreeNode(Queue<TreeNode> q, TreeNode root) {
		if (root == null) {
			return;
		}
		q.add(root);
		enqueueTreeNode(q, root.left);
		enqueueTreeNode(q, root.right);
	}
}
