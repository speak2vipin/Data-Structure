package com.vipin.algorithm.array;

public class MaxPrefixSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []A = {-533, -666, -500, 169, 724, 478, 358, -38, 
				   -536, 705, -855, 281, -173, 961, -509, -5, 
				    942, -173, 436, -609, -396, 902, -847, -708, 
				   -618, 421, -284, 718, 895, 447, 726, -229, 538, 
				    869, 912, 667, -701, 35, 894, -297, 811, 322, 
				   -667, 673, -336, 141, 711, -747, -132, 547, 
				    644, -338, -243, -963, -141, -277, 741, 529, 
				   -222, -684, 35};
		System.out.println(solve(A, 48));

	}
	
	 public static int solve(int[] A, int B) {
	        int prefixA[] = new int[A.length];
	        int suffixA[] = new int[A.length];
	        prefixA[0] = A[0];
	        suffixA[A.length-1] = A[A.length-1];
	        int sum = 0;
	        for(int i=1;i< A.length;i++) {
	            prefixA[i] = A[i] + prefixA[i-1];
	            suffixA[A.length-1-i] = A[A.length-1-i] + suffixA[A.length-1-i+1];
	        }
	        sum = prefixA[B-1]> suffixA[A.length-48] ?  prefixA[B-1] :suffixA[A.length-48];
	        for(int i=0; i< B-1;i++) {
		        int temp = prefixA[i]  + suffixA[A.length-B+1+i];
	            sum = temp> sum? temp:sum;
	        }
	        /*
	        for(int i=0;i< A.length;i++) {
	            if(i+B-1<A.length) {
	            	if(k<0) {
	            		sum = prefixA[i+B-1] > sum ? prefixA[i+B-1] : sum;
	            		
	            	} else {
	            		sum = (prefixA[i+B-1] - prefixA[i-1]) > sum ?( prefixA[i+B-1] - prefixA[i-1]) : sum;
	            	}
	            	k++;		
	            } else {
	                int temp = prefixA[A.length-1] - prefixA[i-1] + prefixA[j];
	                sum = temp> sum? temp:sum;
	                j++;
	            }
	        }*/
	        
	        
	        return sum;
	    }

}
