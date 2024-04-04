package com.vipin.algorithms.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SumOfAllNodeEvenGrandParent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i[] = { 6, 1, 2, 3, 4, 5, 6 };
		System.out.println(topK(i, 6));
	}

	public int solve(TreeNode A) {
		Queue<Object[]> qe = new LinkedList<>();

		qe.offer(new Object[] { A, null });
		int sum = 0;
		while (!qe.isEmpty()) {
			int size = qe.size();
			for (int i = 0; i < size; i++) {
				Object top[] = qe.poll();
				TreeNode treeNode = (TreeNode) top[0];
				Integer parent = top[1] == null ? null : (Integer) top[1];
				if (treeNode.left != null) {
					if (parent != null && (parent % 2 == 0)) {
						sum += treeNode.left.val;
					}
					qe.offer(new Object[] { treeNode.left, treeNode.val });
				}
				if (treeNode.right != null) {
					if (parent != null && (parent % 2 == 0)) {
						sum += treeNode.right.val;
					}
					qe.offer(new Object[] { treeNode.right, treeNode.val });
				}
			}
		}
		return sum;
	}

	public static int[] topK(int[] nums, int k) {
		// Code here
		Map<Integer, Integer> count = new HashMap<>();
		for (int num : nums) {
			count.put(num, count.getOrDefault(num, 0) + 1);
		}
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x, y) -> y[1] == x[1] ? (y[0] - x[0]) : y[1] - x[1]);
		for (Integer key : count.keySet()) {
			pq.offer(new int[] { key, count.get(key) });
		}
		int ans[] = new int[k];
		for (int i = 0; i < k; i++) {
			ans[i] = pq.poll()[0];
		}
		return ans;
	}
	
	static List<Integer> matrixSum(int n, int m, int mat[][], int q, int queries[][])
    {
        // code here
        List<Integer> ans = new ArrayList<>();
        for(int query[] : queries) {
            ans.add(helper(mat, query));
        }
        return ans;
    }
    
    int helper(int mat[][], int query[]) {
        int sum = 0;
        int n = mat.length;
        int m = mat[0].length;
        int type = query[0];
        int dx1[][] = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int dx2[][] = {{-2,-2},{-2,-1},{-2,0},{-2,1},
                       {-2,2},{-1,2},{0,2},{1,2},
                       {2,2},{2,1},{2,0},{2,-1},
                       {2,-2},{1,-2},{0,-2},{-1,-2}};
        if(type==1) {
            for(int dx[] : dx1) {
                if(query[1]+dx[0]>-1 
                    && query[1]+dx[0]<n 
                    && query[2]+dx[1]>-1 
                    && query[2]+dx[1]<m) {
                        sum += mat[query[1]+dx[0]][query[2]+dx[1]];
                    }
            }
        } else if(type==2) {
            for(int dx[] : dx1) {
                if(query[1]+dx[0]>-1 
                    && query[1]+dx[0]<n 
                    && query[2]+dx[1]>-1 
                    && query[2]+dx[1]<m) {
                        sum += mat[query[1]+dx[0]][query[2]+dx[1]];
                    }
            }
        }
        return sum;
    }
    
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        float time[] = new float[n];
        for(int i=0; i<n; i++) {
            if(speed[i]==0) {
                return 0;
            }
            time[i] = (float)dist[i]/(float)speed[i];
            
        }
       Arrays.sort(time);
        int count = 0;
       for(int i=0; i<n; i++) {
           if(time[i]-i>0) {
               count++;
           } else {
               break;
           }
           
       }
        return count;
        
    }

}
