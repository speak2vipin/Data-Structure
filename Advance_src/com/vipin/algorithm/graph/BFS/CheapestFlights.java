package com.vipin.algorithm.graph.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CheapestFlights {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int flights[][] = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
		CheapestFlights s= new CheapestFlights();
		System.out.println(s.findCheapestPrice(4, flights, 0, 3, 1));
		
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
        boolean visit[] = new boolean[n];
		while (!qe.isEmpty() && k-- > -1) {
			for (int i = 0; i < qe.size(); i++) {
				int[] top = qe.poll();
				visit[top[0]] = true;
				List<int[]> list = adj.get(top[0]);
				if (list != null) {
					for (int[] neighbor : list) {
						if (neighbor[0] == dest) {
							ans = Math.min(ans, neighbor[1] + top[1]);
						} else {
							if(!visit[neighbor[0]])
								qe.offer(new int[] { neighbor[0], neighbor[1] + top[1] });
						}
					}
				}
			}
		}
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}
