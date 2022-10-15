package com.vipin.algorithms.string;

import java.util.*;

public class StringToSubstringPalindromePartioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<String>> partition(String s) {
        int N = s.length();
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        for(int i=0; i<N;i++) {
            list.add(s.charAt(i)+"");
        }
        res.add(list);
        for(int i=0; i<N-1;i++) {
            List<String> list1 = new ArrayList<String>();
            String s1 = palindromeSubstring(s, i, i+1,N);
            String s2 = palindromeSubstring(s, i-1, i+1, N);
            if(s1.length()>s2.length()) {
                list1.add(s1);
            } else if(s2.length()>s1.length()) {
                list1.add(s2);
            }
            if(list1.size()>0) {
                res.add(list1);
            }
            
        }
        
        
    }
    String palindromeSubstring(String s, int left, int right, int len) {
        while(left>-1 && right<len) {
            if(s.charAt(left)==s.charAt(right)) {
                left--;
                right++;
            } else {
                return "";
            }
        }
        return s.substring(left, right+1);
    }

    public List<List<String>> partitionL(String s) {
        
        List<List<String>> resultLst;
	    ArrayList<String> currLst;
	    public List<List<String>> partition(String s) {
	        resultLst = new ArrayList<List<String>>();
	        currLst = new ArrayList<String>();
	        backTrack(s,0);
	        return resultLst;
	    }
	    public void backTrack(String s, int l){
	        if(currLst.size()>0 //the initial str could be palindrome
	            && l>=s.length()){
	                List<String> r = (ArrayList<String>) currLst.clone();
	                resultLst.add(r);
	        }
	        for(int i=l;i<s.length();i++){
	            if(isPalindrome(s,l,i)){
	                if(l==i)
	                    currLst.add(Character.toString(s.charAt(i)));
	                else
	                    currLst.add(s.substring(l,i+1));
	                backTrack(s,i+1);
	                currLst.remove(currLst.size()-1);
	            }
	        }
	    }
	    public boolean isPalindrome(String str, int l, int r){
	        if(l==r) return true;
	        while(l<r){
	            if(str.charAt(l)!=str.charAt(r)) return false;
	            l++;r--;
	        }
	        return true;
	    }
}
