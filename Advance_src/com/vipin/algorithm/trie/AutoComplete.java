package com.vipin.algorithm.trie;

import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AutoComplete {

	public static void main(String[] args) {
		// YOUR CODE GOES HERE
		// Please take input and print output to standard input/output (stdin/stdout)
		// DO NOT USE ARGUMENTS FOR INPUTS
		// E.g. 'Scanner' for input & 'System.out' for output
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			String[] inputs = new String[M];
			int[] weightage = new int[M];
			for (int j = 0; j < M; j++) {
				inputs[j] = sc.next();
			}
			for (int j = 0; j < M; j++) {
				weightage[j] = sc.nextInt();
			}
			TrieStruct trieStruct = createTrie(inputs, weightage);
			for (int j = 0; j < N; j++) {
				String temp = sc.next();
				Map<Integer, String> autocomplete = retrieveAutoCompleteArrays(trieStruct, temp);
				if (autocomplete == null) {
					System.out.print(-1);
					System.out.println();
					continue;
				}
				int size = autocomplete.values().size();
				int count = 0;
				for (String output : autocomplete.values()) {
					count++;
					if (count < 6) {
						System.out.print(output + " ");
					}
				}
				if (j < M - 1) {
					System.out.println();
				}
			}

		}
		sc.close();
	}

	static TrieStruct createTrie(String[] inputs, int weightage[]) {
		TrieStruct trieStruct = new TrieStruct();
		TrieStruct tempTrie = null;
		int len = inputs.length;
		for (int i = 0; i < len; i++) {
			tempTrie = trieStruct;
			String word = inputs[i];
			int wordLen = word.length();
			for (int j = 0; j < wordLen; j++) {
				int index = word.charAt(j) - 'a';
				if (tempTrie.trieArray[index] == null) {
					tempTrie.trieArray[index] = new TrieStruct();
				}

				tempTrie.trieArray[index].map.put(weightage[i], word);
				tempTrie = tempTrie.trieArray[index];
			}
		}
		return trieStruct;
	}

	static Map<Integer, String> retrieveAutoCompleteArrays(TrieStruct trieStruct, String input) {
		TrieStruct tempTrie = trieStruct;
		// String word = inputs[i];
		int wordLen = input.length();
		for (int j = 0; j < wordLen; j++) {
			int index = input.charAt(j) - 'a';
			if (tempTrie.trieArray[index] == null) {
				return null;
			}
			tempTrie = tempTrie.trieArray[index];
		}
		return tempTrie.map;
	}
}

class TrieStruct {
	Map<Integer, String> map;
	TrieStruct[] trieArray;

	public TrieStruct() {
		this.map = new TreeMap<Integer, String>(Collections.reverseOrder());
		this.trieArray = new TrieStruct[26];
	}
}
