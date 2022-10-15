package com.vipin.algorithms.array;

public class RangeSum {
	
	public static void main(String[] args) {
		int [] A = { 7, 3, 1, 5, 5, 5, 1, 2, 4, 5 };
		int [][]B = {{7, 10},{3, 10},{3, 5},{1, 10}};
		System.out.println(rangeSum(A, B));
	}

	public static long[] rangeSum(int[] A, int[][] B) {
        long[] resultLong = new long[B.length];
        long[] APrefix = new long[A.length];
        APrefix[0] = A[0];
        for(int i=1;i<A.length;i++) {
            APrefix[i] = APrefix[i]+APrefix[i-1];
        }
        for(int i=0; i<B.length; i++) {
            int left = B[i][0]-1;
            int right = B[i][1]-1;
            long sum;
            if(left==0) {
                sum = APrefix[right];
            } else if(left==right) {
                sum = APrefix[left]-APrefix[left-1];
            } else {
                sum = APrefix[right] - APrefix[left-1];
            }
            resultLong[i] = sum;
        }
        return resultLong;
    }
}
