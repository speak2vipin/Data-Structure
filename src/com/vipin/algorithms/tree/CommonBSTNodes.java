package com.vipin.algorithms.tree;

import java.util.HashSet;
import java.util.Set;

public class CommonBSTNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Set<Integer> set = null;
    int sum=0;
    public int solve(TreeNode A, TreeNode B) {
        set = new HashSet<>();
        traverse(A);
        sumTraverse(B);
        return sum;
    }

    void traverse(TreeNode node) {
        if(node==null) {
            return;
        }
        set.add(node.val);
        traverse(node.left);
        traverse(node.right);
    }
    void sumTraverse(TreeNode node) {
        if(node==null) {
            return;
        }
        int val = node.val;
        if(set.contains(val)) {
            sum += val;
        }
        sumTraverse(node.left);
        sumTraverse(node.right);
    }

}
