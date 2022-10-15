package com.vipin.algorithms.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class LargestSubArrayWithContigousElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int A[] = { 4, 6, 2, 4, 1, 3, 9 };
		int A[] = {8, 8, 10, 11, 9, 13};
		//int A[] = { 1,1,2,3,5,6 };
		//System.out.println(solve(A));
		String [] words = {"gin","zen","gig","msg"};
		LargestSubArrayWithContigousElement l = new LargestSubArrayWithContigousElement();
		System.out.println(l.uniqueMorseRepresentations(words));

	}

	public static int solve(int[] A) {
		int N = A.length;
		int len = -1;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				List<Integer>temp = new ArrayList<Integer>();
				boolean flag = false;
				for (int k = i; k < j+1; k++) {
					temp.add(A[k]);
				}
				Collections.sort(temp);
				for(int k=0; k<temp.size()-1; k++) {
					if(temp.get(k+1)-temp.get(k)!=1) {
						flag = true;
					}
				}
				if(!flag) {
					len = Math.max(len, j-i+1);
				}	
			}
		}
		return len;
	}
	String code[] = { ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",
    		".-.","...","-","..-","...-",".--","-..-","-.--","--.." };
	public int uniqueMorseRepresentations(String[] words) {
        
        Set<String>transformations = new HashSet<String>();
        for(String s : words) {
        	transformations.add(formCode(s));
        }
        return transformations.size();
    }
	
	String formCode(String s) {
		String result = "";
		for(int i=0; i<s.length();i++) {
			result+=code[s.charAt(i)-'a'];
		}
		return result;
	}
	
	public long solve(int A, int B, int C) {
        long Ans = 1;
        for(int i=0; i<B;i++) {
            Ans = Ans*A;
        }
        return Ans%C;
    }
	
	public int solve(String A) {
        if(A.length()>3) {
             A = A.substring(A.length()-3);  
        } 
        return Integer.parseInt(A)%8==0?1:0;
    }
	
	public int findMod(String A, int B) {
        long Ans = 0;
        int p = 1;
        int temp;
        for(int i=0;i<A.length();i++) {
            temp = Integer.parseInt(A.charAt(i)+"");
            Ans = (Ans + temp *p) % B;
            p = (p * 10) % B;
        }
        return (int)Ans;
    }
	
	
	public int minSetSize(int[] arr) {
		int n = arr.length;
		HashMap<Integer, Integer> cnt = new HashMap<>();
		for (int x : arr)
			cnt.put(x, cnt.getOrDefault(x, 0) + 1);

		int[] counting = new int[n + 1];
		for (int freq : cnt.values())
			++counting[freq];

		int ans = 0, removed = 0, half = n / 2, freq = n;
		while (removed < half) {
			ans += 1;
			while (counting[freq] == 0)
				--freq;
			removed += freq;
			--counting[freq];
		}
		return ans;
	}
	
	
	
	
}
