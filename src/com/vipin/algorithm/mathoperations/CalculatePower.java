package com.vipin.algorithm.mathoperations;

public class CalculatePower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			System.out.println(myPow(2.00000, -2));
	}
	
	public static double myPow(double x, int n) {
        if(n==0) {
            return 1.0;
        }
        if(n==1) {
            return x;
        } else if(n==-1) {
            return 1.0/x;
        }
        if(n>-1) {
        	return myPow(x, (n+1)/2) * myPow(x, n/2);
        } else {
        	return myPow(x, (n-1)/2) * myPow(x, n/2);
        }
       

    }

}
