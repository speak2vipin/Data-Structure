package com.vipin.algorithm.greedyalgorithms;

public class MaximumJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {17,19,96};
		System.out.println(solve(A, 83, 22));
		
	}
	
	public static int solve(int[] A, int B, int C) {
        int N= A.length;
        int cost=0;
        for(int i=0; i<N-1; ) {
            int one = B*(Math.abs(A[i+1]-A[i]));
            int two = 0;
            if(i<N-2){
                two = C*(Math.abs(A[i+2]-A[i]));
            }
            //int two = C*(Math.abs(A[i+2]-A[i]));
            if(one>two && two!=0) {
                cost+=two;
                i=i+2;
            } else {
                cost+=one;
                i=i+1;
            }
        }
        int dp[][] = new int[]
        return cost;
    }

}
