package com.vipin.algorithm.binaryrsearch;

import java.util.Arrays;

public class MinAbsoluteDiffOfElementOfEachRow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A = 3;
		int B = 2;
		int[][] C = { { 7, 3 }, { 2, 1 }, { 4, 9 } };
		
		MinAbsoluteDiffOfElementOfEachRow m = new MinAbsoluteDiffOfElementOfEachRow();
		System.out.println(m.solve(A, B, C));
	}

	public int solve(int A, int B, int[][] C) {
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < A; i++) {
			Arrays.sort(C[i]);
		}
		for (int i = 0; i < A - 1; i++) {
			int temp1[] = C[i];
			int temp2[] = C[i + 1];
			for (int val : temp1) {
				int nextArrayChosenIndex = upperbound(val, temp2);
				if(nextArrayChosenIndex==-1) {
					ans = Math.min(ans, Math.abs(val - temp2[temp2.length-1]));
				} else { 
					if (val == temp2[nextArrayChosenIndex]) {
						return 0;
					}
					ans = Math.min(ans, Math.abs(val - temp2[nextArrayChosenIndex]));
					if (nextArrayChosenIndex != 0) {
						ans = Math.min(ans, Math.abs(val - temp2[nextArrayChosenIndex - 1]));
					}
				}
			}
		}
		return ans;
	}

	int upperbound(int element, int temp[]) {
		int st = 0;
		int en = temp.length - 1;
		int index = -1;
		while (st <= en) {
			int mid = st + (en - st) / 2;
			if (temp[mid] < element) {
				st = mid + 1;
			} else {
				index = mid;
				en = mid - 1;
			}
		}
		return index;
	}

}
