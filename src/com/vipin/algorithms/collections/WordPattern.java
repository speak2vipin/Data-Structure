package com.vipin.algorithms.collections;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String pattern = "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"
				+ "ccccccccccccccccccccccccccccccccccccccdd";
		String s = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s "
				+ "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s "
				+ "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s "
				+ "s t t";
		System.out.println(wordPattern(pattern,s));
	}
	
	public static boolean wordPattern(String pattern, String s) {  
        int N = pattern.length();
        String[] str = s.split(" ");
        int size = str.length;
        if(N!=size) {
            return false;
        }
        
        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();
        for(int i=0;i<N;i++) {
            if(map1.put(pattern.charAt(i),i) == (map2.put(str[i], i)) 
            		|| map1.put(pattern.charAt(i),i).intValue() == map2.put(str[i], i).intValue()) {
                
            } else {
            	//System.out.println(map1.put(pattern.charAt(i), i) + " " +map2.put(str[i], i));
                return false;
            }
        }
        return true;
        
        
    }

}
