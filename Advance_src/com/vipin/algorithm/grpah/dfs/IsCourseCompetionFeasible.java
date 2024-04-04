package com.vipin.algorithm.grpah.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsCourseCompetionFeasible {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1, 3, 4, 5};
		int B[] = {2, 1, 5, 3};
		IsCourseCompetionFeasible is = new IsCourseCompetionFeasible();
		System.out.println(is.solve(5, A, B));

	}
	
	Map<Integer, List<Integer>>adj = null;
	boolean vst[] = null;
    public int solve(int A, int[] B, int[] C) {
        adj = new HashMap<Integer, List<Integer>>();
        int N = B.length;
        for(int i=0; i<N; i++) {
            adj.computeIfAbsent(B[i], val->new ArrayList<Integer>()).add(C[i]);
        }
        vst = new boolean[A+1];
        for(int i=1; i<=A; i++) {
            if(!vst[i]) {
            	vst[i] = true;
                int []path = new int[A+1];
                if(!dfs(i, path)) {
                    return 0;
                }
            }
        }
        return 1;
    }
    boolean dfs(int node, int path[]) {
    	vst[node] = true;
        if(adj.get(node)!=null) {
            path[node] = 1;
            for(Integer neighbor : adj.get(node)) {
                if(!vst[neighbor] && !dfs(neighbor, path)) {
                    return false;
                } else if(path[neighbor]!=0) {
                    return false;
                }
            }
        }
        return true;
    }

}
