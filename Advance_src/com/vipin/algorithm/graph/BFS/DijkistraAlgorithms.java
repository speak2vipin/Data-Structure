package com.vipin.algorithm.graph.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;

public class DijkistraAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A = 6;
		int B[][] = {{0, 4, 9},
				        {3, 4, 6}, 
				        {1, 2, 1}, 
				        {2, 5, 1}, 
				        {2, 4, 5}, 
				        {0, 3, 7},
				        {0, 1, 1},
				        {4, 5, 7},
				        {0, 5, 1}}; 
				int C = 4;
				DijkistraAlgorithms d = new DijkistraAlgorithms();
				System.out.println(d.solve(A, B, C));

	}

	public int[] solve(int A, int[][] B, int C) {
		Map<Integer, ArrayList<int[]>> adj = new HashMap<>();
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			public int compare(int x[], int y[]) {
				return x[1] - y[1];
			}
		});
		for (int temp[] : B) {
			adj.computeIfAbsent(temp[0], val -> new ArrayList<int[]>()).add(new int[] { temp[1], temp[2] });
			adj.computeIfAbsent(temp[1], val -> new ArrayList<int[]>()).add(new int[] { temp[0], temp[2] });
		}
		int res[] = new int[A];
		Arrays.fill(res, -1);
		res[C] = 0;
		enqueueNeighbors(adj, pq, C, 0);
		while (!pq.isEmpty()) {
			int top[] = pq.poll();
			if (res[top[0]] == -1) {
				res[top[0]] = top[1];
				enqueueNeighbors(adj, pq, top[0], top[1]);
			}
		}
		return res;
	}

	void enqueueNeighbors(Map<Integer, ArrayList<int[]>> adj, PriorityQueue<int[]> pq, int C, int dist) {
		ArrayList<int[]> edges = adj.getOrDefault(C, new ArrayList<>());

		for (int i = 0; i < edges.size(); i++) {
			int edge[] = edges.get(i);
			pq.offer(new int[] { edge[0], edge[1] + dist });
		}
	}
	
	public int solve(int A, int[][] B, int C, int D) {
        int[] d = new int[A+1];
        Arrays.fill(d, (int)1e9);
        d[C] = 0;

        for(int k=1; k<A; k++){
            boolean stop = true;
            for(int i=0; i<B.length; i++){
                int u = B[i][0];
                int v = B[i][1];
                int w = B[i][2];

                if((d[u] != (int)1e9) && (d[v] > d[u] + w)){
                    d[v] = d[u] + w;
                    stop = false;
                }  
            }

            if(stop){  
                break;  
            }  
        }

        //loop to check -ve cycle
        for(int i=0; i<B.length; i++){
            int u = B[i][0];
            int v = B[i][1];
            int w = B[i][2];

            if((d[u] != (int)1e9) && (d[u] + w < d[v])){
                return (int)1e9;
            }
        }
        return d[D];        
    }

}
