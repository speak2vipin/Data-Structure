package com.vipin.algorithm.grpah.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BatchesByStrength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int A = 10;
		int B[] = {7, 9, 3, 2, 9, 1, 6, 4, 10, 8 };
		int [][] C =
		{{1, 5},{2, 6},{3, 7},{3, 9},{3, 10},
		  {4, 5},{4, 7},{4, 10},{5, 7},{7, 9}};
		int D = 26;
		BatchesByStrength b= new BatchesByStrength();
		
		System.out.println(b.solve(A, B, C, D));

	}
	
	Map<Integer, List<Integer>> adj = null;
	long sum = 0;
    public int solve(int A, int[] B, int[][] C, int D) {
        adj = new HashMap<Integer, List<Integer>>();
        for(int[] edge : C) {
            adj.computeIfAbsent(edge[0], val->new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], val->new ArrayList<Integer>()).add(edge[0]);
        }
        boolean visit[] = new boolean[A+1];
        int count = 0;
        for(int i=1; i<=A; i++) {
            if(!visit[i]) {
            	sum = B[i-1];
                dfs(i, visit, B);
                if(sum>=D) {
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(int node, boolean visit[], int B[]) {
        visit[node] = true;
        List<Integer>neighbors = adj.get(node);
        if(neighbors != null) {
            for(int neighbor : neighbors) {
                if(!visit[neighbor]) {
                	sum = sum+B[neighbor-1];
                	System.out.println(node +" "+ neighbor + " " +sum);
                    dfs(neighbor, visit, B);
                }
            }
        }
        //return sum;
    }

}
