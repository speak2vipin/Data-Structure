package com.vipin.algorithm.matrixOr2DArray;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans[][] = mySpriral(6);
		for(int[] temp : ans) {
			for(int x : temp) {
				System.out.print(x + " ");
			}
			System.out.println();
		}

	}

	public int[][] generateMatrix(int A) {
		int arr[][] = new int[A][A];
		int k = 1;
		int rowStart = 0, rowEnd = A - 1;
		int colStart = 0, colEnd = A - 1;
		while (rowStart <= rowEnd && colStart <= colEnd) {
			for (int i = colStart; i <= colEnd; i++) {
				arr[rowStart][i] = k++;
			}
			rowStart = rowStart + 1;

			for (int i = rowStart; i <= rowEnd; i++) {
				arr[i][colEnd] = k++;
			}

			colEnd = colEnd - 1;
			if (rowStart < rowEnd) {
				for (int i = colEnd; i >= colStart; i--) {
					arr[rowEnd][i] = k++;
				}

				rowEnd = rowEnd - 1;
			}

			if (colStart < colEnd) {
				for (int i = rowEnd; i >= rowStart; i--) {
					arr[i][colStart] = k++;
				}
				colStart = colStart + 1;
			}
		}
		return arr;
	}

	static int[][] mySpriral(int A) {
		int ans[][] = new int[A][A];
		int rowStart = 0, rowEnd = A - 1;
		int colStart = 0, colEnd = A - 1;
		int count = 1;
		while (rowStart <= rowEnd && colStart <= colEnd) {
			for (int j = colStart; j <= colEnd; j++) {
				ans[rowStart][j] = count++;
			}
			rowStart = rowStart + 1;
			for (int i = rowStart; i <= rowEnd; i++) {
				ans[i][colEnd] = count++;
			}
			colEnd = colEnd - 1;
			for (int j = colEnd; j >= colStart; j--) {
				ans[rowEnd][j] = count++;
			}
			rowEnd = rowEnd - 1;
			for (int i = rowEnd; i >= rowStart; i--) {
				ans[i][colStart] = count++;
			}
			colStart = colStart + 1;
		}
		return ans;
	}
}
