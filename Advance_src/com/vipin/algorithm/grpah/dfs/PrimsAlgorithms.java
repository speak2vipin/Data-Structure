package com.vipin.algorithm.grpah.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PrimsAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A = 4;
		int[][] B = { { 1, 2, 1 }, { 2, 3, 4 }, { 1, 4, 3 }, { 4, 3, 2 }, { 1, 3, 10 } };
		PrimsAlgorithms p = new PrimsAlgorithms();
		System.out.println(p.solve(A, B));

	}

	Map<Integer, ArrayList<int[]>> adj = null;

	public int solve(int A, int[][] B) {
		adj = new HashMap<Integer, ArrayList<int[]>>();

		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comparator<Edge>() {
			public int compare(Edge e1, Edge e2) {
				return e1.wt - e2.wt;
			}
		});

		boolean vst[] = new boolean[A + 1];
		pq.offer(new Edge(1, 0));
		for (int b[] : B) {
			adj.computeIfAbsent(b[0], val -> new ArrayList<int[]>()).add(new int[] { b[1], b[2] });
			adj.computeIfAbsent(b[1], val -> new ArrayList<int[]>()).add(new int[] { b[0], b[2] });
		}
		long cost = 0;
		while (!pq.isEmpty()) {
			Edge top = pq.poll();
			if (!vst[top.v]) {
				vst[top.v] = true;
				cost += top.wt;
				ArrayList<int[]> neighborWithCost = adj.get(top.v);
				for (int[] nodeAndCost : neighborWithCost) {
					pq.offer(new Edge(nodeAndCost[0], nodeAndCost[1]));
				}
			}
		}
		return (int) cost % 1000000007;
	}

	public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (x,y)->x[0]-y[0]);
        int N = tasks.length;
        int ans = 0;
        ArrayList<int[]>l = new ArrayList<int[]>();
        for(int i=0; i<N-1; i++) {
        	if(isOverlap(tasks[i], tasks[i+1])) {
        		l.add(tasks[i]);
        		int overlapDuration = tasks[i-1][1]-tasks[i][0];
        		if(overlapDuration>=tasks[i-1][2]) {
        			//ans += 
        		}
        	} else {
        		
        		
        	}
        }
        
        return 0;
        
        
        
    }

	boolean isOverlap(int x[], int y[]) {
		return Math.min(x[1], y[1]) - Math.max(x[0], y[0]) > 0;
	}
}

class Edge {
	int v;
	int wt;

	public Edge(int x, int wt) {
		this.v = x;
		this.wt = wt;
	}}

	