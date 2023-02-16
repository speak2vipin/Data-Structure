package com.vipin.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderToTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1, 2, 3, 4, 5, -1, -1, -1, -1, -1, 6, -1, -1 };
		solve(A);
	}
	
	public static TreeNode solve(int[] A) {

		int N = A.length;
        TreeNode root = new TreeNode(A[0]);
        Queue<TreeNode> qe = new LinkedList<TreeNode>();
        qe.add(root);
        int i=0;
        while(!qe.isEmpty()) {
            TreeNode node = qe.poll();
            if(A[i+1]!=-1) {
                TreeNode tempLeft = new TreeNode(A[i+1]);
                node.left = tempLeft;
                qe.add(tempLeft);
            }
            i++;

            if(A[i+1]!=-1) {
                TreeNode tempRight = new TreeNode(A[i+1]);
                node.right = tempRight;
                qe.add(tempRight);
            }
            i++;
        }
        return root;
 
    }

}
