package com.vipin.algorithm.array;

import java.util.Arrays;

public class ArrayIsAnArithmeticProgression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int solve(int[] A) {
        Arrays.sort(A);
        int diff = A[1]-A[0];
        int N = A.length;
        for(int i=1; i<N-1;i++) {
            if(!(diff == A[i+1]-A[i])) {
                return 0;
            }
        }
        return 1;
    }

}
