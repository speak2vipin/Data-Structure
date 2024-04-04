package com.vipin.algorithm.tree;

public class InvertTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(9);
		TreeNode root8 = new TreeNode(8);
		TreeNode root5 = new TreeNode(5);
		TreeNode root9 = new TreeNode(9);
		TreeNode root10 = new TreeNode(10);
		TreeNode root11 = new TreeNode(10);
		root8.left = root9;
		root8.right = root10;
		root5.left = root11;
		root.left = root8;
		root.right = root5;
		System.out.println(solve(root));
		
		String s = "bmblo";
		int B[] = {2,0,1,4,3};
		System.out.println(solve(s, B));
	}
	
	public static TreeNode solve(TreeNode A) {
        return invert(A);
    }
    
    static TreeNode invert(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) {
            return root;
        }
        TreeNode newLeft = invert(root.right);
        TreeNode newRight = invert(root.left);
        root.left = newLeft;
        root.right = newRight;
        return root;
    }
    
    public static String solve(String A, int[] B) {
        int N = A.length();
        char a[] = A.toCharArray();
        for(int i=0; i<N; i++) {
            if(i!=B[i]) {
                int j = i;
                char temp = a[i];
                while(j!=B[j]) {
                	temp = a[B[j]];
                   a[B[j]] = a[j];
                   int tempJ = B[B[j]];
                   B[B[j]] = B[j];
                   a[j] = temp;
                   B[j] = tempJ;
                   j = tempJ;          
                }
            }
        }
        return new String(a);
    }

}
