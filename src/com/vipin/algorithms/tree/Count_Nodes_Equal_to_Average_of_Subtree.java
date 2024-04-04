package com.vipin.algorithms.tree;

public class Count_Nodes_Equal_to_Average_of_Subtree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		TreeNode root8 = new TreeNode(8);
		TreeNode root5 = new TreeNode(5);
		TreeNode root0 = new TreeNode(0);
		TreeNode root1 = new TreeNode(1);
		TreeNode root6 = new TreeNode(6);
		root.left = root8;
		root.right = root5;
		root8.left = root0;
		root8.right = root1;
		root5.right = root6;
		Count_Nodes_Equal_to_Average_of_Subtree c = new Count_Nodes_Equal_to_Average_of_Subtree();
		System.out.println(c.averageOfSubtree(root));
		
		int a[] = {1, 2, 3, 2};
		
		System.out.println(c.minDist(a, 4, 2, 1));
	}
	
	int count = 0;
    int ans = 0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return ans;
    }
    
    int helper(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int val = root.val;
        
        int leftVal = helper(root.left);
        int rightVal = helper(root.right);
        count++;
        int sum = val + leftVal + rightVal;
        int average = sum/count;
        if(average==val) {
            ans++;
        }
        return sum;
    }
    
    int minDist(int a[], int n, int x, int y) {
        // code here
        int xIndex = -1;
        int yIndex = -1;
        int ans = Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++) {
            if(a[i]==x) {
                xIndex = Math.max(i, xIndex);
            } else if(a[i]==y) {
                yIndex = Math.max(i, yIndex);
            }
            if(xIndex!=-1 && yIndex!=-1) {
                ans = Math.min(ans, Math.abs(xIndex-yIndex));
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }

}
