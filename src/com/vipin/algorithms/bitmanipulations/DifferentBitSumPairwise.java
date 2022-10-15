package com.vipin.algorithms.bitmanipulations;

public class DifferentBitSumPairwise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 2, 2, 2};
		int B[] = {1,3,5};
		int C[] = {2,3};
		System.out.println(cntBits(A));
		System.out.println(cntBits(B));
		System.out.println(cntBits(C));
	}
	
	public static int cntBits(int[] A) {
        
		int N = A.length;
		long sum = 0l;
		int modulus = 1000000007;
	    // Bruteforce
		/*
	    for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int count = 0;
				for (int k = 31; k > -1; k--) {
					if ((((A[j] >> k) & 1) ^ ((A[i] >> k) & 1)) == 1) {
						count++;
					}
				}
				sum += 2 * count;
			}
		}*/
	    for (int k = 31; k > -1; k--) {
	        int setCount = 0;
	        for(int i=0; i<N; i++) {
	            if(((A[i] >> k) & 1)==1) {
	                setCount++;
	            }
	        }
	        sum += ((setCount%modulus) * ((N - setCount)%modulus))%modulus;
	    }
		return (int)((sum*2)%modulus);
	}

}
