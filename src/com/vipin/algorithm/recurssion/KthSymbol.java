package com.vipin.algorithm.recurssion;

public class KthSymbol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(2,1));
		System.out.println(solve(2,2));

	}

	public static int solve(int A, int B) {
		String ans = getString(A, "0");
		System.out.println(ans);
		return (ans.length() >= B - 1 ? ans.charAt(B - 1) - '0' : -1);
	}

	static String getString(int A, String s) {
		if (A == 0) {
			return s;
		}
		int i = 0;
		while (i < s.length()) {
			if (s.charAt(i) == '0') {
				s = s.substring(0, i) + "01" + s.substring(i + 1);
			} else if (s.charAt(i) == '1') {
				s = s.substring(0, i) + "10" + s.substring(i + 1);
			}
			i = i + 2;
		}
		return getString(A - 1, s);
	}
	
	
	if (N == 0 || K == 0) {
        return 0;
    }
     
    /* int x = solve(N - 1, K / 2);

    if ((K & 1) == 0) {
        return x ;
    } else {
        return 1 - x;
    }
   */
    int x;
    if ((K & 1) == 0) { // even or odd
        x = solve(N - 1, K / 2) == 0 ? 1 : 0;
    } else {
        x = solve(N - 1, (K + 1) / 2);
    }
    return x;

}
