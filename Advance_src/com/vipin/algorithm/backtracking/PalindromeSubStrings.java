package com.vipin.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromeSubStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeSubStrings p = new PalindromeSubStrings();
		System.out.println(p.partition("aab"));
	}
	
	List<List<String>> result = new ArrayList<List<String>> ();
    public List<List<String>> partition(String s) {
        helper(0, s, new ArrayList<String>());
        return result;
        
    }
    
    void helper(int start, String s, List<String> currList )  {
        if(start>=s.length()) {
            result.add(new ArrayList<String>(currList));
            return;
        }
        for(int i=start; i<s.length(); i++) {
        	 if (isPalindrome(s, start, i)) {
                 // add current substring in the currentList
        		 currList.add(s.substring(start, i + 1));
                helper(start+1, s, currList);
                currList.remove(currList.size()-1);
            }
        }
    }
    
    boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }

}
