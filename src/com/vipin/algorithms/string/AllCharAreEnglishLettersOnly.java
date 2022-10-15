package com.vipin.algorithms.string;

public class AllCharAreEnglishLettersOnly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

    public int solve(char[] A) {
        for(char c : A) {
            if(!((c>64 && c<91) || (c>96 && c<123))) {
                return 0;
            }
        }
        return 1;
    }

}
