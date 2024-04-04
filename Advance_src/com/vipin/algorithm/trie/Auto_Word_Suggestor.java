package com.vipin.algorithm.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Auto_Word_Suggestor {
	static TrieNodeMy top = null;
	static TrieNodeMy top1 = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> input = new ArrayList<>();
		input.add("carpet");
		input.add("camera");
		input.add("cart");
		input.add("crate");
		input.add("car");
		//for (List<String> t : auto_word_suggestor(input, "camera")) {
			//for (String s : t) {
				//System.out.print(s + " ");
			//}
			//System.out.println();
		//}
		List<String> input1 = new ArrayList<>();
		String s = "hgferyjkllkop";
		input1.add(s);
		String i[] = {"coffee", "coding", "happy", "hello", "hop"};
		List<String> input3 = new ArrayList<>();
		for(String s2 : i) {
			input3.add(s2);
		}
		myformTrie(input1);
		System.out.println(get(input3));
		

	}

	static List<List<String>> auto_word_suggestor(List<String> list, String search) {
		myformTrie(list);
		List<List<String>> suggest = new ArrayList<>();
		int N = search.length();
		for (int i = 0; i < N; i++) {
			int index = search.charAt(i) - 'a';
			List<String> ans = new ArrayList<>();
			if (top != null) {
				TreeSet<String> treeSet = top.trieNode[index].treeSet;
				int size = 0;
				for (String s : treeSet) {
					ans.add(s);
					size++;
					if (size == 3) {
						break;
					}
				}
				top = top.trieNode[index];
				suggest.add(ans);
			} else {
				break;
			}
		}
		return suggest;
	}

	static void formTrie(List<String> list) {
		if (top == null) {
			top = new TrieNodeMy();
		}
		for (String s : list) {
			TrieNodeMy temp = top;
			int N = s.length();
			for (int i = 0; i < N; i++) {
				int index = s.charAt(i) - 'a';
				if (temp.trieNode[index] != null) {
					temp = temp.trieNode[index];
					temp.treeSet.add(s);
				} else {
					temp.trieNode[index] = new TrieNodeMy();
					temp = temp.trieNode[index];
					temp.treeSet.add(s);
				}
			}

		}
	}
	
	static void myformTrie(List<String> list) {
		
		for(String s : list) {
			TrieNodeMy temp = top1;
			int n = s.length();
			for(int i=0; i<n; i++) {
				int index = s.charAt(i)-'a';
				if(top1==null) {
					top1 = new TrieNodeMy();
					temp = top1;
				}
				temp.c = s.charAt(i);
				if(temp.trieNode[index]==null) {
					temp.trieNode[index] = new TrieNodeMy();
				} 
				temp.trieNode[index].treeSet.add(s);
				temp = temp.trieNode[index];
			}
		}
		
	}
	
	static String get(List<String>l) {
		String ans = null;
		TreeSet<String> t = new TreeSet<>();
		for(String s : l) {
			TrieNodeMy temp = top1;
			int n = s.length();
			boolean flag = true;
			for(int i=0; i<n; i++) {
				while(temp.c!='\u0000' && s.charAt(i)!=temp.c) {
					temp = temp.trieNode[temp.c-'a'];
				}
				if(temp.c=='\u0000') {
					flag = false;
					break;
				}
			}
			if(flag) {
				if(ans==null) {
					ans = s;
				}
				ans = ans.compareTo(s)<0?ans:s;
			}
		}
		return ans;
	}
}

class TrieNodeMy {
	TrieNodeMy trieNode[] = null;
	TreeSet<String> treeSet;
	char c = '\u0000';

	public TrieNodeMy() {
		trieNode = new TrieNodeMy[26];
		treeSet = new TreeSet<>();
	}

}
