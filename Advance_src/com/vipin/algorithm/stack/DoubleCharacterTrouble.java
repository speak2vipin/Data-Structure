package com.vipin.algorithm.stack;

import java.util.Stack;

public class DoubleCharacterTrouble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solve("abccbc"));

	}
	
	public static String solve(String A) {
        Stack<Character> st = new Stack<Character>();
        int N = A.length();
        char temp = '\u0000';
        for(int i=0; i<N; i++) {
            temp = A.charAt(i);
            if(!st.isEmpty()&& st.peek()==temp) {
                st.pop();
            } else {
                st.push(temp);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) {
            ans = ans.append(st.pop());
        }
        return ans.reverse().toString();
    }

}
