package com.vipin.algorithm.tree;

public class IsImbalancedTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 int isBalanced = 1;
	    public int isBalanced(TreeNode A) {
	        if(A==null) {
	           
	        }
	        helper(A);
	        
	        return isBalanced;

	    }

	    int helper(TreeNode root) {
	        if(root==null) {
	            return 0;
	        }
	        int leftHeight = 1 + helper(root.left);
	        int rightHeight = 1 + helper(root.right);
	        if(Math.abs(leftHeight-rightHeight)>1) {
	            isBalanced = 0;
	            return isBalanced;
	        }
	        return Math.max(leftHeight, rightHeight);
	    }

}
