package com.vipin.algorithms.tree;

import java.util.HashMap;
import java.util.Map;

public class WithPreorderAndInorderMakeBinaryTree {
	Map<Integer, Integer> inorderIndexMap;
	int preOrderIndex = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int []preorder = {3,9,20,15,7};
		int[] inorder = { 9, 3, 15, 20, 7 };
		int[] postorder = { 9, 15, 7, 20, 3 };

		int[] preorder = { 3, 1, 2, 4 };
		// int []inorder = {1,2,3,4};
		WithPreorderAndInorderMakeBinaryTree withPreorderAndInorderMakeBinaryTree = new WithPreorderAndInorderMakeBinaryTree();
		withPreorderAndInorderMakeBinaryTree.buildTree(postorder, inorder);
		withPreorderAndInorderMakeBinaryTree.buildTree(preorder, inorder);

	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		inorderIndexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			inorderIndexMap.put(inorder[i], i);
		}
		return buildBinaryTree(preorder, 0, inorder.length - 1);

	}

	TreeNode buildBinaryTree(int[] preorder, int left, int right) {
		if (left > right)
			return null;
		int val = preorder[preOrderIndex];
		TreeNode treeNode = new TreeNode(val);
		preOrderIndex++;
		treeNode.left = buildBinaryTree(preorder, left, inorderIndexMap.get(val) - 1);
		treeNode.right = buildBinaryTree(preorder, inorderIndexMap.get(val) + 1, right);
		return treeNode;
	}
}
