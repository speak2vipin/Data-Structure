package com.vipin.algorithm.hashing;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "cvz";
		String B = "xyy";
		System.out.println(solve(A, B));

	}
	
	public static int solve(String A, String B) {
        int N = A.length();
        if(N != B.length()) {
            return 0;
        }
        Map<Character, Character> map = new HashMap<Character, Character> ();
        char aTemp = '\u0000';
        char bTemp = '\u0000';
        for(int i=0; i<N; i++) {
        	aTemp = A.charAt(i);
        	bTemp = B.charAt(i);
            if(map.get(aTemp)==null) {
            	if(map.values().contains(bTemp)) {
            		return 0;
            	}
                map.put(aTemp, bTemp);
            } else {
                if((char)(map.get(aTemp)) != bTemp) {
                    return 0;
                }
            }
        }
        return 1;
	}

}
