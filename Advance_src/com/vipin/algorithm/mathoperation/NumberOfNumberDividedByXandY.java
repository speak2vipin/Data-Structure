package com.vipin.algorithm.mathoperation;

public class NumberOfNumberDividedByXandY {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NumberOfNumberDividedByXandY n = new NumberOfNumberDividedByXandY();
		
		int A = 81991;
				
		int B = 2549;
		int C = 7;
		System.out.println(n.solve(A, B, C));
	}
	
	 public int solve(int A, int B, int C) {
	        int gcd = findGCD(B, C);
	        int lcm = (B*C)/gcd;
	        int count = A/lcm;
	        
	        return count;

	    }
	    int findGCD(int X, int Y) {
	        if(X==0) {
	            return Y; 
	        }
	        return findGCD(Y%X, X);
	    }

}
