package com.vipin.algorithm.array;

public class OutOfBoundaryPaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findPaths(2, 2, 2, 0, 0));
	}

	public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		int xWays = 0;
		int yWays = 0;
		int tempPositiveTotal = 0;
		int tempNegativeTotal = 0;
		int tempPositiveTotalN = 0;
		int tempNegativeTotalN = 0;
		if (m - startRow > maxMove) {
			tempPositiveTotal = 0;
		}
		if (n - startColumn > maxMove) {
			tempNegativeTotal = 0;
		}
		if (m - startRow <= maxMove) {
			xWays = 1;

			int diff = m - startRow;
			int factor = 1;
			int tempXWays = 1;
			int x = 1;
			tempPositiveTotal = 1;

			while (diff + 2 * factor <= maxMove) {
				tempPositiveTotal += tempXWays * (m - startRow);
				while (diff + 2 * factor + x <= maxMove && x <= n) {
					tempPositiveTotal += tempPositiveTotal;
					x++;
				}
				factor++;
			}
			factor = 1;
			diff = startRow;
			x = 1;
			tempNegativeTotal = 1;
			while (diff + 2 * factor <= maxMove) {
				tempNegativeTotal += tempXWays * (startRow);
				while (diff + 2 * factor + x <= maxMove && x <= n) {
					tempNegativeTotal += tempNegativeTotal;
					x++;
				}
				factor++;
			}
		}

		if (n - startColumn <= maxMove) {
			// yWays = 1;

			int diff = n - startColumn;
			int factor = 1;
			int tempXWays = 1;
			int x = 1;
			tempPositiveTotalN = 1;

			while (diff + 2 * factor <= maxMove) {
				tempPositiveTotalN = tempXWays * (n - startColumn);
				while (diff + 2 * factor + x <= maxMove && x <= n) {
					tempPositiveTotalN += tempPositiveTotalN;
					x++;
				}
				factor++;
			}
			factor = 1;
			diff = startColumn;
			tempNegativeTotalN = 1;
			while (diff + 2 * factor <= maxMove) {
				tempNegativeTotalN += tempXWays * (startColumn);
				while (diff + 2 * factor + x <= maxMove && x <= n) {
					tempNegativeTotalN += tempNegativeTotalN;
					x++;
				}
				factor++;
			}
			while()
		}
		return tempPositiveTotal + tempNegativeTotal + tempPositiveTotalN + tempNegativeTotalN;

	}

}
