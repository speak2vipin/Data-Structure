package com.vipin.algorithm.heaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumNoOfJobs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 5, 7, 1 };
		int[] B = { 7, 8, 8, 8 };
		MaximumNoOfJobs m = new MaximumNoOfJobs();
		// System.out.println(m.solve(A, B));

		int X[] = { 1, 7, 11, 8, 11, 7, 1 };
		int Y[][] = { { 0, 2, 4, 6 } };
		m.solve(X, Y);
	}

	public int solve(int[] A, int[] B) {
		int N = A.length;
		int input[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			input[i][0] = A[i];
			input[i][1] = B[i];
		}
		Arrays.sort(input, (X, Y) -> X[1] - Y[1]);
		int ans = 1;
		int end = input[0][1];
		for (int i = 1; i < N; i++) {
			int start = input[i][0];
			if (start >= end) {
				ans++;
				end = input[i][1];
			}
		}
		return ans;
	}

	public int[] solve(int[] A, int[][] B) {

		int N = A.length;
		int M = B.length;

		int ans[] = new int[M];

		for (int i = 0; i < M; i++) {
			int l1 = B[i][0];
			int r1 = B[i][1];

			int l2 = B[i][2];
			int r2 = B[i][3];
			Map<Integer, Integer> map = new HashMap<>();
			// Will give TLE
			/*
			if (l1 > -1 && l2 > -1 && r1 < N && r2 < N) {
				for (int j = l1; j <= r1; j++) {
					map.put(A[j], map.getOrDefault(A[j], 0) + 1);
				}

				for (int j = l2; j <= r2; j++) {
					if (map.get(A[j]) != null) {
						map.put(A[j], map.get(A[j]) - 1);
						if (map.get(A[j]) == 0) {
							map.remove(A[j]);
						}
					} else {
						break;
					}

				}
				if (map.isEmpty()) {
					ans[i] = 1;
				}
			} else {
				continue;
			}
			*/
			long prefix[] = new long[N];
			for(int j=0; j<N; j++) {
				if(j==0) {
					prefix[j] = (1l*A[j]) * A[j];
				} else {
					prefix[j] = (1l*A[j]) * A[j] + prefix[j-1]; 
				}
			}
			long sumLeft = 0;
			long sumRight = 0;
			if(l1==0) {
				sumLeft = prefix[r1];
			} else {
				sumLeft = prefix[r1] - prefix[l1];
			}
			
			if(l2==0) {
				sumRight = prefix[r2];
			} else {
				sumRight = prefix[r2] - prefix[l2];
			}
			ans[i] = (sumLeft==sumRight) ? 1 : 0;
		}
		return ans;
	}

}
