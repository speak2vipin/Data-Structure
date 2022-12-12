package com.vipin.algorithm.string;

import java.util.ArrayList;
import java.util.List;

public class WordsSubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"amazon","apple","facebook","google","leetcode"};
		String[] b = {"e","o"};
		for(String s : wordSubsets(a, b)) {
			System.out.println(s);
		}

	}
	
	
	public static List<String> wordSubsets(String[] words1, String[] words2) {
		List<String> resultList = new ArrayList<String>();
        int [][]word1Array = new int[words1.length][];
        int [][]word2Array = new int[words2.length][];
        for(int i=0; i<words1.length;i++) {
            int [] res = countArray(words1[i]);
            word1Array[i] = res;
        }
        for(int i=0; i<words2.length;i++) {
            int [] res = countArray(words2[i]);
            word2Array[i] = res;
        }
        for(int i =0;i<word1Array.length;i++) {
        	int [] temp1 = word1Array[i];
        	boolean isOK = false;
            for(int j=0;j<word2Array.length;j++) {
                int [] temp2 = word2Array[j];
                for(int k =0; k<26;k++) {
                	if(temp1[k]>=temp2[k]) {
                		if(k==25) {
                			isOK = true;
                		}
                		continue;
                	} else {
                		isOK = false;
                		break;
                	}
                }
                if(!isOK) {
                	break;
                }
            }
            if(isOK) {
            	resultList.add(words1[i]);
            }
        }
        return resultList;
        
    }
    
    static int[] countArray(String s) {
        int charA[] = new int[26];
        for(char c : s.toCharArray()) {
            charA[c-'a'] += 1; 
        }
        return charA;
    }

    public List<String> wordSubsets(String[] A, String[] B, boolean flag) {
        int[] count = new int[26], tmp;
        int i;
        for (String b : B) {
            tmp = counter(b);
            for (i = 0; i < 26; ++i)
                count[i] = Math.max(count[i], tmp[i]);
        }
        List<String> res = new ArrayList<>();
        for (String a : A) {
            tmp = counter(a);
            for (i = 0; i < 26; ++i)
                if (tmp[i] < count[i])
                    break;
            if (i == 26) res.add(a);
        }
        return res;
    }

    int[] counter(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) count[c - 'a']++;
        return count;
    }
    
    
    
    
    
}
