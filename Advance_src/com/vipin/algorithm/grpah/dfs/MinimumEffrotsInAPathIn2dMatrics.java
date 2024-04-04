package com.vipin.algorithm.grpah.dfs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumEffrotsInAPathIn2dMatrics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int heights[][] = { { 1,2,2},{3,8,2},{5,3,5}};
		MinimumEffrotsInAPathIn2dMatrics m = new MinimumEffrotsInAPathIn2dMatrics();
		System.out.println(m.minimumEffortPath(heights));
	}

	 int directions[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int finalEfforts = Integer.MAX_VALUE;

		public int minimumEffortPath(int[][] heights) {
		    PriorityQueue<int[]>pq = new PriorityQueue<>((x,y)->x[0]-y[0]);
	        pq.offer(new int[]{0,0,0});
	        int m = heights.length;
	        int n = heights[0].length;
	        int dist[][] = new int[m][n];
	        for(int d[] : dist) {
	            Arrays.fill(d, Integer.MAX_VALUE);
	        }
	        dist[0][0] = 0;
	        while(!pq.isEmpty()) {
	            int top[] = pq.poll();
	            int effort = top[0];
	            int i = top[1];
	            int j = top[2];
	            if(effort>dist[i][j]) {
	            	continue;
	            }
	            if(i==m-1 && j==n-1) {
	                return effort;
	            }
	            
	            for(int direction[] : directions) {
	                int newI = i + direction[0];
	                int newJ = j + direction[1];
	                if(newI>-1 && newJ>-1 && newI<m && newJ<n) {
	                    int newEfforts = Math.max(effort, Math.abs(heights[i][j] - heights[newI][newJ]));
	                    if(dist[newI][newJ]>newEfforts) {
	                    	dist[newI][newJ] = newEfforts;
	                        pq.offer(new int[]{newEfforts, newI, newJ});
	                    }
	                }
	            }
	        }
	        return -1;
		}
}
