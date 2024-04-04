package com.vipin.algorithm.string;

public class TwoEqualArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1[] = {"ab", "c"};
		String s2[] = {"a", "bc"};
		//System.out.println(arrayStringsAreEqual(s1, s2));
		System.out.println(Boolean.FALSE.equals(null));
	}
	
	public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();  
        StringBuilder sb2 = new StringBuilder();  
        for(String word : word1) {
            sb1.append(word);
        }
        for(String word : word2) {
            sb2.append(word);
        }
        
        return sb1.toString().equals(sb2.toString());
    }

}
