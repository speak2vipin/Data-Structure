package com.vipin.algorithms.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class LowestCommonDescendent<V> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// root = [3,5,1,6,2,0,8,null,null,7,4],

		TreeNode right8 = new TreeNode(8);
		TreeNode left0 = new TreeNode(0);
		TreeNode left6 = new TreeNode(6);
		TreeNode left4 = new TreeNode(4);
		TreeNode left7 = new TreeNode(7);
		TreeNode right2 = new TreeNode(2, left4, left7);
		TreeNode left1 = new TreeNode(1, left0, right8);
		TreeNode right5 = new TreeNode(5, left6, right2);
		TreeNode root = new TreeNode(3, left1, right5);
		TreeNode p = new TreeNode(3);
		TreeNode q = new TreeNode(5);
		lowestCommonAncestor(root, p, q);

	}

	static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		/*Map<Integer, List<Integer>> rootMap = new HashMap<Integer, List<Integer>>();
		Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
		List<Integer> visitedNode = new ArrayList<Integer>();
		TreeNode temp = null;
		Integer pVal = null;
		Integer qVal = null;
		Integer rootVal = root.val;
		nodeQ.offer(root);
		while (!nodeQ.isEmpty() && nodeQ.size() != 0) {
			List<Integer> nodeList = new ArrayList<Integer>();
			temp = nodeQ.poll();
//			nodeList.add(temp.val);
			if (temp.right != null) {
				nodeQ.offer(temp.right);
				nodeList.add(temp.right.val);
				if (temp.right.val == p.val && pVal == null) {
					pVal = temp.val;
				}
				if (temp.right.val == q.val && pVal == null) {
					pVal = temp.val;
				}
			}
			if (temp.left != null) {
				nodeQ.offer(temp.left);
				nodeList.add(temp.left.val);
				if (temp.left.val == p.val && qVal == null) {
					qVal = temp.val;
				}
				if (temp.left.val == q.val && qVal == null) {
					qVal = temp.val;
				}
			}
			rootMap.put(temp.val, nodeList);
		}
		visitedNode.add(pVal);
		visitedNode.add(qVal);
		if(p.val==rootVal) {
			return new TreeNode(rootVal);
		}
		visitedNode.add(p.val);
		if(q.val==rootVal) {
			return new TreeNode(rootVal);
		}
		visitedNode.add(q.val);
		if (pVal == qVal) {
			return new TreeNode(qVal);
		}
		while (true) {
			pVal = returnNode(rootMap, pVal);
			if (pVal != -1) {
				if (visitedNode.contains(pVal)) {
					return new TreeNode(pVal);
				} else {
					visitedNode.add(pVal);
				}
			}
			qVal = returnNode(rootMap, qVal);
			if (qVal != -1) {
				if (visitedNode.contains(qVal)) {
					return new TreeNode(qVal);
				} else {
					visitedNode.add(qVal);
				}
			}
			if (qVal == -1 && pVal == -1) {
				return new TreeNode(rootVal);
			}
		}
	}

	static int returnNode(Map<Integer, List<Integer>> nodeMap, int param) {
		for (Map.Entry<Integer, List<Integer>> entry : nodeMap.entrySet()) {
			if (entry.getValue().contains(param)) {
				return entry.getKey();
			}
		}
		return -1;
	}
	*/
		
	
	        if(root == null || root == p || root == q)  
	        	return root;
	        TreeNode left = lowestCommonAncestor(root.left, p, q);
	        TreeNode right = lowestCommonAncestor(root.right, p, q);
	        if(left != null && right != null)   return root;
	        return left != null ? left : right;
	    }

}
