package com.vipin.algorithms.tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Node with the same level should comes together
 * for example [1], [2,3],[4,5,6,7]
 * @author vipingupta
 *
 */
public class TreeTraversalAtLevelWithBFSUsingQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode treeNode5 = new TreeNode(5, null, null);
		TreeNode treeNode2 = new TreeNode(2, null, treeNode5);
		TreeNode treeNode4 = new TreeNode(4, null, null);
		TreeNode treeNode3 = new TreeNode(3, null, treeNode4);
		
		TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
		levelOrder(treeNode1);
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> treeList = new ArrayList<List<Integer>>();
        Queue<TreeNode> treeQ = new LinkedList<TreeNode>();
        TreeNode temp = root;
        treeQ.add(temp);
        while(treeQ.size()!=0) {
            List<Integer> mList = new ArrayList<Integer>();
            Queue<TreeNode> treeQTemp = new LinkedList<TreeNode>();
                while(treeQ.size()!=0) {
                    temp = treeQ.poll();
                    mList.add(temp.val);
                    if(temp.left!=null) {
                        treeQTemp.add(temp.left);
                    } if(temp.right!=null) {
                        treeQTemp.add(temp.right);
                    }
                }
        	treeList.add(mList);
            treeQ = treeQTemp;
        }
       return treeList;   
        
    }
	
}

