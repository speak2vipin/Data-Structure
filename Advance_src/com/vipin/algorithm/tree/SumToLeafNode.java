package com.vipin.algorithm.tree;

public class SumToLeafNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(5);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(0);
		t2.left = t3;
		t2.right = t4;
		root.left=t2;
		root.right = t5;
		SumToLeafNode s = new SumToLeafNode();
		System.out.println(s.sumNumbers(root));
	}
	
	int sum = 0;
    public int sumNumbers(TreeNode root) {
        //helper(root, ""+root.val);
    	anotherHelper(root, root.val);
        return sum;
    }
    void helper(TreeNode root, String s) {
        if(root.left==null && root.right==null) {
        	sum += Integer.parseInt(s.toString());
            return;
        }
        if(root.left!=null)
        	helper(root.left, s+root.left.val);
        if(root.right!=null)
        	helper(root.right, s+root.right.val);     
    }
    
    void anotherHelper(TreeNode root, int temp) {
        if(root.left==null && root.right==null) {
        	sum += temp;
            return;
        }
        temp = temp*10;
        if(root.left!=null)
        	anotherHelper(root.left, temp+root.left.val);
        if(root.right!=null)
        	anotherHelper(root.right, temp+root.right.val);     
    }

}
