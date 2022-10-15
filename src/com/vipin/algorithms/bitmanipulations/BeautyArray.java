package com.vipin.algorithms.bitmanipulations;

public class BeautyArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int getBeauty(int[][]A, int B) {
		int M = A.length;
		int N = A[0].length;
		int ans = 1;
		while(B>0) {
			for(int[] a : A) {
				int temp = a[0];
				for(int i=1;i<N;i++) {
					temp = temp ^ a[i];
				}
				ans = ans & temp;
			}
			if(ans==0) {
				return ans;
			}
		}
		return ans;
	}

}
