package com.vipin.algorithm.array;

public class LeftRotataingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(new int[] {1,2,3,4,5}, new int[] {3,2}));
	}

	public static int[][] solve(int[] A, int[] B) {

		int len = A.length;
		int[][] result = new int[B.length][];
		int count = 0;
		for (int i : B) {
			int Temp[] = A.clone();
			swap(Temp, 0, len - 1);
			swap(Temp, 0, len - 1 - i);
			swap(Temp, len - i, len - 1);
			result[count++] = Temp;
		}
		return result;
	}

	static void swap(int[] A, int start, int end) {
		int temp;
		for (int i = start, j = end; i < j; i++, j--) {
			temp = A[i];
			A[i] = A[j];
			A[j] = temp;
		}
	}

}
