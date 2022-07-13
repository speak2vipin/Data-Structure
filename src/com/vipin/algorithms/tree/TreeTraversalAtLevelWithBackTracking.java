package com.vipin.algorithms.tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * Node with the same level should comes together
 * for example [1], [2,3],[4,5,6,7]
 * @author vipingupta
 *
 */
public class TreeTraversalAtLevelWithBackTracking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		TreeNode treeNode5 = new TreeNode(5, null, null);
		TreeNode treeNode2 = new TreeNode(2, null, treeNode5);
		TreeNode treeNode4 = new TreeNode(4, null, null);
		TreeNode treeNode3 = new TreeNode(3, null, treeNode4);
		
		TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
		levelOrderNew(treeNode1);
	

	}
	
	public static List<List<Integer>> levelOrderNew(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }
    
    public static void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }

}
