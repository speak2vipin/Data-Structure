package com.vipin.algorithm.graph.BFS;

import java.util.HashMap;
import java.util.Map;

public class DisjointSetUnionParentMarixWithParentShuffle {
	//static int parent[] = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int parent[]  = {0,1,1,2,3,4};
		DisjointSetUnionParentMarixWithParentShuffle d = new DisjointSetUnionParentMarixWithParentShuffle();
		//System.out.println(d.root(5, parent));
		int A = 14;
		int []B = { 7, 5, 7, 3, 9, 4, 4, 6, 3, 1, 4, 8, 7, 6 };
		int [][]C = {{1, 2},
				  {2, 6},
						  {2, 7},
						  {4, 13},
						  {5, 8},
						  {5, 13},
						  {6, 12},
						  {7, 10},
						  {10, 14},
						  {13, 14}};
		int D = 2;
		System.out.println(d.solve(A, B, C, D));

	}
	
	int parent[] = null;
    public int solve(int A, int[] B, int[][] C, int D) {
        int N = B.length;
        parent = new int[N+1];
        for(int i=1; i<=A; i++) {
            parent[i] = i;
        }
        for(int[] edge : C) {
            parent[edge[1]] = edge[0];
        }
        for(int i=1; i<=N; i++) {
            if(i!=parent[i]) {
                root(i, parent);
            }
        }
        Map<Integer,Integer>weight = new HashMap<>();
        for(int i=1; i<=N; i++) {
        	weight.put(parent[i], weight.getOrDefault(parent[i],0)+B[i-1]);
        }
        int count = 0;
        for(int value : weight.values()) {
            if(value>=D) {
            	count++;
            }
        }
        return count;
    }

    void union(int x, int y) {
        int p1 = root(x, parent);
        int p2 = root(y, parent);
        if(p1==p2) {
            return;
        }
        parent[x] = y;
    }
    /*
    int root(int i, int parent[]) {
        if(i==parent[i]) {
            return i;
        }
        int index = root(parent[i], parent);
        parent[i] = index;
        return index;
    }*/
    int root(int i, int parent[]) {
        if(i==parent[i]) {
            return i;
        }
        int index = root(parent[i], parent);
        parent[i] = index;
        return index;
    }

}
