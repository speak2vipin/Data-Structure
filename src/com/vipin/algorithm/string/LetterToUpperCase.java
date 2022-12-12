package com.vipin.algorithm.string;

public class LetterToUpperCase {
	
	public static void main(String[] args) {
		char[]c = {'a','b'};
		System.out.println(to_upper(c)[0]);
		
		
	}
	
	public static char[] to_upper(char[] A) {
        char c;
        for(int i=0; i<A.length;i++) {
            c = A[i];
            if(c>96 && c<123) {
                A[i] = (char)(A[i]^1<<5);
            }
        }
        return A;
    }

}
