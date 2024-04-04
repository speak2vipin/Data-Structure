package com.vipin.algorithm.array;

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4,-1,0,3};
		int[] B = {-2, 6, 0, 4};
		System.out.println(solution(A, B));

	}
	
	public static int solution(int[] A, int[] B) {
        // Implement your solution here
        int N = A.length;
        long prefixA[] = new long[N]; 
        long prefixB[] = new long[N]; 
        for(int i=0; i<N; i++) {
            if(i==0) {
                prefixA[i] = A[i];
            } else {
                prefixA[i] = A[i] + prefixA[i-1];
            }
        }
        for(int i=0; i<N; i++) {
            if(i==0) {
                prefixB[i] = B[i];
            } else {
                prefixB[i] = B[i] + prefixB[i-1];
            }
        }
        int result = 0;
        for(int i=0; i<N-1; i++) {
            if(prefixA[i]==prefixA[N-1]-prefixA[i] 
            && prefixA[i]==prefixB[i]
            && prefixA[i]==prefixB[N-1]-prefixB[i] ) {
                result++;
            }
        }
        return result;
    }

}
