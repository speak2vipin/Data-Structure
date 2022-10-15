package com.vipin.algorithm.matrixOr2DArray;

public class MaxSumOfSquareSubmatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = { { 1, 1, 1, 1, 1 }, // 5
				{ 2, 2, 2, 2, 2 }, // 10
				{ 3, 8, 6, 7, 3 }, // 27
				{ 4, 4, 4, 4, 4 }, // 20
				{ 5, 5, 5, 5, 5 }, // 25
		};
		int B = 3;
		System.out.println(solve(A, B));
		int A1[][] = { { 2, 2 }, { 2, 2 } };
		int B1 = 2;
		System.out.println(solve(A1, B1));

	}

	public static int solve(int[][] A, int B) {
		int N = A.length;
		int sum = Integer.MIN_VALUE;
		for (int j = 1; j < N; j++) {
			A[0][j] = A[0][j - 1] + A[0][j];
		}
		for (int i = 1; i < N; i++) {
			A[i][0] = A[i - 1][0] + A[i][0];
		}
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				A[i][j] = A[i][j] + A[i][j - 1] + A[i - 1][j] - A[i - 1][j - 1];
			}
		}
		for (int i1 = 0; i1 < N; i1++) {
			for (int j1 = 0; j1 < N; j1++) {
				for (int i2 = i1; i2 < N; i2++) {
					for (int j2 = j1; j2 < N; j2++) {
						if (i2 - i1 == j2 - j1) {
							int tempSum = A[i2][j2];
							if (i1 - 1 > -1) {
								tempSum -= A[i1 - 1][j2];
							}
							if (j1 - 1 > -1) {
								tempSum -= A[i2][j1 - 1];
							}
							if (i1 - 1 > -1 && j1 - 1 > -1) {
								tempSum += A[i1 - 1][j1 - 1];
							}
							// sum = Math.max(sum, tempSum);
						}
					}
				}
			}
		}
		B = B - 1;
		for (int i1 = 0; i1 < N; i1++) {
			for (int j1 = 0; j1 < N; j1++) {
				if (i1 + B < N && j1 + B < N) {
					int tempSum = A[i1 + B][j1 + B];
					if (i1 - 1 > -1) {
						tempSum -= A[i1 - 1][j1 + B];
					}
					if (j1 - 1 > -1) {
						tempSum -= A[i1 + B][j1 - 1];
					}
					if (i1 - 1 > -1 && j1 - 1 > -1) {
						tempSum += A[i1 - 1][j1 - 1];
					}
					sum = Math.max(sum, tempSum);
				}
				else {
					break;
				}
			}
		}

		return sum;
	}
}
