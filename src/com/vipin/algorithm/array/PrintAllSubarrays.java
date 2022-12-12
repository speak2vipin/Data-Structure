package com.vipin.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubarrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1,2,3,4};
		for(int[] a : solve(A)) {
			for(int i : a) {
				System.out.print(i +" ");
			}
			System.out.println();
		}
		int x = Integer.MIN_VALUE;
	}

	public static int[][] solve(int[] A) {
		int temp = 0;
		int N = A.length;
		int count = (N * (N + 1)) / 2;
		int ans[][] = new int[count][];

		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				List<Integer> l = new ArrayList<Integer>();
				
				for (int k = i; k <= j; k++) {
					l.add(A[k]);
				}
				int size = l.size();
				int[]tempA = new int[size];
				for(int x=0;x<size;x++) {
					tempA[x] = l.get(x);
				}	
				ans[temp] = tempA;
				temp++;
			}			
		}
		return ans;

	}

}
