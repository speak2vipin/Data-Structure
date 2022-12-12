package com.vipin.algorithm.binarysearch;

public class SquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(Integer.MAX_VALUE));
	}

	public static int sqrt(int A) {
		long left = 0;
		long right = A;
		long mid = -1;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if ((mid * mid <= A) && ((mid + 1) * (mid + 1) > A)) {
				return (int)mid;
			}
			if (mid * mid < A) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;

	}

}
