package com.vipin.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

public class CreateTreeWithInorderAndPostOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 4,2,5, 1, 6, 3,7 };
		int[] B = { 4,5,2,6,7,3,1 };
		CreateTreeWithInorderAndPostOrder c = new CreateTreeWithInorderAndPostOrder();
		c.buildTree(A, B);
	}

	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	int N = -1;
	int postEnd = -1;

	public TreeNode buildTree(int[] A, int[] B) {
		N = A.length - 1;
		postEnd = N;
		for (int i = 0; i <= N; i++) {
			map.put(A[i], i);
		}
		return tree(A, B, 0, N);
	}

	TreeNode tree(int A[], int B[], int st, int en) {
		if (st > en) {
			return null;
		}
		int data = B[postEnd--];
		TreeNode root = new TreeNode(data);
		int index = map.get(data);
		
		root.right = tree(A, B, index + 1, en);
		root.left = tree(A, B, st, index - 1);

		return root;
	}

}
