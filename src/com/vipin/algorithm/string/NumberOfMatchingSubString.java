package com.vipin.algorithm.string;

public class NumberOfMatchingSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String words[] = { "ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
		System.out.println(numMatchingSubseq("dsahjpjauf",words));
		
	

	}

	 public static int numMatchingSubseq(String s, String[] words) {
	        int lastIndex = -1;
	        String sTemp = s;
	        int count = 0;
	        for(String s1 : words) {
	            for(int i=0; i<s1.length();i++) {
	                int charIndex = sTemp.indexOf(s1.charAt(i));
	                if(charIndex == -1) {
	                    break;
	                } else {
	                	sTemp = sTemp.substring(charIndex+1);
	                }
	                if(i==s1.length()-1) {
	                    count++;
	                }
	            }
	            lastIndex = -1;
	            sTemp = s;
	        }
	        return count;
	    }
}
