package com.vipin.algorithm.array;

public class MatrixTraverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[][] = /*{ {1,2,3}, {4,5,6}, {7,8,9 }};*/

				{{ 21, 62, 16, 44, 55, 100, 16, 86, 29 }, { 62, 72, 85, 35, 14, 1, 89, 15, 73 },
				{ 42, 44, 30, 56, 25, 52, 61, 23, 54 }, { 5, 35, 12, 35, 55, 74, 50, 50, 80 },
				{ 2, 65, 65, 82, 26, 36, 66, 60, 1 }, { 18, 1, 16, 91, 42, 11, 72, 97, 35 },
				{ 23, 57, 9, 28, 13, 44, 40, 47, 98 } };
		// 
		System.out.println(solve(A));

	}

	public static int[][] solve(int[][] A) {
		int x = A.length;
		int y = A[0].length;
		int ANS[][] = new int[y][x];
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (i == j) {
					ANS[i][j] = A[i][j];
				} else {
					ANS[j][i] = A[i][j];
				}
				//if(y<=x && j<=i) {
					/*if (i == j) {
						ANS[i][j] = A[i][j];
					} else {
						ANS[i][j] = A[j][i];
						ANS[j][i] = A[i][j];
					}
				} else if(x<y && i<=j) {
					if (i == j) {
						ANS[i][j] = A[i][j];
					} else {
						ANS[i][j] = A[j][i];
						//ANS[j][i] = A[i][j];
					} */
				//}
			}
		}
		return ANS;
	}
}
