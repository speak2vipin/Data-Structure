package com.vipin.algorithms.string;

public class AllCharAreAlphNumericLettersOnly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((int)'9');
	}
	
	public int solve(char[] A) {
        for(char c: A) {
            if(!((c>64 && c<91) || (c>96 && c<123) || (c>47 && c<58))) {
                return 0;
            }
        }
        return 1;
    }

}
