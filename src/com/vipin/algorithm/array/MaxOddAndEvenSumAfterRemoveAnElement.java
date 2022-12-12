package com.vipin.algorithm.array;

public class MaxOddAndEvenSumAfterRemoveAnElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 1, 1 };
		System.out.println(solve(A));
	}

	// public static int solve(int[] A) {

	/*
	 * int L = A.length; int count = 0; int evenSum; int oddSum; int temp; boolean
	 * flag; int[]oddPrefix = new int[L]; int[]evenPrefix = new int[L]; oddPrefix[0]
	 * = 0; evenPrefix[0] = A[0]; for(int i=1;i<L;i++) { if(i%2==0) { evenPrefix[i]
	 * = evenPrefix[i-1]+A[i]; oddPrefix[i] = oddPrefix[i-1]; } else { evenPrefix[i]
	 * = evenPrefix[i-1]; oddPrefix[i] = oddPrefix[i-1]+A[i]; } }
	 * 
	 * for (int i = 0; i < L; i++) { evenSum = 0; oddSum = 0; temp = -1; flag =
	 * false; for (int j = 0; j < L; j++) { if(i==j) { continue; } if(j<i) { evenSum
	 * = evenPrefix[j]; oddSum = oddPrefix[j]; } else { temp = j-1; if (temp % 2 ==
	 * 0) { evenSum += A[j]; } else { oddSum += A[j]; } } flag = true; } if (flag &&
	 * evenSum == oddSum) { count++; } } for(int i=0;i<L;i++) { if(i%2==0) {
	 * if(evenPrefix[L-1] - A[i] == oddPrefix[L-1]) { count++; } } else {
	 * if(oddPrefix[L-1] - A[i] == evenPrefix[L-1]) { count++; } } }
	 */
	// return count;

	public static int solve(int[] A) {
        int L = A.length;
		int count = 0;
        int evenSum;
		int oddSum;
		int temp;
		boolean flag;
        int[]oddPrefix = new int[L];
        int[]evenPrefix = new int[L];
        oddPrefix[0] = 0;
        evenPrefix[0] = A[0];
        for(int i=1;i<L;i++) {
            if(i%2==0) {
                evenPrefix[i] = evenPrefix[i-1]+A[i];
                oddPrefix[i] = oddPrefix[i-1];
            } else {
                evenPrefix[i] = evenPrefix[i-1];
                oddPrefix[i] = oddPrefix[i-1]+A[i];
            }
        }
       
		for (int i = 0; i < L; i++) {
            if(i==0) {
                evenSum = oddPrefix[L-1];
                oddSum = evenPrefix[L-1]- evenPrefix[i];
            } else {
			    oddSum = oddPrefix[i-1] + evenPrefix[L-1] - evenPrefix[i];
                evenSum = evenPrefix[i-1] + oddPrefix[L-1] - oddPrefix[i];
            }
            if(oddSum==evenSum) {
                count++;
            }
		}
		return count;        
    }

}
