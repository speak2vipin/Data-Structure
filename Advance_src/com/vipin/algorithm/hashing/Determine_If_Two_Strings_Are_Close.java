package com.vipin.algorithm.hashing;

import java.util.HashMap;

public class Determine_If_Two_Strings_Are_Close {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aaabbbbccddeeeeefffff";
		String s2 = "aaaaabbcccdddeeeeffff";
		System.out.println(closeStrings(s1, s2));
	}
	
	public static boolean closeStrings(String word1, String word2) {
        int N1 = word1.length();
        int N2 = word2.length();
        
        if(N1!=N2) {
            return false;
        }
        
        HashMap<Character, Integer> freqMap1 = new HashMap<>();
        HashMap<Character, Integer> freqMap2 = new HashMap<>();
        
        for(int i=0; i<N1; i++) {
            freqMap1.put(word1.charAt(i), freqMap1.getOrDefault(word1.charAt(i), 0)+1);
        }
        
        for(int i=0; i<N2; i++) {
            freqMap2.put(word2.charAt(i), freqMap2.getOrDefault(word2.charAt(i), 0)+1);
        }
        if(!freqMap1.keySet().containsAll(freqMap2.keySet()) && !freqMap2.keySet().containsAll(freqMap1.keySet())) {
            return false;
        }
        
        for(Integer c : freqMap1.values()) {
        	if(freqMap2.values().contains(c)) {
        		
        	}
        }
        
        return true;
    }

}



