package com.vipin.algorithm.basic;

public class MergeAlternatelyTwoStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word1 = "ab", word2 = "pqrs";
		MergeAlternatelyTwoStrings m = new MergeAlternatelyTwoStrings();
		System.out.println(m.mergeAlternately(word1, word2));
		
		
	}
	public String mergeAlternately(String word1, String word2) {
		int l1 = word1.length();
        int l2 = word2.length();
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        int j = 0;
        boolean flag = true;
        
        while (l1>i && l2>j) {
        	if(flag) {
                sb.append(word1.charAt(i++));
            } else {
                sb.append(word2.charAt(j++));
            }
        	flag = !flag;			
		}
        while(l1>i) {
            sb.append(word1.charAt(i++));
        } 
        while(l2>j) {
            sb.append(word2.charAt(j++));
        }
        return sb.toString(); 
    }

}
