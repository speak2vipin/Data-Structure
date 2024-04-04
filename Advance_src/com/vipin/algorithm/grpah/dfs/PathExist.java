package com.vipin.algorithm.grpah.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PathExist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Map<Integer, ArrayList<Integer>>adj = null;
    public int solve(int A, int[][] B) {
        adj = new HashMap<Integer, ArrayList<Integer>>();
        boolean vst[] = new boolean[A+1];
        for(int edge[] : B) {
            adj.computeIfAbsent(edge[0], val->new ArrayList<Integer>()).add(edge[1]);
        }
        return dfs(1, vst, A) ? 1:0;

    }

    boolean dfs(int node, boolean vst[], int A) {
        vst[node] = true;
        ArrayList<Integer> neighbours = adj.get(node);
        if(node==A) {
            return true;
        }
        if(neighbours!=null) {
            for(int neighbour : neighbours) {
                if(!vst[neighbour] && dfs(neighbour, vst, A)) {
                    return true;
                }
            }

        }
        return false;
    }

}
