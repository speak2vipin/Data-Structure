package com.vipin.algorithm.binarysearch;

public class PeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1, 2, 3, 4, 5};
		System.out.println(solve(A));

	}
	
    public static int solve(int[] A) {
        int N = A.length;
        int st = 0;
        int end = A.length-1;
        int mid = -1;
        while(st<=end) {
            mid = (st+end)/2;
            if((mid==0 || A[mid-1]<A[mid]) 
                    && (mid==N-1 || A[mid]>A[mid+1])){
                        return A[mid];
            }
            if(mid==0 || A[mid]>A[mid-1]) {
                st = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }

}
