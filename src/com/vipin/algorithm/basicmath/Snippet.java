package com.vipin.algorithm.basicmath;

public class Snippet {
	public int solve(int[] A, int[] B) {
	        Set<Integer>AS = new HashSet<Integer>();
	        Set<Integer>BS = new HashSet<Integer>();
	        int N = A.length;
	        for(int i=0; i<N; i++) {
	            AS.add(A[i]);
	            BS.add(B[i]);
	        }
	        for(int i=0; i<N; i++) {
	            for(int j=0; j<N; j++) {
	                if(A[j]>A[i] && B[j]>B[i] && AS.contains()) {
	
	                }
	            }
	        }
	
	    }
	}
	
}

