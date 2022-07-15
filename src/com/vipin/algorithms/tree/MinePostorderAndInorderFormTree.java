package com.vipin.algorithms.tree;

import java.util.HashMap;
import java.util.Map;
/**
 * Trick in postorder last node will be root and second last would be the right node. So form Root 
 * and then create right node and create left node
 * @author vipingupta
 *
 */
public class MinePostorderAndInorderFormTree {

	static int postorderIndex;
	static Map<Integer, Integer> inorderIndexMap;

	public static void main(String[] args) {

		int[] inorder = { 9, 3, 15, 20, 7 };
		int[] postorder = { 9, 15, 7, 20, 3 };
		buildTree(postorder, inorder);
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {

		postorderIndex = inorder.length - 1;
		// build a hashmap to store value -> its index relations
		inorderIndexMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inorderIndexMap.put(inorder[i], i);
		}
		boolean[] isVisisted = new boolean[preorder.length];
		return arrayToTreePostOrder(preorder, false, false, null, isVisisted, inorder);

	}

	private static TreeNode arrayToTreePostOrder(int[] postorder, Boolean left, Boolean right, TreeNode treeNode,
			boolean[] isVisited, int[] inorder) {
		// if there are no elements to construct the tree
		if (left == null && !right || right == null && !left) {
			return null;
		}
		int val = postorder[postorderIndex];
		TreeNode root = new TreeNode(val);
		int tempI = inorderIndexMap.get(val);
		isVisited[tempI] = true;
		Integer tempILeft = null;
		Integer tempIRight = null;
		if (tempI - 1 > -1) {
			tempILeft = inorderIndexMap.get(inorder[tempI - 1]);
		}
		if (tempI + 1 < postorder.length) {
			tempIRight = inorderIndexMap.get(inorder[tempI + 1]);
		}
		if (left && treeNode != null) {
			treeNode.left = root;
		} else if (right && treeNode != null) {
			treeNode.right = root;
		}

		if (tempIRight != null && !isVisited[tempIRight]) {
			right = true;
			postorderIndex--;
		} else if (tempIRight == null || (tempIRight != null && isVisited[tempIRight])) {
			right = null;
		}
		root.right = arrayToTreePostOrder(postorder, false, right, root, isVisited, inorder);

		if (tempILeft != null && !isVisited[tempILeft]) {
			left = true;
			postorderIndex--;
		} else if (tempILeft == null || (tempILeft != null && isVisited[tempILeft])) {
			left = null;
		}
		root.left = arrayToTreePostOrder(postorder, left, false, root, isVisited, inorder);
		return root;

	}
}
