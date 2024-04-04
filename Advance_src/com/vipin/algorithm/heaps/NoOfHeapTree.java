package com.vipin.algorithm.heaps;

public class NoOfHeapTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NoOfHeapTree n = new NoOfHeapTree();
		System.out.println(n.solve(4));
		Solution s = new Solution();
		System.out.println(s.solve(4));

	}

	public int solve(int A) {
		return (int)ways(A);
	}
	
	long findLeftSubTreeNodeCount(long A, int h) {
		
		long total_nodes_in_last_level = A - (1 * (2 ^ (h) - 1)); // (Total Nodes till 2nd last level ->
																	// 1+2+4+8+.....+2^(h-1) = 1(2^h-1)/(2-1) = 2^h-1
		long total_nodes_in_left_till_second_last_level = (2 ^ h - 1 - 1) / 2;
		// (Total nodes till 2nd last level = (2^h-1 --> (reduce root) = 2^h-1-1 -->
		// half it, equally divide = (2^h-2)/2 = 2^(h-1)-1)
		long total_nodes_in_left_side_for_last_level = Math.min(2 ^ h / 2, total_nodes_in_last_level);
		long total_nodes_in_left_side = total_nodes_in_left_till_second_last_level
				+ total_nodes_in_left_side_for_last_level;
		return total_nodes_in_left_side;
	}
	
	long ways(long n) {
		int mod = 1000000007;
		if(n==1) {
			return 1;
		} else if(n==2) {
			return 1;
		} else if(n==3) {
			return 2;
		}
		int h = (int) (Math.log(n) / Math.log(2));
		long l = findLeftSubTreeNodeCount(n, h);
		long r = n-1-l;
		return (factorial(n-1, l)%mod * (ways(l)%mod) * (ways(r)%mod))%mod;
	}

	long factorial(long A, long B) {
		long result = 1;
		int mod = 1000000007;
		if(A==B) {
			return result;
		}
		long combinations[][] = new long[(int)A+1][(int)B+1];
		for (int i = 0; i <= A; i++) {
			combinations[i][0] = 1;
		}
		for (int i = 1; i <= A; i++) {
			for (int j = 1; j <= B; j++) {
				if(i==j) {
					combinations[i][j] = 1;
				} else if(j>i) {
					combinations[i][j] = 0;
				} else {
					long sum = (combinations[i-1][j-1] + combinations[i-1][j])%mod;
					combinations[i][j] = sum;
				}
			}
		}
		return combinations[(int)A][(int)B]%mod;
	}
}

class Solution {
	int mod = 1000000007;

	public int solve(int A) {
		// formulae = (A-1)C(l) * ways(l) * ways(r)
		return (int) ways(A) % mod;
	}

	public int findleftSubtreeNodesCount(int n, int height) {// n is total number of nodes
		int total_Nodes_Except_LastLevel = (1 << height) - 1; // 2^height - 1
		int nodes_In_LastLevel = n - total_Nodes_Except_LastLevel;
		int left_Nodes_Count_Except_LastLevel = (total_Nodes_Except_LastLevel - 1) / 2;
		int left_Nodes_Count_At_LastLevel = Math.min((1 << height) / 2, nodes_In_LastLevel);

		return left_Nodes_Count_Except_LastLevel + left_Nodes_Count_At_LastLevel;
	}

	public int findNCR(int A, int B) {
		if (A == B)
			return 1;
		int[][] combinations = new int[A + 1][B + 1];
		// filling the first column
		for (int i = 0; i <= A; i++)
			combinations[i][0] = 1;
		// rest of the matrix
		for (int i = 1; i <= A; i++) {
			for (int j = 1; j <= B; j++) {
				if (i == j)
					combinations[i][j] = 1;
				else if (j > i)
					combinations[i][j] = 0;
				else {
					int sum = (combinations[i - 1][j - 1] + combinations[i - 1][j]) % mod;
					combinations[i][j] = sum;
				}
			}
		}
		return combinations[A][B] % mod;
	}

	public long ways(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 1;
		if (n == 3)
			return 2;
		int height = (int) (Math.log(n) / Math.log(2));
		// l+r = n-1
		int l = findleftSubtreeNodesCount(n, height);
		int r = n - 1 - l;
		// System.out.println("ncr = " + findNCR(n-1,l));
		return (findNCR(n - 1, l) % mod * ways(l) % mod * ways(r) % mod) % mod;
	}
}
