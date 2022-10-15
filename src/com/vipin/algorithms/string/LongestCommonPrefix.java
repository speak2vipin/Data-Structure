package com.vipin.algorithms.string;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []s1 = {"flower","flcr","flwl"};
		System.out.println(longestCommonPrefix(s1));
	}
	
	public static String longestCommonPrefix(String[] strs) {
       /* String result = "";
        int charArray [] = new int[26];
        char[]alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
                         'o','p','q','r','s','t','u','v','w','x','y','z'};
        for(String s : strs) {
            for(int i=0;i<s.length();i++) {
                char c = s.charAt(i);
                if(s.indexOf(c)==i)
                	charArray[c-'a']=charArray[c-'a']+1;
            }
        }
        for(int j = 0; j<26;j++) {
            if(charArray[j]==strs.length) {
                result+=alphabet[j];
            }
        }
        return result;
    }*/
		 List<Integer>nodeVal = new ArrayList<Integer>();
		 nodeVal.contains(5);
		
		String result = "";

		char temp;
		for (int i = 0; i < strs[0].length(); i++) {
		temp = strs[0].charAt(i);	;
					for (int j = 1; j < strs.length; j++) {
						if (i<strs[j].length() && strs[j].charAt(i) == temp) {
							if (j == strs.length - 1) {
								result = result + temp;
							}
						} else {
							return result;
						}
					}
				}


		return result;

	}
}
