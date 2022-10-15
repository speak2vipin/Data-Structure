package com.vipin.algorithms.string;

public class OperationOnString {
	public static void main(String[] args) {
		StringBuilder s = new StringBuilder();
		System.out.println(s.toString()); 
		System.out.println(solve("AbcaZeoB"));
	}
	
	public static String solve(String A) {
        StringBuilder s = new StringBuilder(A);
        A = s.append(A).toString();
        s = new StringBuilder();
        char c;
        for(int i=0;i<A.length();i++) {
        	c = A.charAt(i);
        	if(!(c>64 && c<91)) {
        		if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
        			s.append('#');
        		} else {
        			s.append(c);
        		}
        	}
        }
        return s.toString();
        
    }
}
