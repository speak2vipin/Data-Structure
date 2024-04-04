package com.vipin.algorithm.sorting;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {-2,3,-5};
		MergeSort m = new MergeSort();
		m.sortArray(A);

	}

	public int[] sortArray(int[] nums) {
		int end = nums.length - 1;
		sort(nums, 0, end);
		return nums;
	}

	void sort(int A[], int st, int end) {
		if (st == end) {
			return;
		}
		int mid = (st + end) / 2;
		sort(A, st, mid);
		sort(A, mid + 1, end);
		merge(A, st, mid, end);
	}

	void merge(int A[], int st, int mid, int end) {
		int N = mid - st + 1;
		int M = end - (mid + 1) + 1;
		int B[] = new int[N];
		int C[] = new int[M];
		for (int i = st; i < mid + 1; i++) {
			B[i - st] = A[i];
		}
		for (int i = mid + 1; i < end + 1; i++) {
			C[i - (mid + 1)] = A[i];
		}
		int i = 0, j = 0;
		for (int k = st; k <=end; k++) {
			if (i == N) {
				A[k] = C[j];
				j++;
			}
			else if (j == M || B[i] <= C[j]) {
				A[k] = B[i];
				i++;
			} else {
				A[k] = C[j];
				j++;
			}
		}
	}

}
