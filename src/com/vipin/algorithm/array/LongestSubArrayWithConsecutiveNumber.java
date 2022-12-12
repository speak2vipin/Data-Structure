package com.vipin.algorithm.array;

import java.util.Arrays;

public class LongestSubArrayWithConsecutiveNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {360, 477, 270, 369, 451, 427, 320, 309, 304, 262, 413, 124, 413, 293, 333, 281, 
				54, 83, 9, 158, 267, 496, 213, 17, 276, 370, 412, 345, 295, 339, 178, 267, 283, 423, 
				83, 8, 7, 6, 5, 4, 3, 2, 1, 396, 165, 111, 468, 338, 87, 104 };
		System.out.println(solve(A));

	}

	public static int solve(int[] A) {
		Arrays.sort(A);
		int N = A.length;
		int prefix[] = new int[N];
		prefix[0] = 1;
		int temp;
		for (int i = 1; i < N; i++) {
			temp = A[i] - A[i - 1];
			if (temp == 1) {
				prefix[i] = prefix[i - 1] + 1;
			} else if(temp==0) {
				prefix[i] = 1;
			} else {
				prefix[i] = 1;
			}
		}
		int max = 1;
		for (int i = 1; i < N; i++) {
			if (prefix[i] > max) {
				max = prefix[i];
			}
		}
		return max;
	}

}
