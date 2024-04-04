package com.vipin.algorithm.array;

public class NumberOfNegativeNumberin2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };
		System.out.println(countNegatives(grid));
	}

	public static int countNegatives(int[][] grid) {
		int ans = 0;
		int N = grid[0].length - 1;
		int n = N;
		for (int temp[] : grid) {
			while (n > -1 && temp[n] < 0) {
				n--;
			}

			ans = ans + (N - n);

		}
		return ans;
	}

}
