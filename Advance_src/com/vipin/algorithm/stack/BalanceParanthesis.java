package com.vipin.algorithm.stack;

import java.util.Stack;

public class BalanceParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	    public int solve(String A) {
	        int N = A.length();
	        Stack<Character> stack = new Stack<Character>();
	        char temp = '\u0000';
	        char popChar = '\u0000';
	        for(int i=0; i<N; i++) {
	            temp = A.charAt(i);
	            if(temp == '(' || temp == '[' || temp == '{') {
	                stack.push(temp);
	            } else {
	                popChar = stack.pop();
	                if(temp == ')' && popChar == '(') {
	                    continue;
	                } else if(temp == ']' && popChar == '[') {
	                    continue;
	                } if(temp == '}' && popChar == '{') {
	                    continue;
	                } else {
	                    return 0;
	                }
	            }
	        }
	        if(stack.isEmpty()) {
	            return 1;
	        }
	        return 0;
	    }
	
}
