package com.vipin.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

public class NextPointerBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void connect(TreeLinkNode A) {
		Queue<TreeLinkNode> q = new LinkedList();
		q.add(A);
		while (!q.isEmpty()) {
			TreeLinkNode prev = null;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeLinkNode tmp = q.poll();
				if (tmp.left != null) {
					q.add(tmp.left);
					if (prev != null) {
						prev.next = tmp.left;
					}
				}
				if (tmp.right != null) {
					q.add(tmp.right);
					tmp.left.next = tmp.right;
					if (i == size - 1) {
						tmp.right.next = null;
					} else {
						prev = tmp.right;
					}
				}

			}
		}
	}
	
	public void connectMy(TreeLinkNode root) {
        Queue<TreeLinkNode> qe = new LinkedList<TreeLinkNode>();
        qe.offer(root);
        while(!qe.isEmpty()) {
            int size = qe.size();
            TreeLinkNode temp = qe.poll();
            TreeLinkNode tempNext = null;
            for(int i=1; i<size; i++) {
                if(temp.left!=null) {
                    qe.offer(temp.left);
                }
                if(temp.right!=null) {
                    qe.offer(temp.right);
                }
                if(!qe.isEmpty()) {
                    tempNext = qe.poll();
                } 
                temp.next = tempNext;
                temp = tempNext;
                tempNext = null;
            }
            temp.next = null;
        }
    }

}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}
