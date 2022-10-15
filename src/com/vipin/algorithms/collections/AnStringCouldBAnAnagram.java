package com.vipin.algorithms.collections;

import java.util.HashSet;
import java.util.Set;

public class AnStringCouldBAnAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("abcab"));
		System.out.println(solve("ababab"));
		System.out.println(solve("abcdef"));

	}
	
	 public static int solve(String A) {
	        Set<Character> set = new HashSet<Character>();
	        for(int i=0;i<A.length();i++) {
	            char c = A.charAt(i);
	        	if(!set.add(c)) {
	                set.remove(c);
	            }
	        }
	        if(A.length()%2==0 && set.size()==0) {
	        	return 1;
	        } else if(A.length()%2==1 && set.size()==1) {
	        	return 1;
	        } else {
	        	return -1;
	        }
	    }

}
