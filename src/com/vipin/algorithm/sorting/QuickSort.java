package com.vipin.algorithm.sorting;

public class QuickSort {
	
	public static void main(String[] args) {
		int A[] = {1, 4, 10, 2, 1, 5};
		A = solve(A);
		for(int x : A) {
			System.out.println(x);
		}
	}

	public static int[] solve(int[] A) {
		int end = A.length - 1;
		quicksort(A, 0, end);
		return A;
	}

	static void quicksort(int[] A, int start, int end) {
		while (start >= end) {
			return;
		}
		int pe = partition(A, start, end);
		quicksort(A, start, pe - 1);
		quicksort(A, pe + 1, end);
	}

	static int partition(int[] A, int start, int end) {
		int pe = A[end];
		int i = start;
		for (int j = start; j < end; j++) {
			if (A[j] <= pe) {
				swap(A, i, j);
				i++;
			}
		}
		swap(A, i, end);
		return i;
	}

	static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
