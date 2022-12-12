package com.vipin.algorithm.string;

import java.util.Arrays;

public class LexigraphicalSmallerString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("codility"));
		System.out.println(solution("cat"));
		System.out.println(solution("hot"));
		System.out.println(solution("aaaa"));

	}
	
	public static String solution(String S) {
        // write your code in Java SE 8
        String ans = "";
        int N = S.length();
        char[] temp = S.toCharArray();
        Arrays.sort(temp);
        char remove = '\u0000';
        for(int i=0; i<N; i++) {
            if(temp[i]!=S.charAt(i)) {
                remove = S.charAt(i);
                break;
            }
        }
        if(remove=='\u0000') {
        	return S.substring(0,N-1);
        }
        for(int i=0; i<N; i++) {
            if(S.charAt(i) != remove) {
                ans += S.charAt(i);
            }
        }
        return ans;
    }

}
