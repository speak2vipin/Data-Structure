package com.vipin.algorithm.tree;

public class MergeBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
		TreeNode root3 = new TreeNode(3);
		TreeNode root2 = new TreeNode(2);
		TreeNode root5 = new TreeNode(5);
		root.left = root3;
		root.right = root2;
		root3.left = root5;
		mergeTrees(root, root);
		
		

	}
	
	public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root = null;
        if(root1!=null && root2!=null) {
             root = new TreeNode(root1.val+root2.val);
        } else if(root1==null && root2!=null) {
             root = new TreeNode(root2.val);
        } else if(root1!=null && root2==null) {
            root = new TreeNode(root1.val);
        } else {
            return null;
        }
        
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        
        return root;
        
    }

}
