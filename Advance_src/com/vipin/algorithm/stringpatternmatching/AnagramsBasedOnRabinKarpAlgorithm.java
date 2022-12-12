package com.vipin.algorithm.stringpatternmatching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class AnagramsBasedOnRabinKarpAlgorithm {

	static HashSet<Integer> set = new HashSet<Integer>();
    static int[] freq = new int[26];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []A = {"bee", "cde"};
		int ans[][] = anagrams(A);
		for(int[] x : ans) {
			System.out.println(x);
		}

	}
	
	public static int[][] anagrams(final String[] A) {
        int N = A.length;
        Map<Integer, List<Integer>> anagramsMap = new HashMap<Integer, List<Integer>>();
        createHash();
        for(int i=0; i<N; i++) {
            int hashcode = hashcode(A[i]);
            if(anagramsMap.get(hashcode)==null) {
                List<Integer> list = new ArrayList<Integer> ();
                list.add(i);
                anagramsMap.put(hashcode, list);
            } else {
                anagramsMap.get(hashcode(A[i])).add(i);
            }
        }
        int size = anagramsMap.size();
        int ans[][] = new int[size][];
        int i=0;
        for(List<Integer> l : anagramsMap.values()) {
        	if(!l.isEmpty()) {
        		int temp[] = new int[l.size()];
        		int j = 0;
        		for(int val : l) {
        			temp[j] = val+1;
        			j++;
        		}
        		ans[i] = temp;
        		i++;
        	}	
        }
        return ans;
    }

    static int hashcode(String S) {
        int hashcode = 0;
        for(int i=0; i<S.length(); i++) {
            hashcode += freq[S.charAt(i) - 'a'];
        }
        return hashcode;
    }
    
    //To create the Hash number for every character between a-z using Random function.
    static void createHash()
    {
        int min = 1;
        int max = 1000;
        int range = max-min+1;
        for(int i=0; i<26; i++)
        {
            int value = (int)(Math.random()*range);
            //0.8627501478624818
            //0.4799937277131813
            //0.3276598932319609
            while(set.contains(value))
            {
                value = (int)(Math.random()*range);
            }
            freq[i] = value;
            set.add(value);
        }
    }

}
