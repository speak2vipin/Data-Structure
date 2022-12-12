package com.vipin.algorithm.string;

public class MaximumSubstringPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("aaaabaaa"));
	}
	
	public static String longestPalindrome(String A) {
		String ans = A.substring(0,1);
        for(int i=0; i<A.length();i++) {
             String oddS = palindrome(A,i-1, i+1);
             String evenS = palindrome(A, i, i+1);

             if(ans.length()<oddS.length()) {
            	 ans = oddS;
             }
             if(ans.length()<evenS.length()) {
            	 ans = evenS;
             }
             
        }
        return ans;
    }

    static String palindrome(String A, int left, int right) {
    	boolean flag=false;
    	String ans = "";
        while(left>-1 && right<A.length()){
            if(A.charAt(left)==A.charAt(right)) {
            	flag = true;
                left--;
                right++;
            } else {
                break;
            }
        }
        if(flag) {
        	ans = A.substring(left+1, right);
        }
        return ans;
    }

}
