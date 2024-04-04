package com.vipin.algorithm.array;

public class MissingKthElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,3,4,7,11};
		int k = 5;
		MissingKthElement m = new MissingKthElement();
		System.out.println(m.findKthPositive(arr, k));
	}

	public int findKthPositive(int[] A, int k) {
		
		int N = A.length;
		int left = 0;
		int right = N - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (A[mid] - mid - 1 < k) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left+k;
	}

}
