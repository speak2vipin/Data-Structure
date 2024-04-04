package com.vipin.algorithm.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class EveluateExpressionWithPrecedence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EveluateExpressionWithPrecedence e = new EveluateExpressionWithPrecedence();
		System.out.println(e.solve("a+b*(c^d-e)^(f+g*h)-i"));
		
	}
	
	public String solve(String A) {
        Map<Character, Integer>precedence = new HashMap<Character, Integer>();
        precedence.put('+',1);precedence.put('-',1);	// "a+b*(c^d-e)^(f+g*h)-i"
        precedence.put('*',2);precedence.put('/',2);
        precedence.put('^',3);precedence.put('(',-1);
        StringBuilder ans = new StringBuilder();
        Stack<Character>st = new Stack<Character>();
        int N = A.length();
        for(int i=0; i<N; i++) {
            char temp = A.charAt(i);
            if(Character.isAlphabetic(temp)) {
                ans.append(temp);
            } else if(temp=='(') {
                st.push(temp);
            } else if(temp==')') {
                while(st.peek()!='(') {
                    ans.append(st.pop());
                }
                st.pop();
            } else {
                if(st.isEmpty()) {
                    st.push(temp);
                } else {
                    // Secret is:- In STACK do not place operator on top of high precedence operator
                    // i.e. placing * on top of ^
                    // Store ( in map because in stack we can get it but it's precedence would be minimum
                    int precIncoming = precedence.get(temp);
                    int precTop = precedence.get(st.peek());
                    while(precTop>=precIncoming) {
                        ans.append(st.pop());
                        if(st.isEmpty()) {
                            precTop = -1;
                        } else {
                            precTop = precedence.get(st.peek());
                        }
                    }
                    st.push(temp);
                }
            }
        }
        while(!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.toString();
    }

}
