package com.vipin.algorithm.collections;

import java.util.*;

public class PacificAtlanticWaterFlow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		pacificAtlantic(heights);

	}

	public static List<List<Integer>> pacificAtlantic(int[][] heights) {
		int N = heights.length;
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				char x = isOcean(heights, i, j);
				if(x=='Y') {
					Integer[]a = {i,j};
					List<Integer> l = Arrays.asList(a);
					ans.add(l);
				}
				
			}
		}
		return ans;

	}

	static char isOcean(int[][] A, int i, int j) {
		int N = A.length;
		if (i < 0 || j < 0) {
			return 'P';
		} else if (j > N - 1 || i > N - 1) {
			return 'A';
		} else {
			char ans1 = ' ';
			char ans2 = ' ';
			char ans3 = ' ';
			char ans4 = ' ';
			if (j+1 < N && A[i][j + 1] <= A[i][j]) {
				ans1 = isOcean(A, i, j + 1);
			}
			if (i+1 < N && A[i + 1][j] <= A[i][j]) {
				ans2 = isOcean(A, i + 1, j);
			}
			if (j-1>-1 && A[i][j - 1] <= A[i][j]) {
				ans3 = isOcean(A, i, j - 1);
			}
			if (i-1>-1 && A[i - 1][j] <= A[i][j]) {
				ans4 = isOcean(A, i - 1, j);
			}
			if ((ans1 == 'P' && (ans2 == 'A' || ans3 == 'A' || ans4 == 'A'))
					|| (ans2 == 'P' && (ans1 == 'A' || ans3 == 'A' || ans4 == 'A'))
					|| (ans3 == 'P' && (ans1 == 'A' || ans2 == 'A' || ans4 == 'A'))
					|| (ans4 == 'P' && (ans1 == 'A' || ans2 == 'A' || ans3 == 'A'))) {
				return 'Y';
			}
			return 'N';
		}
	}

}
