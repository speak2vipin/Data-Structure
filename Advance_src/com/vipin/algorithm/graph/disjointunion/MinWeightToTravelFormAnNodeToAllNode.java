package com.vipin.algorithm.graph.disjointunion;

import java.util.PriorityQueue;

public class MinWeightToTravelFormAnNodeToAllNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Edge {
        int from; int to; int weight;
        Edge(int from, int to, int weight) {
            this.from = from; this.to = to; this.weight = weight;
        }
    }
    int getParent(int[] parent, int vertex) {
        if (parent[vertex] == vertex)
            return vertex;

        parent[vertex] = getParent(parent, parent[vertex]); // compress path to parent

        return parent[vertex];
    }

    void union(int[] parent, int u, int v) {
        u = getParent(parent, u);
        v = getParent(parent, v);

        if (u == v)
            return;

        parent[u] = v;
    }

    // find max weight edge in MST using kruskal’s algorithm
    int maxWeightEdge(int rows, int cols, int[][] weight) {
        PriorityQueue<Edge> minHeap = new PriorityQueue<Edge>( (a, b) → (a.weight - b.weight));
        int[][] direction = { {0, 1}, {1, 0}}; // we can move to right and down; up and left are covered by parent cell
        final int totalCells = rows cols;

        for(int i = 0; i < weight.length; i++) {
            for(int j = 0; j < weight[0].length; j++) {
                for(int[] xy : direction) { // process adjacent cells
                    int newi = i + xy[0];
                    int newj = j + xy[1];

                    if (newi < rows && newj < cols) { // 
                        minHeap.add(new Edge(icols + j, newi*cols + newj,
                            Math.abs(weight[i][j] - weight[newi][newj]))); // diff between the cells in the weight (K)
                    }
                }
            }
        }

        int[] parent = new int[totalCells + 1];
        for(int i = 0; i < parent.length; i++)
            parent[i] = i;

        int maxWeight = 0;
        int edgesRequired = totalCells - 1; // we need V -1 edges for MST
        while (edgesRequired > 0) {
            Edge edge = minHeap.poll();
            if (getParent(parent, edge.to) != getParent(parent, edge.from)) {
                union(parent, edge.from, edge.to);
                maxWeight = edge.weight; // note that recent selected edge will have max weight
                edgesRequired–;
            }
        }
        return maxWeight;
    }

    public int solve(int A, int B, int[][] C) {
        return maxWeightEdge(A, B, C);
    }
    
    public class Solution {
        public int solve(int A, int B, int C) {
        	 // A -> n
            // B -> r
            // C -> p
        	//n!/((n-r)!*r!)%p
        	
           long nfact=factorial(A,C);
           long nrfact=factorial(A-B,C);
           long rfact=factorial(B,C);
           long nrpow=powFunction(nrfact,C-2,C);
           long rpow=powFunction(rfact,C-2,C);
           long ans=(((nfact%C)*(nrpow%C))%C*(rpow%C))%C;
           return (int)ans;
        }
        private int factorial(long n,long m){
            long product=1;
            for(int i=2;i<=n;i++) product=(product*i%m)%m;
            return (int)product;

        }
        private int powFunction(long a,long n,long m){
            if(n==0) return 1;
            long he=powFunction(a,n/2,m)%m;
            long ha=(he*he)%m;
            if(n%2==0){
                return (int)ha;
            }else{
                return (int)((a*ha)%m);
            }
        }
    }
}
