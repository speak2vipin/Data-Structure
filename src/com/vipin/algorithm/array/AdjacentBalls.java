package com.vipin.algorithm.array;

public class AdjacentBalls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] sortColors(int[] A) {
        int N = A.length;
        if(N==1) {
            return A;
        } 
        int count_0=0, count_1=0;
        // Count occurrence of all the balls
        for(int i=0;i<N;i++) {
            if(A[i]==0) {
                count_0++;
            } else if(A[i]==1) {
                count_1++;
            }
        }
        int count_2 = N-count_0-count_1;
        // Populate values as per counts
        while(count_0!=0) {
            A[--count_0] = 0;
        } 
        while(count_1!=0) {
            A[--count_1] = 1;
        } 
        while(count_2!=0) {
            A[--count_2] = 2;
        }
        return A;
    }

}
