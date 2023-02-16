package com.vipin.algorithm.tree;

public class IsValidBstTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t4 = new TreeNode(4);
		TreeNode t2 = new TreeNode(2);
		TreeNode t5 = new TreeNode(5);
		TreeNode t1 = new TreeNode(1);
		
		TreeNode t51 = new TreeNode(5);

		t4.left = t2;
		t4.right = t5;
		t2.left = t1;
		t2.right = t51;
		
		Solution c = new Solution();
		System.out.println(c.isValidBST(t4));;

	}
}
	
	class Solution {
	    boolean isBSTFlag = true;
	    int val = Integer.MIN_VALUE;
	    public int isValidBST(TreeNode A) {
	        isBst(A);
	        return isBSTFlag ? 1 : 0;
	    }

	    void isBst(TreeNode root) {
	        if(root.left==null && root.right==null) {
	            if(root.val>val) {
	                val = root.val;
	                return;
	            } else {
	                isBSTFlag = false;
	                return;
	            }
	        }
	        isBst(root.left);
	        if(root.val>val) {
	            val = root.val;
	        } else {
	            isBSTFlag = false;
	            return;
	        }
	        isBst(root.right);
	    }
	

}
