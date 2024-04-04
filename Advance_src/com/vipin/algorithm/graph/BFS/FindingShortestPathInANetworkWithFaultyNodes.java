package com.vipin.algorithm.graph.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindingShortestPathInANetworkWithFaultyNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[][] = {{3,6,4},{4,6,14},{2,3,3},{3,7,15},{2,4,4},{2,6,5},
				{2,7,18},{1,4,11},{1,5,5},{6,7,2}
		};
		int B[] = {2,3,5};
		int C = 8;
		//System.out.println(solve(A, B, C));
		
		int dist[] = {5,3,4,6,2,2,7};
		double hour = 10.92;
		System.out.println(minSpeedOnTime(dist, hour));
	}
	
	static Map<Integer, ArrayList<int[]>> adj = null;
    public static int solve(int[][] A, int[] B, int C) {
adj = new HashMap<>();
        
        for(int a[] : A) {
            adj.computeIfAbsent(a[0], val->new ArrayList<int[]>()).add(new int[]{a[1], a[2]});
            adj.computeIfAbsent(a[1], val->new ArrayList<int[]>()).add(new int[]{a[0], a[2]});
        }
        boolean[] visit = new boolean[C+1];
        for(int b : B) {
            if(b!=1 || b!=C)
                visit[b] = true;
        }
        
       // if(visit[1] || visit[C]) {
         //   return -1;
        //}
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]> ((x,y)->x[1]-y[1]);
        ArrayList<int[]> oneNeighbors = adj.getOrDefault(1, new ArrayList<int[]>());
        for(int[] oneNeighbor : oneNeighbors) {
            pq.offer(new int[]{oneNeighbor[0], oneNeighbor[1]});
        }
        visit[1] = true;
        
        while(!pq.isEmpty()) {
            int size = pq.size();
            for(int i=0; i<size; i++) {
                int top[] = pq.poll();
                int u = top[0];
                int v = top[1];
                if(u==C) {
                    return v;
                }
                if(!visit[u]) {
                    visit[u] = true;
                    ArrayList<int[]> neighbors = adj.getOrDefault(u, new ArrayList<int[]>());
                    for(int[] neighbor : neighbors) {
                        if(!visit[neighbor[0]])
                            pq.offer(new int[]{neighbor[0], neighbor[1]+v});
                    }
                }
            }
        }
        return -1;
        
    }
    
    public static int minSpeedOnTime(int[] dist, double hour) {
    	System.out.println(Math.ceil(2.2));
    	System.out.println(Math.floor(2.4));
    	System.out.println(Math.floor(2.7));
        int n = dist.length;
        if(hour<n-1) {
            return -1;
        }
        int speed = 0;
        for(int i=n-1; i>-1; i--) {
            float temp = (float)(hour - i);
            int tempspeed = (int)Math.ceil(dist[i]/ temp);
            speed = Math.max(speed, tempspeed);
            hour = hour - temp;
        }
        return speed;
        
    }

}
