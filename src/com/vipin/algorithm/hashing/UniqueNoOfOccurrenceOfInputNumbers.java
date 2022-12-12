package com.vipin.algorithm.hashing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UniqueNoOfOccurrenceOfInputNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> arrMap = new HashMap<Integer, Integer>();
        for(int temp : arr) {
            arrMap.put(temp, arrMap.getOrDefault(temp, 0)+1);
        }
        Set<Integer> arrSet = (Set<Integer>)arrMap.values();
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        if(arrMap.size()==arrSet.size()) {
        	return true;
        }
        return false;   
    }
}
