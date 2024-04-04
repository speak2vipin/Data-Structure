package com.vipin.algorithm.grpah.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtraEdgesToMakeGraphConnected {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int edges[][] = {{0,1},{0,2},{1,2}};
		
		ExtraEdgesToMakeGraphConnected e = new ExtraEdgesToMakeGraphConnected();
		System.out.println(e.makeConnected(4, edges));

	}
	
	int extraEdges = 0;
    Map<Integer, ArrayList<Integer>> adj = null;
    boolean vst[] = null;
	public int makeConnected(int n, int[][] connections) {
        if(n-1<connections.length) {
            return -1;
        }
        adj = new HashMap<>();
        for(int edge[] : connections) {
            adj.computeIfAbsent(edge[0], val->new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], val->new ArrayList<Integer>()).add(edge[0]);
        }
        vst = new boolean[n];
        int edgeRequired = 0;
        for(int i=0; i<n; i++) {
            if(!vst[i]) {
                edgeRequired++;
                dfs(i);
            }
        }
        return edgeRequired-1;
    }
    
    void dfs(int node) {
        if(!vst[node]) {
            vst[node] = true;
            ArrayList<Integer> list = adj.getOrDefault(node, new ArrayList<>());
            for(Integer neighbour : list) {
            	dfs(neighbour);
            }
        }
    }
}
