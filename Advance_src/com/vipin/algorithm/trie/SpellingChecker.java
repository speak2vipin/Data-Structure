package com.vipin.algorithm.trie;

public class SpellingChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[]A = { "ab", "abc", "abcd", "abcde", "abcdef", "abcdefg" };
		String[]B = { "a", "b", "ab", "abcd" };
		SpellingChecker  a = new SpellingChecker();
		a.solve(A, B);

	}

	Trie trie = new Trie();
	Trie currTrie = null;

	public int[] solve(String[] A, String[] B) {

		int lengthA = A.length;
		int lengthB = B.length;
		int ans[] = new int[lengthB];

		for (int i = 0; i < lengthA; i++) {
			String temp = A[i];
			int lenWord = temp.length();
			currTrie = trie;
			for (int j = 0; j < lenWord; j++) {
				char tempChar = temp.charAt(j);
				int index = tempChar - 'a';
				// TAKE CARE OF THIS IFF BLOCK, U HAD MADE MISTAKE. U HAD FORGOT TO WRITE ELSE BLOCK
				if (currTrie.trieArray[index] == null) {
					Trie tempTrie = new Trie();
					currTrie.trieArray[index] = tempTrie;
					currTrie = tempTrie;
				} else {
					currTrie = currTrie.trieArray[index];
				}
			}
            currTrie.isEnd = true;
		}

		for (int i = 0; i < lengthB; i++) {
			String temp = B[i];
			int lenWord = temp.length();
			currTrie = trie;
			boolean isExist = true;
			for (int j = 0; j < lenWord; j++) {
				char tempChar = temp.charAt(j);
				int index = tempChar - 'a';
				if (currTrie.trieArray[index] == null) {
					isExist = false;
					break;
				}
                currTrie = currTrie.trieArray[index];
			}
			if (isExist && currTrie.isEnd) {
				ans[i] = 1;
			}
		}
		return ans;
		}

}

class Trie {
	boolean isEnd;
	Trie[] trieArray;

	public Trie() {
		this.trieArray = new Trie[26];
	}
}
