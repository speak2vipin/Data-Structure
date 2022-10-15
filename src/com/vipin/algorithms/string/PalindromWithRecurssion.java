package com.vipin.algorithms.string;

public class PalindromWithRecurssion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrom("NAMAN"));
	}
	
	static boolean isPalindrom(String s) {
		int N = s.length();
		if(N==1) {
			return true;
		}
		/*if(s.charAt(0)==s.charAt(N-1)) {
			return isPalindrom(s.substring(1,N-1));
		} else {
			return false;
		}*/
		//Or
		if(s.charAt(0)==s.charAt(N-1) && isPalindrom(s.substring(1,N-1))){
			return true;
		}
		return false;		
	}

	public int solve(String A) {
        int N = A.length()-1;
        return solve(A, 0, N) ? 1 : 0;
    }

    boolean solve(String S, int l, int r) {
        if(l>=r) {
            return true;
        }
        return S.charAt(l)==S.charAt(r) && solve(S, l+1, r-1);
    }
}
