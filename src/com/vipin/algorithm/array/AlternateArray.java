package com.vipin.algorithm.array;

public class AlternateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 1, 1, 1, 1, 0, 1 };
		int B = 0;
		System.out.println(solve(A, B));
	}

	public static int[] solve(int[] A, int B) {
		int count = 0;
		int N = A.length;
		int len = 2 * B + 1;
		int[] output = new int[N - B + 1];
		boolean flagZero = false;
		boolean flagOne = false;
		for (int l = 0; l < N - len + 1; l++) {
			flagZero = false;
			flagOne = false;
			for (int m = 0; m < len; m++) {
				if (A[m + l] == 0 && !flagZero) {
					flagZero = true;
					flagOne = false;
				} else if (A[m + l] == 1 && !flagOne) {
					flagOne = true;
					flagZero = false;
				} else {
					break;
				}
				if (m == len - 1) {
					if (B == 0) {
						output[count] = l;
					} else {
						output[count] = (l + l + len - 1) / 2;
					}
					count++;
				}

			}
		}
		int[] Ans = new int[count];
		System.arraycopy(output, 0, Ans, 0, count);
		return Ans;
	}

}
