package com.vipin.algorithm.binaryrsearch;

public class MinimumLengthSubArrayWithSumLessThanK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 1, 2, 3, 4, 5 };
		MinimumLengthSubArrayWithSumLessThanK m = new MinimumLengthSubArrayWithSumLessThanK();
		System.out.println(m.solve(A, 10));
		
	}
	
	public int solve(int[] A, int B) {
        int start = 1;
        int end = A.length;
        while(start<=end) {
            int mid = start + (end - start)/2;
            boolean sumGreaterThanB = sumGreaterThanB(A, mid, B);
            boolean sumGreaterThanbForNextElement = !sumGreaterThanB ? sumGreaterThanB(A, mid+1, B) : false;
            if(!sumGreaterThanB && sumGreaterThanbForNextElement) {
                return mid;
            }
            if(sumGreaterThanB) {
            	end = mid-1;
            } else {
            	start = mid + 1;
            }
        }
        return -1;

    }

    boolean sumGreaterThanB(int A[], int K, int B) {
        int N = A.length;
        long sum = 0;
        for(int i=0; i<K; i++) {
            sum += A[i];
            if(sum>B) {
                return true;
            }
        }
        for(int i=K; i<N; i++) {
            sum = sum - A[i-K] + A[i];
            if(sum>B) {
                return true;
            }
        }
        return false;
    }

}
