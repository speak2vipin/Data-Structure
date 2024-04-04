package com.vipin.algorithm.graph.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class CountOfPoisnousGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountOfPoisnousGraph c = new CountOfPoisnousGraph();
		
		int B[][] = {};
		System.out.println(c.solve1(100000, B));
	}

	Map<Integer, ArrayList<Integer>> adj = null;
	int visit[] = null;
	int zero = 0;
	int one = 0;

	public int solve(int A, int[][] B) {
		int mod = 998244353;

		visit = new int[A + 1];
		Arrays.fill(visit, -1);
		adj = new HashMap<>();
		for (int edge[] : B) {
			adj.computeIfAbsent(edge[0], val -> new ArrayList<Integer>()).add(edge[1]);
			adj.computeIfAbsent(edge[1], val -> new ArrayList<Integer>()).add(edge[0]);
		}
		int ans = 0;
		for (int i = 1; i <= A; i++) {
			if (visit[i] == -1) {
				if (!dfs(i, 0)) {
					return 0;
				}
			}
			if(one>0) {
				ans = (ans + (1 << one) % mod)%mod;
			} 
			if(zero>0) {
				ans = (ans + (1 << zero) % mod) % mod;
			}
			one = 0;
			zero = 0;
		}
		return ans;
	}

	boolean dfs(int node, int val) {
		visit[node] = 1 ^ val;
		if (visit[node] == 0) {
			zero++;
		} else {
			one++;
		}
		ArrayList<Integer> neighbours = adj.getOrDefault(node, new ArrayList<Integer>());
		for (Integer neighbour : neighbours) {
			if (visit[neighbour] == -1 && !dfs(neighbour, visit[node])) {
				return false;
			} else if (visit[node] == visit[neighbour]) {
				return false;
			}
		}
		return true;
	}
	
	public int solve1(int A, int[][] B) {
        int edges = B.length;

        //Step 1 : Converting input to adjenacy list
        //TC: O(Nodes + Edges)  SC: O(Nodes)
        ArrayList<Integer>[] path = new ArrayList[A+1];

        //creating as we required power 2 values.
        long[] two = new long[A+1];
        int mod = 998244353;
        two[0]=1;
        for(int i=1;i<=A;i++)
        two[i]=(two[i-1]*2)%mod;

        long ans = 1;

        for(int i=0; i<=A; i++) {
            path[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<edges;i++)
        {
            int u = B[i][0];
            int v = B[i][1];
            path[u].add(v);
            path[v].add(u);  //undirected graph
        }  

        //Step 2 : Traversing to path assigning color to each node and checking graph is bipertate graph or not
        //TC: O(Nodes + Edges)  SC: O(Nodes + Nodes)
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[A+1];

        for(int i=1;i<=A;i++)
        {
            if(color[i]==0)
            {                  
                int firstColor = 1; // assigning green color below
                int secondColor = 0;

                q.add(i);
                color[i]=1; //green

                while(q.size()>0)
                {
                    int u = q.remove();

                    ArrayList<Integer> list = path[u];
                    for(int j=0;j<list.size();j++)
                    {
                        int v = list.get(j);

                        if(color[v]==0)
                        {
                            color[v]=3-color[u]; //assigning invert color
                            q.add(v);
                            if(color[v]==1)
                            firstColor = (firstColor%mod + 1)%mod; //taking cnt of node
                            else
                            secondColor = (secondColor%mod + 1)%mod; //taking cnt of node
                        }
                        else if(color[v]==color[u])
                        {
                           return 0; // return as it is not bipertate graph
                        }
                    }
                }
                // calculating possibility of odd sum node for each component of graph
                ans = (ans * (two[firstColor]%mod+two[secondColor]%mod)%mod)%mod;
            }

        }
        return (int)ans;
    }
	
	class Solution {
	    public int ways(String[] pizza, int k) {
	        int rows = pizza.length, cols = pizza[0].length();
	        int apples[][] = new int[rows + 1][cols + 1];
	        int dp[][][] = new int[k][rows][cols];
	        for (int row = rows - 1; row >= 0; row--) {
	            for (int col = cols - 1; col >= 0; col--) {
	                apples[row][col] = (pizza[row].charAt(col) == 'A' ? 1 : 0) + apples[row + 1][col] + apples[row][col + 1]
	                        - apples[row + 1][col + 1];
	                dp[0][row][col] = apples[row][col] > 0 ? 1 : 0;
	            }
	        }
	        int mod = 1000000007;
	        for (int remain = 1; remain < k; remain++) {
	            for (int row = 0; row < rows; row++) {
	                for (int col = 0; col < cols; col++) {
	                    for (int next_row = row + 1; next_row < rows; next_row++) {
	                        if (apples[row][col] - apples[next_row][col] > 0) {
	                            dp[remain][row][col] += dp[remain - 1][next_row][col];
	                            dp[remain][row][col] %= mod;
	                        }
	                    }
	                    for (int next_col = col + 1; next_col < cols; next_col++) {
	                        if (apples[row][col] - apples[row][next_col] > 0) {
	                            dp[remain][row][col] += dp[remain - 1][row][next_col];
	                            dp[remain][row][col] %= mod;
	                        }
	                    }
	                }
	            }
	        }
	        return dp[k - 1][0][0];
	    }
	}
	

	    

}
