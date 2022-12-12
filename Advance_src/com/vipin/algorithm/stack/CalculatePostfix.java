package com.vipin.algorithm.stack;

import java.util.Stack;

public class CalculatePostfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input[] = { "4", "13", "5", "/", "+"};
		System.out.println(evalRPN(input));
	}
	
	 public static int evalRPN(String[] A) {
	        Stack<String> st = new Stack<String>();
	        int ans = 0;
	        int mod = 1000000009;
	        int x = 0;
	        int y = 0;
	        for(String s : A) {
	            if(isOperator(s)) {
	                if(st.isEmpty()) {
	                    continue;
	                } else {
	                	// Take care of x and i.e Order of Operands
	                	y = Integer.parseInt(st.pop());
	                    x = Integer.parseInt(st.pop());
	                    if(s.equals("+")) {
	                    	ans = x + y;
	                    } else if(s.equals("-")) {
	                    	ans = x - y;
	                    } else if(s.equals("*")) {
	                    	ans = x * y ;
	                    } else if(s.equals("/")) {
	                    	ans = x / y;
	                    }
	                    st.push(ans+""); 
	                }
	            } else {
	            	st.push(s);
	            }
	        }
	        if(!st.isEmpty()) {
	        	ans = Integer.parseInt(st.pop()) % mod;
	        }
	        
	        return ans;
	    }

	    static boolean isOperator(String s) {
	        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	    }

}
