package com.vipin.algorithm.grpah.dfs;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class IsPathWithMinWeightExist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Map<Integer, HashSet<Neighbour>> adj = new HashMap<>();
	public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
		for(int[] edge : edgeList) {
			int source = edge[0];
			Neighbour neighbour = new Neighbour(edge[1], edge[2]);
			adj.computeIfAbsent(source, val->new HashSet<Neighbour>()).add(neighbour);
		}
		boolean 
		
	        
	}
	
	boolean dfs(int node, boolean visit[], int threshold) {
		visit[node] = true;
		if(adj.get(node)!=null) {
			for(Neighbour neighbour : adj.get(node)) {
				if(!visit[neighbour.point] && neighbour.weight<threshold) {
					dfs(neighbour.point, visit, neighbour.weight);
				}
			}
		}
		return false;
	}
	

}

class Neighbour {
	int point;
	int weight;
	
	public Neighbour(int point, int weight) {
		this.point = point;
		this.weight = weight;
	}

	@Override
	public boolean equals(Object obj) {
		Neighbour current = ((Neighbour) obj);
		return (this.point == current.point) && this.weight < current.weight;
	}
}

class Target {
	int point1;
	int point2;
	
	public Target(int point1, int point2) {
		this.point1 = point1;
		this.point2 = point2;
	}

	@Override
	public boolean equals(Object obj) {
		Target current = ((Target) obj);
		return (this.point1 == current.point1) && this.point2 == current.point2;
	}
}