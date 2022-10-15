package com.vipin.algorithms.array;

public class RemoveElementThenEvenAndOddElementSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = new int []{-1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -11, -12, -13, -14, -15, -16, -17, -18, -19, -20, -21, -22, -23, -24, -25, -26, -27, -28, 
				-29, -30, -31, -32, -33, -34, 
				69, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34  };
		System.out.println(solve(A));
	}

	public static int solve(int[] A) {
		int L = A.length;
		int count = 0;

		for (int i = 0; i < L; i++) {
			int evenSum = 0;
			int oddSum = 0;
			int temp = -1;
			boolean flag = false;
			for (int j = 0; j < L; j++) {
				if(i==j) {
					continue;
				}
				if(j<i) {
					temp = j;
				} else {
					temp = j-1;
				}
				if (temp % 2 == 0) {
					evenSum += A[j];
					flag = true;
				} else {
					oddSum += A[j];
				}
			}
			if (flag && evenSum == oddSum) {
				count++;
			}
		}
		return count;
	}

}
