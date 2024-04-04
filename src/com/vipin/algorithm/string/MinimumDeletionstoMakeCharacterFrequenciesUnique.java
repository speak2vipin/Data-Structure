package com.vipin.algorithm.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MinimumDeletionstoMakeCharacterFrequenciesUnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bbcebab";
		MinimumDeletionstoMakeCharacterFrequenciesUnique m = new MinimumDeletionstoMakeCharacterFrequenciesUnique();
		System.out.println(m.minDeletions(s));

	}

	int count = 0;

	public int minDeletions(String s) {
		Map<Character, Integer> freqMap = new HashMap<>();
		int freq[] = new int[26];
		int n = s.length();
		int index = 0;
		char c = '\u0000';
		for (int i = 0; i < n; i++) {
			c = s.charAt(i);
			index = c - 'a';
			freq[index]++;
			freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
		}
		for (int i = 0; i < 26; i++) {
			if (freq[i] != 0) {
				// nextIndex(i, freq);
			}
		}
		calculateLettersToDelete(freq);
		return count;
	}

	void nextIndex(int index, int freq[]) {
		boolean flag = false;
		for (int i = 0; i < 26; i++) {
			if (index != i && freq[index] != 0 && freq[i] == freq[index]) {
				flag = true;
				break;
			}
		}
		if (flag) {
			count++;
			freq[index]--;
			nextIndex(index, freq);

		}
	}

	void calculateLettersToDelete(int freq[]) {
		HashSet<Integer> uniqueFreq = new HashSet<>();
		for (int i = 0; i < 26; i++) {
			while (freq[i] != 0 && uniqueFreq.contains(freq[i])) {
				freq[i]--;
				count++;
			}
			uniqueFreq.add(freq[i]);
		}
	}
}
