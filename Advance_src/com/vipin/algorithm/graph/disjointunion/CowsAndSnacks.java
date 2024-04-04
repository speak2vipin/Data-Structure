package com.vipin.algorithm.graph.disjointunion;

import java.util.ArrayList;

public class CowsAndSnacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A = 5;
		// int[][] B = { { 1, 2 }, { 4, 3 }, { 1, 4 }, { 3, 4 } };

		ArrayList<ArrayList<Integer>> B = new ArrayList<>();
		ArrayList<Integer> B1 = new ArrayList<>();
		B1.add(1);
		B1.add(2);
		B.add(B1);
		ArrayList<Integer> B2 = new ArrayList<>();
		B2.add(4);
		B2.add(3);
		B.add(B2);
		ArrayList<Integer> B3 = new ArrayList<>();
		B3.add(1);
		B3.add(4);
		B.add(B3);
		ArrayList<Integer> B4 = new ArrayList<>();
		B4.add(3);
		B4.add(4);
		B.add(B4);

		CowsAndSnacks c = new CowsAndSnacks();
		System.out.println(c.solve(A, B));
	}

	int parent[] = null;
	int height[] = null;

	public int solve(int A, ArrayList<ArrayList<Integer>> B) {
		parent = new int[A + 1];
		height = new int[A + 1];
		for (int i = 1; i <= A; i++) {
			parent[i] = i;
		}
		int ans = 0;
		for (ArrayList<Integer> b : B) {
			if (!union(b.get(0), b.get(1))) {
				ans++;
			}
		}
		return ans;
	}

	boolean union(int x, int y) {
		int parentX = getParent(x);
		int parentY = getParent(y);
		if (parentX == parentY) {
			return false;
		}
		if(height[parentX]>height[parentY]) {
			parent[parentY] = parentX;
		} else if(height[parentX]<height[parentY]) {
			parent[parentX] = parentY;
		} else {
			parent[parentY] = parentX;
			height[parentX]++;
		}
		return true;
	}

	int getParent(int x) {
		if (parent[x] != x) {
			parent[x] = getParent(parent[x]);
		}
		return parent[x];
	}

	public int solve(int A, int[][] B) {
		int[] parent = new int[A + 1];
		for (int i = 0; i <= A; i++)
			parent[i] = i;
		int cnt = 0;
		for (int i[] : B) {
			int p1 = findParent(i[0], parent);
			int p2 = findParent(i[1], parent);
			if (p1 != p2) {
				parent[p1] = p2;
			} else {
				cnt++; // p1==p2 means both the flavors are already taken
			}
		}
		return cnt;
	}

	public int findParent(int x, int[] parent) {
		while (parent[x] != x) {
			parent[x] = parent[parent[x]];
			x = parent[x];
		}
		return x;
	}

}
