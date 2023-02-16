package com.vipin.algorithm.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.*;

public class SimpleBFSimplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleBFSimplementation s = new SimpleBFSimplementation();
		int[]edges = {4,4,4,5,1,22};
		int node1 = 1, node2 = 1;
		System.out.println(s.closestMeetingNode(edges, node1, node2));
	}
	
	public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int dist1[] = new int[n];
        int dist2[] = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        
        bfs(node1, edges, dist1); 
        bfs(node2, edges, dist2);
        int ans = 0;
        int minDistance = Integer.MAX_VALUE;
        for(int i=0; i< n; i++) {
            if(dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE) {
                if(minDistance>dist2[i]) {
                    minDistance = dist2[i];
                    ans = i;
                }    
            }
        }
        return ans;
    }
    
    public void bfs(int st, int edge[], int dist[]) {
        Queue<Integer> qe = new LinkedList<Integer>();
        qe.offer(st);
        boolean visit[] = new boolean[edge.length];
        dist[st] = 0;
        visit[st] = true;
        while(!qe.isEmpty()) {
            int top = qe.poll();
            if(!visit[edge[top]] && edge[top]!=-1) {
                dist[edge[top]] = dist[top]+1;
                visit[edge[top]] = true;
                if(edge[edge[top]]!=-1) {
                    qe.offer(edge[top]);
                }
            }
        }
    }
    
    int ans = Integer.MAX_VALUE;
    Queue<int[]>qe = new LinkedList<int[]>();
    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        Map<Integer, ArrayList<int[]>> adj = new HashMap();
        for(int[] flight : flights) {
            adj.computeIfAbsent(flight[0], val->new ArrayList<int[]>()).add(new int[]{flight[1], flight[2]});
        }
        qe.offer(new int[]{src, 0});
        int ans = Integer.MAX_VALUE;
        while(!qe.isEmpty() && k-->-1) {
            int[] top = qe.poll();
            List<int[]> list = adj.get(top[0]);
            if(list!=null) {
                for(int []neighbor : list) {
                    if(neighbor[0]==dest) {
                        ans = Math.min(ans, neighbor[1]);
                    } else {
                        qe.offer(new int[] {neighbor[0], neighbor[1]+top[1]});
                    }
                }
            }
        }
        return ans;
    }

}
