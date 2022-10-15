package com.vipin.algorithms.array;

import java.util.Stack;

public class AllATogeteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("AAABA"));
		System.out.println(solve("AAB"));
		
		System.out.println(solve("BBBABABAB"));
		System.out.println(solve("BABABAAA"));
		System.out.println(solve("AAABBB"));
	}
	
	public static int solve(String A) {
		//String temp = "AAABA";
		Stack<Character> cStack = new Stack<Character>();
        int count = 0;
        //String S = "";
        for(int i=0; i<A.length();i++) {
        	if(A.charAt(i)=='A') {
        		while(!cStack.isEmpty() && cStack.peek()=='B') {
        			count++;
        			cStack.pop();
        		}
        	}
        	if(cStack.isEmpty() && A.charAt(i)=='B' ) {
        		
        	} else {
        		cStack.push(A.charAt(i));
        	}
        }
        return count;     
    }

}
