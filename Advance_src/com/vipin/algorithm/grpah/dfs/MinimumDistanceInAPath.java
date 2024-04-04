package com.vipin.algorithm.grpah.dfs;

import java.util.HashMap;
import java.util.PriorityQueue;

public class MinimumDistanceInAPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[][] = {{0,0},{2,2},{3,10},{5,2},{7,0}};
		System.out.println(minCostConnectPoints(A));
		System.out.println(minCostConnectPoints1(A));
	}
	
	public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((A,B)->A[2]-B[2]);
        int dist = 0;
        boolean visit[] = new boolean[n];
        visit[0] = true;
        for(int j=0; j<n; j++) {
            dist = Math.abs(points[0][0] - points[j][0]) + 
                    Math.abs(points[0][1] - points[j][1]);
            pq.offer(new int[]{0, j, dist});
        }    
        
        int total = 0;
        
        while(!pq.isEmpty()) {
            int top[] = pq.poll();
            int source = top[0];
            int target = top[1];
            dist = top[2];
            if(!visit[target]) {
            	total += dist;
                visit[target] = true;
                for(int j=0; j<n; j++) {
                    int newDist = Math.abs(points[target][0] - points[j][0]) + 
                        Math.abs(points[target][1] - points[j][1]);
                    
                    pq.offer(new int[]{target, j, newDist});
                } 
            }
        }
        return total;
    }
	
	public static int minCostConnectPoints1(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((A,B)->A[1]-B[1]);
        
        boolean visit[] = new boolean[n];
        HashMap<Integer, Integer> distanceMap = new HashMap<>();
        int total = 0;
        pq.offer(new int[]{0, 0});
        
        while(!pq.isEmpty()) {
            int top[] = pq.poll();
            int u = top[0];
            int w = top[1];
      
            if(!visit[u]) {
            	total += w;
                visit[u] = true;
                for(int j=0; j<n; j++) {
                    int newDist = Math.abs(points[u][0] - points[j][0]) + Math.abs(points[u][1] - points[j][1]);
                    if(!visit[j] && distanceMap.getOrDefault(j, Integer.MAX_VALUE)>=newDist) {
                        pq.offer(new int[]{j, newDist});
                        distanceMap.put(j, newDist);
                    }
                }
            }
        }
        return total;
    }

}
