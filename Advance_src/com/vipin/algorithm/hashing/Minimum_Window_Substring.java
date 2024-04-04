package com.vipin.algorithm.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Minimum_Window_Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ADOBECODEBANC";
		String t = "ABC";

		// System.out.println(minWindow(s, t));
		String[] st = { "nat", "tan" };
		groupAnagrams(st);
		frequencySort("Aaab");
		

	}

	public static String minWindow(String s, String t) {
		int m = s.length();
		int n = t.length();
		if (m < n) {
			return "";
		}
		int freq[] = new int[128];

		int characters = 0;
		for (int i = 0; i < n; i++) {
			freq[t.charAt(i)]++;
			characters++;
		}
		int st = 0;
		int en = 0;
		int start_index = 0;
		int min_length = Integer.MAX_VALUE;

		while (en < m) {
			if (freq[s.charAt(en)] > 0) {
				freq[s.charAt(en)]--;
				characters--;
			}
			while (characters == 0) {
				if (min_length > en - st + 1) {
					min_length = en - st + 1;
					start_index = st;
				}
				st++;
			}
			en++;
		}
		// return (start==-1 || endString==-1) ? "" :
		// s.substring(start, endString+1);
		return null;
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> anagrams = new HashMap<>();
		for (String s : strs) {
			String t = new String(s);
			char l[] = s.toCharArray();
			Arrays.sort(l);
			anagrams.computeIfAbsent(new String(l), val -> new ArrayList<String>()).add(t);
		}
		List<List<String>> result = new ArrayList<>();
		for (String key : anagrams.keySet()) {
			result.add(anagrams.get(key));
		}
		return result;
	}

	public static String frequencySort(String s) {
		int temp[][] = new int[128][];
		for (int t[] : temp) {
			t = new int[] { -1, 0 };
		}
		for(int i=0; i<128; i++) {
			temp[i] = new int[] {-1,0};
		}
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'A';
			temp[index][0] = index;
			temp[index][1]++;
		}
		Arrays.sort(temp, (x, y) -> (y[1] - x[1]));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 128; i++) {
			if (temp[i][0] != -1) {
				for(int j=0; j<temp[i][1]; j++) {
					sb.append((char) ('A' + temp[i][0]));
				}
			}
		}
		return sb.toString();
	}

}
