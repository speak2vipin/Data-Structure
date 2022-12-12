package com.vipin.algorithm.sorting;

import java.util.Arrays;

public class ChangeTheArrayContest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 8, 19, 25, 1, 1};
		int B[] = { 3, 4, 1};
		int C[] = { 1, 5, 10 };
		System.out.println(solve(A, B, C));

	}
	
	public static int solve(int[] A, int[] B, int[] C) {
        Arrays.sort(A);
        int N = A.length;
        int X = B.length;
        int tempIndex = N-1;
        
        for(int i=0; i<X; i++) {
            if(A[tempIndex]<C[i]) {
                continue;
            } else {
                int j=0;
                while(j<B[i]) {
                    A[tempIndex-j]=C[i];
                    j++;
                }
                Arrays.sort(A);
            }
        }
        int sum = 0;
        for(int i=0; i<N; i++) {
            sum+=A[i];
        }
        return sum;
    }

}
