package com.vipin.algorithm.bitmanipulations;

public class SamsMaximumScoreWithLeastAlexsHelps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(4));
		System.out.println(solve(5));
		System.out.println(solve(3));
	}
	
	 public static int solve(int A) {
	        int help = 0;
	        int target;
	        if(A==0) {
	            return 0;
	        }
	        help = 1;
	        target = 1;
	        while(A>=(target<<1)) {
	            target = target<<1;
	        }
	        if(target==A) {
	            return help;
	        } else {
	            help = help + (A-target);
	            return help;
	        }
	    }
	
	

}
