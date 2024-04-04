package com.vipin.algorithm.array;

import java.util.HashMap;
import java.util.Map;

public class SubstringWithKDifferentCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aba";
		System.out.println(substrCount(s, 2));
	}
	static long substrCount (String S, int K) {
        // your code here
        int characters[] = new int[26];
        int n = S.length();
        int index = -1;
        int count = 0;
        int res = 0;
        int i = 0;
        int j = 0;
        
        while(i<n && j<n) {
        	int bigCount = 0;
            while(i<n && count<=K) {
                index = S.charAt(i)-'a';
                if(characters[index]==0) {
                    count++;
                }
                if(count==K) {
                	bigCount++;
                }
                characters[index]++;
                i++;
            }
            while(j<i && count>=K) {
                index = S.charAt(j)-'a';
                if(characters[index]==1) {
                    count--;
                }
                if(count==K) {
                    res+=bigCount;
                }
                characters[index]--;
                j++;
            }
        }
        return res;
    }
	
	static long substrCount1 (String S, int K) {
        // your code here
        Map<Character, Integer> ib = new HashMap<>();
        Map<Character, Integer> is = new HashMap<>();
        int n = S.length();
        int res = 0;
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(true) {
            boolean flagb = false;
            boolean flags = false;
            boolean flagk = false;
            while(i<n) {
                flagb = true;
                char cur = S.charAt(i);
                ib.put(cur, ib.getOrDefault(cur, 0)+1);
                if(ib.size()>K) {
                    if(ib.get(cur)==1) {
                        ib.remove(cur);
                    } else {
                        ib.put(cur, ib.getOrDefault(cur, 0)-1);
                    }
                    break;
                }
                i++;
            }
            while(j<i) {
                flags = true;
                char cur = S.charAt(j);
                is.put(cur, is.getOrDefault(cur, 0)+1);
                if(is.size()==K) {
                    if(is.get(cur)==1) {
                        is.remove(cur);
                    } else {
                        is.put(cur, is.getOrDefault(cur, 0)-1);
                    }
                    break;
                }
                j++;
            }
            while(k<j) {
                flagk = true;
                if(ib.size()==K && is.size()==K-1) {
                    res += i-j;
                }
                char cur = S.charAt(k);
                if(is.get(cur)==1) {
                    is.remove(cur);
                } else {
                    is.put(cur, is.getOrDefault(cur, 0)-1);
                }
                if(ib.get(cur)==1) {
                    ib.remove(cur);
                } else {
                    ib.put(cur, ib.getOrDefault(cur, 0)-1);
                }
                if(ib.size()<K && is.size()<K-1){
                    break;
                }
                k++;
            }
            if(flagb == false && flags == false && flagk == false) {
                break;
            }
        }
        return res;
    }
}
