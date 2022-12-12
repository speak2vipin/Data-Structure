package com.vipin.algorithm.recurssion;

import java.util.ArrayList;

public class TowerOfHanoi {
	//static int A = 3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//towerOfHanoi(3);
		for(int[] a : towerOfHanoi(3)) {
			System.out.println(a[0] + " " +a[1] + " "+a[2]);
		}

	}

	public static  int[][] towerOfHanoi(int A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		toh(A, 1, 2, 3, result);
		int size = result.size();
		int ans[][] = new int[size][3];
		int index = 0;
		for(ArrayList<Integer> list : result) {
			for(int i=0; i<3; i++) {
				ans[index][i] = list.get(i);
			}
			index++;
		}
		return ans;

	}

	public static void toh(int X, int src, int mid, int dest, ArrayList<ArrayList<Integer>> result) {
		if (X == 0) {
			return;
		}
		toh(X - 1, src, dest, mid, result);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(X);
		temp.add(src);
		temp.add(dest);
		result.add(temp);
		//System.out.println(X + " " + src + " " + dest );
		toh(X - 1, mid, src, dest, result);
	}
	
//	[1 1 3 ] [2 1 2 ] [1 3 2 ] [3 1 3 ] [1 2 1 ] [2 2 3 ] [1 1 3 ]

}
