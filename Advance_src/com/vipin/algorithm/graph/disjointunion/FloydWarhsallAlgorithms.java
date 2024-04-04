package com.vipin.algorithm.graph.disjointunion;

import java.util.Arrays;

public class FloydWarhsallAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A = 4;
		int B = 6;
		int C = 2;
		int D[] = { 1, 2, 3, 2, 4, 3 };
		int E[] = { 2, 3, 4, 4, 1, 1 };
		int F[] = { 4, 1, 1, 1, 1, 1 };
		int G[] = { 1, 1 };
		int H[] = { 2, 3 };
		int res[] = solve(A, B, C, D, E, F, G, H);
		for (int t : res)
			System.out.println(t);

	}

	public static int[] solve(int A, int B, int C, int[] D, int[] E, int[] F, int[] G, int[] H) {
		int adj[][] = new int[A + 1][A + 1];
		for (int i=0; i<A+1; i++) { 
			for(int j=0; j<A+1; j++) {
				if(i!=j) {
					adj[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		for (int i = 0; i < B; i++) {
			int x = D[i];
			int y = E[i];
			if(x!=y) {
				adj[x][y] = F[i];
				adj[y][x] = F[i];
			}
		}

		for (int i = 1; i <= A; i++) {
			for (int j = 1; j <= A; j++) {
				for (int k = 1; k <= A; k++) {
					if (i != j && j != k && i != k) {
						if (adj[i][k]!=Integer.MAX_VALUE && adj[k][j]!=Integer.MAX_VALUE &&  adj[i][j] > adj[i][k] + adj[k][j]) {
							adj[i][j] = adj[i][k] + adj[k][j];
						}
					}
				}
			}
		}

		int res[] = new int[C];
		for (int i = 0; i < C; i++) {
			int x = G[i];
			int y = H[i];
			res[i] = adj[x][y] != Integer.MAX_VALUE ? adj[x][y] : -1;
		}
		return res;
	}

}

final int INF = Integer.MAX_VALUE;

public int[] solve(int A, int B, int C, int[] D, int[] E, int[] F, int[] G, int[] H) {
    int[][] adjMatrix = new int[A+1][A+1];
    fillGraph(adjMatrix, A, B, D, E, F);
    calculateMinDistance(adjMatrix,A);

    int ans[] = new int[C];
    for(int i = 0; i < C; i++) {
        int u = G[i], v = H[i];
        ans[i] = adjMatrix[u][v] == INF ? -1 : adjMatrix[u][v];
        //System.out.println(ans[i]+" ");
    }

    return ans;
}

// Fill graph - Adjacency matrix
private void fillGraph(int[][] adjMatrix, int A, int B, int[] D, int[] E, int[] F) {
    // Intialising with expected distances
    for(int i = 1; i <= A; i++) {
        for(int j = 1; j <= A; j++) {
            adjMatrix[i][j] = i == j ? 0 : INF;
        }
    }

    // Updating with given distances
    for(int i = 0; i < B; i++) {
        int u = D[i], v = E[i], dis = F[i];
        if(u != v && dis < adjMatrix[u][v]) {
            adjMatrix[u][v] = dis;
            adjMatrix[v][u] = dis;
        }
    }
}

// Floyd-Warshal Algo - Precalculating Distance
private void calculateMinDistance(int[][] cities,int A) {
    for(int k = 1; k <= A; k++) {
        for(int i = 1; i <= A; i++) {
            for(int j = 1; j <= A; j++) {
                if(cities[i][k] != INF && cities[k][j] != INF)
                    cities[i][j] = Math.min(cities[i][j], cities[i][k] + cities[k][j]);
            }
        }
    }
}
