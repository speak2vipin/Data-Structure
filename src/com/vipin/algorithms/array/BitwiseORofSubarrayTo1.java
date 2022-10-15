package com.vipin.algorithms.array;

public class BitwiseORofSubarrayTo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int B[] = {0, 1, 0, 0, 0 };
		System.out.println(solve(5, B));
	}
	
	 public static long solve(int A, int[] B) {
	        // Remember no of subarray of an array with length N is Total = N*(N+1)/2
	        int total = A*(A+1)/2;
	        int count =0;
	        for(int i=0; i<A;i++) {
	            if(B[i]==0) {
	                // Find number of consecutive 0 in Array 
	                count++;
	            } else {
	                // Reduce the subarray count formed by 0 (Single or consecutive)
	                total = total - (count*(count+1)/2);
	                count = 0;
	            }
	        }
	        if(count!=0) {
	        	total = total - (count*(count+1)/2); 
	        }
	        return total;
	    }

}
