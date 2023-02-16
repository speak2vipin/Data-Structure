package com.vipin.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.xml.transform.Templates;

public class BFSOrLevelOrderTraversalImplementationUsingQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int[][] levelOrder(TreeNode A) {
		
	        List<List<Integer>> list = new ArrayList<List<Integer>>();
	        Queue<TreeNode>qe = new LinkedList<TreeNode>();
	        qe.add(A);
	        TreeNode temp = null;
	        while(!qe.isEmpty()) {
	        	int size = qe.size();
	        	int j = 0;
	        	List<Integer> tempList = new ArrayList<Integer>();
	
	        	while(j<size) {
	        		temp = qe.poll();
	        		tempList.add(temp.val);
	        		j++;
	        		if(temp.left!=null) {
	        			qe.add(temp.left);
	        		}
	        		if(temp.right!=null) {
	        			qe.add(temp.right);
	        		}
	        	}
	        	list.add(tempList);       	
	        }
	        
	        int k = list.size();
	        int ans[][] = new int[k][];
	        for(int i = 0; i<k; i++) {
	        	int size = list.get(i).size();
	        	int tempArray[] = new int[size];
	        	for(int j=0; j<size; j++) {
	        		tempArray[j] = list.get(i).get(j);
	        	}
	        	ans[i] = tempArray;
	        }
	        return ans;		        	
	    }
    

}
