package com.vipin.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		letterCombinations("234");
	}

	public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a','b', 'c'});
        map.put('3', new char[]{'d','e', 'f'});
        map.put('4', new char[]{'g','h', 'i'});
        map.put('5', new char[]{'j','k', 'l'});
        map.put('6', new char[]{'m','n', 'o'});
        map.put('7', new char[]{'p','q', 'r', 's'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});
        
        int n = digits.length();
        int i = 0;
        
        Map<Integer, ArrayList<String>> temp = new HashMap<>();
        while(i<n) {
            if(i==0) {
                char val[] = map.get(digits.charAt(i));
                for(char v : val) {
                    temp.computeIfAbsent(i, val1-> new ArrayList<String>()).add(v+"");
                }
            } else {
                char val[] = map.get(digits.charAt(i));
                for(char v : val) {
                	ArrayList<String> store = temp.get(i-1);
	                for(String s : store) {
	                	temp.computeIfAbsent(i, val1-> new ArrayList<String>()).add(s+v);
	                }
                }
            }
            i++;
        }
        
        
        return temp.get(n-1);
    }
}
