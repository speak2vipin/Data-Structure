package com.vipin.algorithm.array;

public class NumberOfRectangleWithAreaLessThanBUsingTwoPinter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NumberOfRectangleWithAreaLessThanBUsingTwoPinter n =
					new NumberOfRectangleWithAreaLessThanBUsingTwoPinter();
		System.out.println(n.solve(null, 0));

	}
	
	 public int solve(int[] A, int B) {
	        int N = A.length-1;
	        int mod = 1000000007;
	    
	        int count = 0;
	        for(int i=0; i<=N; i++) {
	            int j = N;
	            while(i<j) {
	                long area = (1l * A[i]) * A[j];
	                if(area < B) {
	                    count = ((count % mod) + ((j-i)*2)%mod)%mod;
	                    break;
	                } else {
	                    j--;
	                }
	            }
	        }
	        int k=0;
	        while(k<=N && (A[k]*A[k])<B) {
	            count = (count + 1)%mod;
	            k++;
	        }
	        return count;
	    }

}
