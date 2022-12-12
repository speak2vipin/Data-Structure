package com.vipin.algorithm.string;

public class ImplementStrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("hello", "ll"));
	}
	
	static public int strStr(String haystack, String needle) {
        if(needle!=null && needle.length()==0) {
            return 0;
        } else {
            if(haystack.contains(needle)) {
                return haystack.indexOf(needle);
            } else {
                return -1;
            }
        }
        //return -1;
        
    }

}
