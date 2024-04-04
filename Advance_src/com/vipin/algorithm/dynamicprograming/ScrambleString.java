package com.vipin.algorithm.dynamicprograming;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "great", s2 = "rgeat";
		ScrambleString s = new ScrambleString();
		boolean ans = s.isScramble1(s1, s2);
		
		System.out.println(ans);
	}

	Map<String, Boolean> mp = new HashMap<>();

	public boolean isScramble(String s1, String s2) {
		int n = s1.length();
		System.out.println(s1 + " " + s2);
		if (s1.equals(s2))
			return true;
		if (n == 1)
			return false;

		String key = s1 + " " + s2;

		if (mp.containsKey(key))
			return mp.get(key);
		
		for (int i = 1; i < n; i++) {
			if (isScramble(s1.substring(0, i), s2.substring(0, i)) 
					&& isScramble(s1.substring(i), s2.substring(i))) {
				mp.put(key, true);
				return true;
			}

			if (isScramble(s1.substring(0, i), s2.substring(n - i))
					&& isScramble(s1.substring(i), s2.substring(0, n - i))) {
				mp.put(key, true);
				return true;
			}
		}

		mp.put(key, false);
		return false;
	}
	
	public boolean isScramble1(String s1, String s2) { Map<String, Boolean> map = new HashMap<>();
    int N = s1.length();
    if(s2.length()!=N) {
        return false;
    }
    if(s1.equals(s2)) {
        return true;
    }
    if(N==1) {
        return false;
    }
    String key = s1 + " " + s2;
    if (map.containsKey(key)) {
		return map.get(key);
    }
    for(int i=1; i<N; i++) {
        if(isScramble(s1.substring(0, i), s2.substring(0,i)) && 
           isScramble(s1.substring(i), s2.substring(i))) {
            map.put(key, true);
            return true;
        } 
        if(isScramble(s1.substring(0, i), s2.substring(N-i)) && 
           isScramble(s1.substring(i), s2.substring(0,N-i))) {
            map.put(key, true);
            return true;
        }
    }
    map.put(key, false);
    return false;}

}
