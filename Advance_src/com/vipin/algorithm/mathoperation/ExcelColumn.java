package com.vipin.algorithm.mathoperation;

import java.util.PriorityQueue;

public class ExcelColumn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle(701));
		System.out.println(reorganizeString("aabbcc"));
		System.out.println(reorganizeString("aaa"));
		System.out.println(reorganizeString("aaab"));
	}
	
	public static String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while(columnNumber>0) {
            int mod = (columnNumber-1)%26;
            
            res.append((char)(65+mod));
            
            
            columnNumber = (columnNumber-1)/26;
        }
        return res.reverse().toString();
    }
	
	public static String reorganizeString(String s) {
		PriorityQueue<int[]>pq = new PriorityQueue<>((x,y)->y[0]-x[0]);
        int array[] = new int[26];
        int n = s.length();
        for(int i=0; i<n; i++) {
            array[s.charAt(i)-'a'] = array[s.charAt(i)-'a']+1;
        }
        for(int i=0; i<26; i++) {
        	if(array[i]!=0)
        		pq.offer(new int[] {array[i], i});
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
        	int top1[] = pq.poll();
        	if(pq.isEmpty()) {
        		if(top1[0]>1) {
        			return "";
        		} else {
        			sb.append((char)(top1[1]+'a'));
        			break;
        		}	
        	}
        	int top2[] = pq.poll();
        	int x = top1[0];
        	int y = top2[0];
        	sb.append((char)(top1[1]+'a')).append((char)(top2[1]+'a'));
        	
        	if(--x>0) {
        		pq.offer(new int[]{x, top1[1]});
        	}
        	if(--y>0) {
        		pq.offer(new int[]{y, top2[1]});
        	}
        }
        return sb.toString();
         
    }
	
	
	public bool IsInterleave(string s1, string s2, string s3) {
        if (s1.Length + s2.Length != s3.Length) {
            return false;
        }

        bool[,] dp = new bool[s1.Length + 1, s2.Length + 1];
        dp[s1.Length, s2.Length] = true;

        for (int i = s1.Length; i >= 0; i--) {
            for (int j = s2.Length; j >= 0; j--) {
                if (i < s1.Length && s1[i] == s3[i + j] && dp[i + 1, j]) {
                    dp[i, j] = true;
                }
                if (j < s2.Length && s2[j] == s3[i + j] && dp[i, j + 1]) {
                    dp[i, j] = true;
                }
            }
        }
        return dp[0, 0];
    }

}
/*
 * class Solution { public String reorganizeString(String s) { var charCounts =
 * new int[26]; for (char c : s.toCharArray()) { charCounts[c - 'a'] =
 * charCounts[c - 'a'] + 1; }
 * 
 * // Max heap ordered by character counts var pq = new PriorityQueue<int[]>((a,
 * b) -> Integer.compare(b[1], a[1])); for (int i = 0; i < 26; i++) { if
 * (charCounts[i] > 0) { pq.offer(new int[] {i + 'a', charCounts[i]}); } }
 * 
 * var sb = new StringBuilder(); while (!pq.isEmpty()) { var first = pq.poll();
 * if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
 * sb.append((char) first[0]); if (--first[1] > 0) { pq.offer(first); } } else {
 * if (pq.isEmpty()) { return ""; }
 * 
 * var second = pq.poll(); sb.append((char) second[0]); if (--second[1] > 0) {
 * pq.offer(second); }
 * 
 * pq.offer(first); } }
 * 
 * return sb.toString(); } }
 */