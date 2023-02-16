package com.vipin.algorithm.hashing;

import java.util.HashMap;
import java.util.Map;

public class PatternMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "abba";
		String s = "dog cat cat fish";
		System.out.println(wordPattern(pattern, s));
	}
	
	public static boolean wordPattern(String pattern, String s) {
	       
        Map<String, Character> map = new HashMap();
        String words[] = s.split(" ");
        int l = words.length;
        for(int i=0; i<l; i++) {
            String temp = words[i];
            char tempChar = pattern.charAt(i);
            if(map.get(temp) == null) {
                if(map.values().contains(tempChar)) {
                    return false;
                }
                map.put(temp,tempChar);
            } else {
                if(map.get(temp) == tempChar) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }

}
