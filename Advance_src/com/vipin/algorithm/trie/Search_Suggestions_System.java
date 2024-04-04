package com.vipin.algorithm.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Search_Suggestions_System {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Trie root = null;

	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		for (String s : products) {
			formTrie(s);
		}
		List<List<String>> result = new ArrayList<>();
		for (int i = 0; i < searchWord.length(); i++) {
			int index = searchWord.charAt(i) - 'a';
			if (root != null) {
				result.add(new ArrayList<String>(root.set));
				root = root.trie[index];
			} else {
				break;
			}
		}
		return result;
	}

	void formTrie(String s) {
		if (root == null) {
			root = new Trie();
		}
		Trie temp = root;
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			if (temp.trie[index] == null) {
				temp.set.add(s);
				temp.trie[index] = new Trie();
			}
			temp = temp.trie[index];
		}

	}
}

	class Trie {
		Trie[] trie;
		TreeSet<String> set;

		public Trie() {
			trie = new Trie[26];
			set = new TreeSet<>();
		}
	}
