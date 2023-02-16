package com.vipin.algorithm.stack;

import java.util.Stack;

public class RedundantBraces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedundantBraces r = new RedundantBraces();
		System.out.println(r.braces("a+b"));

	}

	public int braces(String A) {
		Stack<Character> st = new Stack<Character>();
		int N = A.length();
		for (int i = 0; i < N; i++) {
			char temp = A.charAt(i);
			if(temp==')') {
				char c = '\u0000';
				int operand = 0;
				int operator = 0;
				while(!st.isEmpty() && st.peek()!='(') {
					c = st.pop();
					if(c=='+' || c=='-' ||c=='*' || c=='/') {
						operator++;
					} else {
						operand++;
					}
				}
				c = st.pop();
				if(c=='+' || c=='-' ||c=='*' || c=='/') {
					operator++;
				} else {
					operand++;
				}
				
			} else if(temp=='(' || !st.isEmpty()) {
				st.push(temp);
			}
			
		}
		return st.isEmpty() ? 0 : 
			(st.contains('(') || st.contains(')') ? 1 : 0);
	}

}
