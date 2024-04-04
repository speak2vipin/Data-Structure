package com.vipin.algorithms.tree;

public class MAximumEdgesBetweenTwoNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
		TreeNode root1 = new TreeNode(11);
		TreeNode root2 = new TreeNode(12);
		TreeNode root3 = new TreeNode(13);
		TreeNode root4 = new TreeNode(14);
		TreeNode root5 = new TreeNode(15);
		TreeNode root6 = new TreeNode(16);
		root.left = root1;
		root.right = root2;
		root1.left = root3;
		root1.right = root4;
		root2.left = root5;
		root2.right = root6;
		root6.right = new TreeNode(100);

		MAximumEdgesBetweenTwoNodes t = new MAximumEdgesBetweenTwoNodes();
		System.out.println(t.solve(root, 12, 100));

	}

	public int solve(TreeNode A, int B, int C) {
		return Math.abs(position(A, B, 0) - position(A, C, 0));
	}

	int position(TreeNode node, int target, int pos) {
		int value = -1;
		if (node.val == target) {
			return pos;
		}
		if (node.val > target) {
			value = position(node.left, target, ++pos);
		} else {
			value = position(node.right, target, ++pos);
		}
		return value;
	}

	public class Solution {
		public int solve(TreeNode A, int B, int C) {
			TreeNode root = findLCA(A, B, C);
			return findDis(root, B) + findDis(root, C);
		}

		TreeNode findLCA(TreeNode node, int B, int C) {
			TreeNode temp = node;
			while (temp != null) {

				if (B > temp.val && C > temp.val) {
					temp = temp.right;
				} else if (B < temp.val && C < temp.val) {
					temp = temp.left;
				} else {
					break;
				}
			}

			return temp;
		}

		public int findDis(TreeNode node, int key) {
			int count = 0;
			while (node != null) {

				if (node.val == key) {
					return count;
				} else if (key < node.val) {
					node = node.left;
				} else {
					node = node.right;
				}
				count++;
			}
			return count;
		}
		
		public int solve1(TreeNode A, int B, int C) {
	        TreeNode lca = LCA(A, B, C);
            return distance(A, B, 0) + distance(A, C, 0);
	    }

	    TreeNode LCA(TreeNode root, int B, int C) {
            TreeNode temp = root;
            if(root.val> B && root.val>C) {
                temp = LCA(root.left, B, C);
            } else if(root.val< B && root.val<C) {
                temp = LCA(root.right, B, C);
            }
            return temp;
        }

        int distance(TreeNode root, int target, int pos) {
		    int value = -1;
		    if (root.val == target) {
			    return pos;
		    }
		    if (root.val > target) {
			    value = distance(root.left, target, ++pos);
		    } else {
			    value = position(root.right, target, ++pos);
		    }
		    return value;
        }
	}

}
