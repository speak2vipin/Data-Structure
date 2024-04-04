package com.vipin.algorithms.tree;

import java.util.HashMap;
import java.util.Map;
/**
 * Trick in postorder last node will be root and second last would be the right node. So form Root 
 * and then create right node and create left node
 * @author vipingupta
 *
 */
public class MinePostorderAndInorderFormTree {

	public static void main(String[] args) {

		int[] inorder = { 9, 3, 15, 20, 7 };
		int[] postorder = { 9, 15, 7, 20, 3 };
		MinePostorderAndInorderFormTree m = new MinePostorderAndInorderFormTree();
		m.buildTree(postorder, inorder);
	}

	TreeNode root = null;
    Map<Integer, Integer> indexMap = null;
    int postorderIndex = -1;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        indexMap = new HashMap<>();
        int N = inorder.length;
        postorderIndex = N-1;
        for(int i=0; i<N; i++) {
            indexMap.put(inorder[i], i);
        }
        root = helper(0, N-1, postorder);
        return root;

    }
    
    TreeNode helper(int stInorder, int enInorder, int[] postorder) {
        TreeNode temp = null;
        if(stInorder<=enInorder) {
        	
            int val = postorder[postorderIndex--];
           
            temp = new TreeNode(val);
            int index = indexMap.get(val);
            temp.right = helper(index+1, enInorder, postorder);
            temp.left = helper(stInorder, index-1, postorder);
        }
        return temp;
        
    }
}
