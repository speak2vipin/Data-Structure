package com.vipin.algorithms.array;

import java.util.Scanner;

public class StarPattern {

	 public static void main(String[] args) {
	        // YOUR CODE GOES HERE
	        // Please take input and print output to standard input/output (stdin/stdout)
	        // DO NOT USE ARGUMENTS FOR INPUTS
	        // E.g. 'Scanner' for input & 'System.out' for output
	        Scanner sc =  new Scanner(System.in);
	        int N = sc.nextInt();
	        
	        int gap = 0;
	        StringBuilder sb = null;
	        for(int i=N; i>0;i--) {
	        	String temp="";
	            for(int j=0;j<i;j++) {
	                temp += "*"; 
	            }
	            for(int j=0; j<gap;j++) {
	                temp +=" ";
	            }
	            sb = new StringBuilder(temp);
		        temp = temp+sb.reverse().toString();
		        System.out.println(temp);
		        gap++;
	        }
	        gap--;
	        for(int i=1; i<N+1; i++) {
	        	String temp="";
	            for(int j=0;j<i;j++) {
	                temp += "*"; 
	            }
	            for(int j=0; j<gap;j++) {
	                temp +=" ";
	            }
	            sb = new StringBuilder(temp);
		        temp = temp+sb.reverse().toString();
		        System.out.println(temp);
		        gap--;
	        }

	    }
	

}
