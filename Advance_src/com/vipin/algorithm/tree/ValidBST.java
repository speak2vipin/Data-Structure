package com.vipin.algorithm.tree;

public class ValidBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t20 = new TreeNode(20);
		TreeNode t12 = new TreeNode(12);
		TreeNode t34 = new TreeNode(34);
		TreeNode t6 = new TreeNode(6);
		
		TreeNode t18 = new TreeNode(18);
		
		TreeNode t30 = new TreeNode(30);
		TreeNode t21 = new TreeNode(21);
		t20.left = t12;
		t20.right = t34;
		t12.left = t6;
		t12.right = t18;
		t34.left = t30;
		t34.right = t21;

		ValidBST v = new ValidBST();
		System.out.println(v.traverseTree(t20).size);

	}

	public int solve(TreeNode A) {
		int size = traverseTree(A).size;
		return size;
	}

	PairNew traverseTree(TreeNode root) {
		if (root == null) {
			return new PairNew(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
		}
		PairNew L = traverseTree(root.left);
		PairNew R = traverseTree(root.right);

		boolean flag = L.isBST && R.isBST && L.max < root.val && R.min > root.val;
		int size = 0;
		if (flag) {
			size = L.size + R.size + 1;
		} else {
			size = Math.max(L.size, R.size);
		}

		return new PairNew(Math.max(root.val, Math.max(L.max, R.max)), Math.min(root.val, Math.min(L.min, R.min)), size,
				flag);
	}
}

class PairNew {
	int max;
	int min;
	int size;
	boolean isBST;

	public PairNew(int max, int min, int size, boolean isBST) {
		this.max = max;
		this.min = min;
		this.size = size;
		this.isBST = isBST;
	}
}
