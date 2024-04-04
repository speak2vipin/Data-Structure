package com.vipin.algorithm.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class IsSymemetric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node5 = new TreeNode(5);
		TreeNode node4 = new TreeNode(4);
		node4.right = node5;
		TreeNode node3 = new TreeNode(3);
		node3.left = node4;
		TreeNode node2 = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		node1.left = node2;
		node1.right = node3;
		IsSymemetric i = new IsSymemetric();
		System.out.println(i.isSymmetric(node1));
		StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        s1.equals(s2);

	}

	public int isSymmetric(TreeNode A) {
        return helper(A) ? 1 : 0;
    }
    boolean helper(TreeNode A) {
        Deque<TreeNode> qe = new ArrayDeque<>();
        if(A.left!=null) {
            qe.offer(A.left);
        } else {
            qe.offer(new TreeNode(100001));
        }
        if(A.right!=null) {
            qe.offer(A.right);
        } else {
            qe.offer(new TreeNode(100001));
        }
        Stack<TreeNode> st = new Stack<>();
        while(!qe.isEmpty()) {
            int size = qe.size();
            int count = 0;
            while(count<size) {
                TreeNode front = qe.pollFirst();
                count++;
                if(qe.isEmpty()) {
                    return false;
                }
                TreeNode last = qe.pollLast();
                count++;
                if(front.val!=last.val) {
                    return false;
                }
                if(front.val!=100001) {
                    if(front.left!=null) {
                        qe.offer(front.left);
                    }  else {
                        qe.offer(new TreeNode(100001));
                    }
                    if(front.right!=null) {
                        qe.offer(front.right);
                    }  else {
                        qe.offer(new TreeNode(100001));
                    }
                }
                if(last.val!=100001) {
                    if(last.right!=null) {
                        st.push(last.right);
                    }  else {
                        st.push(new TreeNode(100001));
                    }
                    if(last.left!=null) {
                        st.push(last.left);
                    }  else {
                        st.push(new TreeNode(100001));
                    }
                }
            }
            while(!st.isEmpty()) {
                qe.offer(st.pop());
            }
        }
        return true;
    }

}
