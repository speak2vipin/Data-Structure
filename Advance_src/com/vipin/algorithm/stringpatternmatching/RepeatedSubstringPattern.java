package com.vipin.algorithm.stringpatternmatching;

public class RepeatedSubstringPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(repeatedSubstringPattern("abab"));
		String s = "hqghumeaylnlfdxf";
		int B[] = {0,1,0,1,0,0,1,0,0,1,0,0,1,1,0,1,0,1,0,1,1,1,0,1,1,0};
		int C = 14;
		System.out.println(solve(s, B, C));
		System.out.println(divide(11,10,3));

	}

	public static boolean repeatedSubstringPattern(String str) {
		String s = str + str;
		return s.substring(1, s.length() - 1).contains(str);
	}

	public static int solve(String A, int[] B, int C) {
		int N = A.length();
		int L = 0;
		int R = 0;
		int countC = 0;
		int ans = 0;

		while (R < N) {
			if (B[A.charAt(R) - 'a'] == 1) {
				countC++;
			}
			if (countC == C) {
				ans = Math.max(ans, R - L + 1);
				//System.out.println(ans);
				R++;
			} else if (countC < C) {
				R++;
			} else if (countC > C) {
				if (B[A.charAt(L) - 'a'] == 1) {
					countC--;
				}
				if (B[A.charAt(R) - 'a'] == 1) {
					countC--;
				}
				L++;
			}
		}
		return ans;
	}
	
	static int divide(int X, int A, int B) {
        int i=0;
  
        int count = 0;
        while(X>(Math.pow(A,i)+Math.pow(B,0))) {
            count++;
            int j=1;
            while(X>(Math.pow(A,i)+Math.pow(B,j))) {
                count++;
                j++;
            }
            i++;
        }
        return count;
    }
}