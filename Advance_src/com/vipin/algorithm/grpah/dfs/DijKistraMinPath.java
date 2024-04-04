package com.vipin.algorithm.grpah.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.*;

public class DijKistraMinPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start[] = { 1, 1 };
		int target[] = {8, 3 };
		
		int specialRoads[][] = { { 2,3,8,2,3},{1,1,7,3,3 } };

		DijKistraMinPath d = new DijKistraMinPath();
		System.out.println(d.minimumCost(start, target, specialRoads));

	}

	public int minimumCost(int[] start, int[] target, int[][] specialRoads) {

		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
		PriorityQueue<int[]> minCost = new PriorityQueue<int[]>(new Comparator<int[]>() {
			public int compare(int x[], int y[]) {
				return x[2] - y[2];
			}
		});

		int x1 = start[0];
		int y1 = start[1];
		int tx = target[0];
		int ty = target[1];
		int cost = 0;
		minCost.offer(new int[] { x1, y1, 0 });
		while (!minCost.isEmpty()) {
			int top[] = minCost.poll();
			x1 = top[0];
			y1 = top[1];
			cost = top[2];
			if (map.get(x1) != null && map.get(x1).contains(y1)) {
				continue;
			}
			if (map.get(x1) == null) {
				map.put(x1, new HashSet<Integer>());
			}
			map.get(x1).add(y1);
			if (x1 == tx && y1 == ty) {
				return cost;
			}
			minCost.offer(new int[] { tx, ty, cost + (Math.abs(tx - x1) + Math.abs(ty - y1)) });
			for (int[] road : specialRoads) {
				int x_1 = road[0];
				int y_1 = road[1];
				int x_2 = road[2];
				int y_2 = road[3];
				int cost_1 = road[4];
				if (map.get(x_2) != null && map.get(x_2).contains(y_2)) {
					continue;
				}
				minCost.offer(new int[] { x_2, y_2, (cost + cost_1 + Math.abs(x1 - x_1) + Math.abs(y1 - y_1)) });
			}
		}
		return -1;
	}
	
	public int solve(int[] A) {
        Arrays.sort(A);
        Map<Integer, Integer> indexMap = new HashMap<>();
        int N = A.length;
        for(int i=0; i<N; i++) {
            indexMap.put(A[i], i);
        }

        // Contribution technique
        long mod = 1000000007;
        long sum = 0;
        for(int i=0; i<N; i++) {
            int greatIndex = indexMap.get(A[i]);
            int lesserIndex = N - 1 - greatIndex;
            sum = (sum + (A[i]*(2<<greatIndex - 2<<lesserIndex))%mod)%mod;
        }
        return (int)(sum%mod);
    }

}
