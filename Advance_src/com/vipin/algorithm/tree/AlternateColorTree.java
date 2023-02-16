package com.vipin.algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AlternateColorTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]redEdges = {{0,1}, {0,2}};
		int [][]blueEdges = {{1,0}, {0,1}};
		AlternateColorTree a = new AlternateColorTree();
		a.shortestAlternatingPaths(3, redEdges, blueEdges);
	}
	

	    Map<Integer, ArrayList<Node>> map;
	    int dist[];
	    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges)     {
	        dist = new int[n];
	        Arrays.fill(dist, -1);
	        map = new HashMap<Integer, ArrayList<Node>>();
	        for(int edge[] : redEdges) {
	            map.computeIfAbsent(edge[0], val->new ArrayList<Node>()).add(new Node(edge[1], 'r'));
	        }
	        for(int edge[] : blueEdges) {
	            map.computeIfAbsent(edge[0], val->new ArrayList<Node>()).add(new Node(edge[1], 'b'));
	        }
	        dist[0] = 0;
	        dfs(0, '\u0000', 1);
	        return dist;
	        
	    }
	   
	    int dfs(int data, char color, int step) {
	        if(map.get(data)!=null) {
	            for(Node node : map.get(data)) {
	               if(node.data==data) {
	                   continue;
	               } else if(dist[node.data]!=-1 && dist[node.data]<step) {
	            	   continue;
	               }
	               if(node.color == color) {
	                   dist[node.data] = -1;
	               } else{
	                   dist[node.data] = step;
	                   dfs(node.data, node.color, step+1);
	               }
	            }
	        }
	        return -1;
	    }
}

class Node {
    int data;
    char color;
    Node(int data, char color) {
        this.data = data;
        this.color = color;
    }
}
