package com.vipin.algorithm.string;

public class DetectCapitalLetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean detectCapitalUse(String word) {
        int L = word.length();
        if(L==1) {
            return true;
        }
        boolean firstSmallLetter = ((word.charAt(0)>>5) & 1) == 1;
        boolean secondSmallLetter = ((word.charAt(1)>>5) & 1) == 1;
        for(int i=2; i<L; i++) {
            if(firstSmallLetter && secondSmallLetter 
               && ((word.charAt(i)>>5) & 1) == 1) {
                continue;
            } else if(!firstSmallLetter && secondSmallLetter 
                      && ((word.charAt(i)>>5) & 1) == 1) {
                continue;
            } else if(!firstSmallLetter && !secondSmallLetter 
                      && !(((word.charAt(i)>>5) & 1) == 1)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

}
