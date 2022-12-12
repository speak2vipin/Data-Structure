package com.vipin.algorithm.stringpatternmatching;

public class KMPAlgoImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("111", "111"));

	}

	public static int solve(String A, String B) {
        // Implementation of KMP algorithm
        String D = A + "@" + B + B;
        int N = D.length();
        char d[] = D.toCharArray();
        int Z[] = new int[N];
        Z[0] = 0;
        int L=0, R=0;
        for(int i=1; i<N; i++) {
            if(i>R) {
                L = i; R = i;
                while(R<N && d[R] == d[R-L]) {
                    R++;
                }
                // Take care of this point
                Z[i] = R - L;
                // Take care of this point
                R = R-1;
            } else {
            	// Take care of this point
                if(i+Z[i-L] <= R) {
                    Z[i] = Z[i-L];
                } else {
                	// Take care of this point
                	L = i;
                    while(R<N && d[R] == d[R-L]) {
                        R++;
                    }
                    Z[i] = R - L;
                    R = R-1;
                }
            }
        }
        int count = 0;
        int patternLen = A.length();
        for(int i=0; i<N; i++) {
            if(Z[i]==patternLen) {
                count++;
            }
        }
        // Take care of this point
        if(A.equals(B)) {
            count--;
        }
        return count;
    }
}
