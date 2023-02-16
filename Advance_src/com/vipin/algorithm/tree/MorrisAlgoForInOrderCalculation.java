package com.vipin.algorithm.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MorrisAlgoForInOrderCalculation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t20 = new TreeNode(20);
		TreeNode t12 = new TreeNode(12);
		TreeNode t31 = new TreeNode(31);
		TreeNode t6 = new TreeNode(6);
		
		TreeNode t18 = new TreeNode(18);
		
		TreeNode t33 = new TreeNode(33);
		TreeNode t32 = new TreeNode(32);
		t20.left = t12;
		t20.right = t31;
		t12.left = t6;
		t12.right = t18;
		t31.left = t32;
		t31.right = t33;
		MorrisAlgoForInOrderCalculation c = new MorrisAlgoForInOrderCalculation();
		
		System.out.println(c.recoverTree(t20)[0] + " " +c.recoverTree(t20)[1]);
	}
	
	public int[] recoverTree(TreeNode A) {
        return traverse(A);
    }
	
    int[] traverse(TreeNode root) {
        int prev = Integer.MIN_VALUE;
        int start = -1;
        int ans[] = new int[2];
        ans[0] = Integer.MIN_VALUE;
        ans[1] = Integer.MIN_VALUE;
        // Morris algorithms for inorder calculation in SC O(1)
        while(root!=null) {
            if(root.left==null) {
                if(start==-1) {
                    prev = root.val;
                    start = 0;
                } else {
                    if(root.val>prev) {
                        prev = root.val;       
                    } else {
                        if(ans[0]==Integer.MIN_VALUE) {
                            ans[0] = prev;
                            ans[1] = root.val;
                        } else {
                            ans[1] = root.val;
                        }
                        prev = root.val;
                    }
                    
                }
                System.out.print(prev + " ");
                root= root.right;
            } else {
                // Calculate right most node in Left subtree
                TreeNode leftSubtreeRightMostNode = rightMostNode(root);
                if(leftSubtreeRightMostNode.right ==null) {
                    leftSubtreeRightMostNode.right = root;
                    root = root.left;
                } else {
                    leftSubtreeRightMostNode.right = null;
                    if(start==-1) {
                        prev = root.val;
                        start = 0;
                    } else {
                        if(root.val>prev) {
                            prev = root.val;
                        } else {
                            if(ans[0]==Integer.MIN_VALUE) {
                                ans[0] = prev;
                                ans[1] = root.val;
                            } else {
                                ans[1] = root.val;
                            }
                            prev = root.val;
                        }
                    }
                    System.out.print(prev + " ");
                    root = root.right;
                }
            }
            
        }
        System.out.println();
        return ans;
    }

    TreeNode rightMostNode(TreeNode curr) {
    	TreeNode temp = curr.left;
        while(temp.right != null && temp.right != curr) {
            temp = temp.right;
        }
        return temp;
    }
    
    
    public boolean validPath(int n, int[][] edges, int start, int end) {
        final boolean[] visited = new boolean[n];
        final Queue<Integer> bfsQueue = new LinkedList<Integer>();
        bfsQueue.add(start);
        visited[start] = true;
        while(!bfsQueue.isEmpty()) {
            final int currentVertex = bfsQueue.poll();
            if(currentVertex == end) {
                return true;
            }
            final Set<Integer> neighbors = findNeighbors(edges, n, currentVertex);
            for(final int neighbor : neighbors) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    bfsQueue.add(neighbor);
                }
            }
        }
        return false;
    }
    
    private static Set<Integer> findNeighbors(int[][] edges, int n, int v) {
        final Set<Integer> neighbors = new HashSet<Integer>();
        for(int[] edge : edges) {
            if(edge[0] == v) {
                neighbors.add(edge[1]);
            } else if(edge[1] == v) {
                neighbors.add(edge[0]);
            }
        }
        return neighbors;
    }


}
