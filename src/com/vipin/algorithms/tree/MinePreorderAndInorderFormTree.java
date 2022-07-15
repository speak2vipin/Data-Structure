package com.vipin.algorithms.tree;

import java.util.HashMap;
import java.util.Map;
/**
 * Trick is in preorder first node will root and second node will left node/child
 * so look for the index of Root node and find whether it has any neighbor and on the basis of it
 * decide left or right node. 
 * @author vipingupta
 *
 */
public class MinePreorderAndInorderFormTree {
	static int preorderIndex;
    static Map<Integer, Integer> inorderIndexMap;
    
	public static void main(String[] args) {
		int []inorder = {9,3,15,20,7};
		int []preorder = {3,9,20,15,7};
		buildTreeNew(preorder, inorder);
	}
	
	static TreeNode buildTreeNew(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        boolean[] isVisisted = new boolean[preorder.length];
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, false, false, null, isVisisted, inorder);
    }
	
	private static TreeNode arrayToTree(int[] preorder, Boolean left, Boolean right, TreeNode treeNode, boolean []isVisited, int[]inorder) {
        // if there are no elements to construct the tree
       if(left==null && !right || right==null && !left) {
    	   return null;
       }
       int val = preorder[preorderIndex];
       TreeNode root = new TreeNode(val);
       int tempI = inorderIndexMap.get(val);
       isVisited[tempI] = true;
       Integer tempILeft = null;
       Integer tempIRight = null;
       if(tempI-1>-1) {
    	   tempILeft = inorderIndexMap.get(inorder[tempI-1]);
       }
       if(tempI+1<preorder.length) {
           tempIRight = inorderIndexMap.get(inorder[tempI+1]);
       }
       if(left && treeNode!=null) {
    	   treeNode.left = root;
       } else if(right && treeNode!=null) {
    	   treeNode.right = root;
       }
       if(tempILeft!=null && !isVisited[tempILeft]) {
    	   left = true;
    	   preorderIndex++;
       } else if(tempILeft==null || (tempILeft!=null && isVisited[tempILeft])) {
    	   left = null;
       }
       root.left = arrayToTree(preorder, left, false, root,isVisited, inorder);
       if(tempIRight!=null && !isVisited[tempIRight]) {
    	   right = true;
    	   preorderIndex++;
       } else if(tempIRight==null || (tempIRight!=null && isVisited[tempIRight])) {
    	   right = null;
       }
       
       root.right = arrayToTree(preorder, false, right, root,isVisited, inorder);
       return root;
       
    }
    

}
