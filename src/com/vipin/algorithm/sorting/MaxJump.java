package com.vipin.algorithm.sorting;

import java.util.Arrays;

public class MaxJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 1,2,0,1 };
		System.out.println(canJump(A));
	}

	public static boolean canJump(int[] nums) {
		int N = nums.length - 1;
		if (N == 0) {
			return true;
		}
		int index = 0;
		while (index < N) {
			int x = nums[index];
			if (x == 0) {
				return false;
			} else if (x >= N) {
				return true;
			}
			int val[][] = new int[x][2];
			for (int i = 0; i < x; i++) {
				val[i][0] = index + i + 1;
				if (index + i + 1 <= N) {
					val[i][1] = nums[index + i + 1] + i;
				} else {
					val[i][1] = N;
				}
			}
			Arrays.sort(val, (A, B) -> B[1] - A[1]);
			index = val[0][0];
		}
		return true;
	}

}
