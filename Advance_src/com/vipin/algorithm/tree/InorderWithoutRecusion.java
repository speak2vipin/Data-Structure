package com.vipin.algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderWithoutRecusion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] inorderTraversal(TreeNode A) {
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode temp = A;
		List<Integer> lt = new LinkedList<Integer>();
		while (!st.isEmpty() || temp != null) {
			if (temp != null) {
				st.push(temp);
				temp = temp.left;
			} else {
				temp = st.pop();
				lt.add(temp.val);
				// POINT TO REMEMBER
				// THIS BELOW LINE WILL HELP US IN TRAVERSING BACK TO PARENT NODE I.E. L N R
				temp = temp.right;
			}
		}
		int ans[] = new int[lt.size()];
		for(int i=0; i<lt.size(); i++) {
			ans[i] = lt.get(i);
		}
		return ans;
	}

}

class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;
	public TreeNode(int val) {
		super(); 
		this.val = val;
		this.left = null;
		this.right = null;
	}
	
	

}
