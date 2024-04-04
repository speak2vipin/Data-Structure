package com.vipin.algorithm.bitmanipulations;

public class MinFlipRequired {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 2;
		int b = 6;
		int c = 5;
		System.out.println(minFlips(a, b, c));
	}
	
	public static int minFlips(int a, int b, int c) {
		 int res= 0;
	        for(int i=31; i>-1; i--) {
	            int bitC = (c>>i)&1;
	            int bitA = (a>>i)&1;
	            int bitB = (b>>i)&1;
	        	if(bitC==0) {
	        		if(bitA==1 && bitB==1) {
	                    res +=2;
	                } else if((bitA^bitB)==1) {
	                    res++;
	                }
	        	} else {
	                if(bitA==0 && bitB==0) {
	                    res +=1;
	                } 
	            }
	        }
	        return res;
    }
	

}
