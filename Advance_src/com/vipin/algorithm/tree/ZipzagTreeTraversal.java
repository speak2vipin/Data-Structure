package com.vipin.algorithm.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZipzagTreeTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<ArrayList<Integer>>();

        Queue<TreeNode>qe = new LinkedList<TreeNode>();
        qe.offer(A);
        int isReverse = 0;
        while(!qe.isEmpty()) {
            int size = qe.size();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i=0; i<size; i++) {
                TreeNode top = qe.poll();
                temp.add(top.val);
                if(top.left != null) {
                    qe.offer(top.left);
                }
                if(top.right != null) {
                    qe.offer(top.right);
                }
            }
            if(isReverse==1) {
                Collections.reverse(temp);
            }
            ansList.add(temp);
            isReverse = 1 ^ isReverse;
        }
        return ansList;
    }
}
