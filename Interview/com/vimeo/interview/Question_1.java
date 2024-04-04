package com.vimeo.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Question_1 {

	/**
	* Check if a string is properly balanced with brackets
	* Examples
	* isBalanced("[a]") => true
	* isBalanced("[a])") => false
	* isBalanced("[a](check this out)") => true
	*/
	
	// ()
	//[(])	-> False;
	
	// {[}
	// {[]}
	// { , [, (
	// push to stack
	// }, ], )
		// Pop from stack
		// { }
		// [ ]
		// ( )
	// : ;
	// 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		String s = "[()]{}{[()()]()}";
		System.out.println(isBalanced(s));
	
	}
	
	static Map<Character, Character> mapping = new HashMap<>();
	//[{}]
	static boolean isBalanced(String input) {
		mapping.put(')', '(');
		mapping.put('}', '{');
		mapping.put(']', '[');
		
		int N = input.length();
		int i=0;
		Stack<Character> st = new Stack<>();
		while(i<N) {
			char temp = input.charAt(i);
			if(mapping.keySet().contains(temp) || mapping.values().contains(temp)) {
				if(mapping.get(temp)==null) {	
					st.push(temp);
				} else {
					if(st.isEmpty()) {
						return false;
					}
					char last = st.peek();
					if(last!=mapping.get(temp)) {	
						return false;
					}
					st.pop();
				}
			}
			i++;
		}
		return st.isEmpty()?true:false;
	}
	
	

}
