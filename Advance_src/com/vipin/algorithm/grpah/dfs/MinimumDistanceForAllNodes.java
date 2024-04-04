package com.vipin.algorithm.grpah.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumDistanceForAllNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[][] = {{1,2,1},{2,3,2},{1,3,4}};
		int B = 1;
		int C = 3;
		System.out.println(solve(A, B, C));
	}
	
	public static int solve(int[][] A, int B, int C) {
        int res = 0;
        Map<Integer, ArrayList<int[]>> adj = new HashMap<>();
        PriorityQueue<int[]> pq = new  PriorityQueue<int[]>((a,b) -> a[1]-b[1]);
        for(int a[] : A) {
            adj.computeIfAbsent(a[0], val-> new ArrayList< int[]>()).add(new int[]{a[1], a[2], a[2]});
        }
        boolean visit[] = new boolean[C+1];
        if(adj.get(B)!=null) {
            for(int edge[] : adj.get(B)) {
                pq.offer(edge);
            }
            visit[B] = true;
            while(!pq.isEmpty()) {
                int top[] = pq.poll();
                if(!visit[top[0]]) {
                    res = res + top[2];
                    visit[top[0]] = true;
                    ArrayList<int[]> neighbors = adj.getOrDefault(top[0], new ArrayList<int[]>());
                    for(int edge[] : neighbors) {
                        if(!visit[edge[0]]) {
                            pq.offer(new int[]{edge[0], edge[1]+top[1], edge[2]});
                        }
                    }
                }
            }
        }
        for(int i=1; i<=C; i++) {
            if(!visit[i]) {
                return -1;
            }
        }
        return res;
        
    
    }

}
