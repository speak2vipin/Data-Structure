package com.vipin.algorithm.trie;

import java.util.HashSet;

public class DictionaryWithOneWordDiffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DictionaryWithOneWordDiffer s = new DictionaryWithOneWordDiffer();
		String[] A = { "hello", "world"};
		String[] B = { "hella", "pello", "pella"  };	// 100
		System.out.println(s.solve(A, B));

	}

	TrieDictionary trie = new TrieDictionary();
	TrieDictionary tempTrie = null;
	TrieDictionary inBetTrie = new TrieDictionary();

	public String solve(String[] A, String[] B) {
        createTrie(A, trie);
        int NB = B.length;
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<NB; i++) {
            tempTrie = trie;
            int temp = isFound(tempTrie, B[i]);
           // System.out.println(B[i] + " " + temp);
            ans.append(temp);
        }
        return ans.toString();
    }

    void createTrie(String[]A, TrieDictionary trie) {
        int N = A.length;
        for(int i=0; i<N; i++) {
            tempTrie = trie;
            int L = A[i].length();
            for(int j=0; j<L; j++) {
                int index = A[i].charAt(j)-'a';
                if(tempTrie.children[index]==null) {
                    tempTrie.children[index] = new TrieDictionary();
                }
                tempTrie =tempTrie.children[index];
            }
            tempTrie.isEnd = true;
        }
    }
    
    boolean search(TrieDictionary tempTrie, String word) {
        int L = word.length();
        for(int i=0; i<L; i++) {
            int index = word.charAt(i)-'a';
            if(tempTrie.children[index]==null) {
                    return false;
            }
            tempTrie =tempTrie.children[index];
        }
        return tempTrie.isEnd;
    }

    int isFound(TrieDictionary tempTrie, String find) {
        int L = find.length();
        boolean found = false;
        char[] findArray = find.toCharArray();
        for(int i=0; i<L; i++) {
            char oldChar = find.charAt(i);
            for(char c='a'; c<='z'; c++) {
                if(c!=oldChar) {
                    findArray[i] = c;
                    found = search(tempTrie, new String(findArray));
                    if(found) {
                        return 1;
                    }
                }
            }
            findArray[i] = oldChar;
        }
            return 0;
        }
    
}

class TrieDictionary {
	boolean isEnd = false;
	TrieDictionary[] children;

	public TrieDictionary() {
		children = new TrieDictionary[26];
	}

	private static class Node {

		private char data;

		private boolean isEnd;

		private Node[] children;

		public Node(char data) {

			this.data = data;

			this.isEnd = false;

			this.children = new Node[26];

		}

	}

	private Node root = new Node('/');

	private void insertWord(String word) {

		Node curr = root;

		for (int i = 0; i < word.length(); i++) {

			int childIdx = word.charAt(i) - 'a';

			if (curr.children[childIdx] == null) {

				curr.children[childIdx] = new Node(word.charAt(i));

			}

			curr = curr.children[childIdx];

		}

		curr.isEnd = true;

	}

	private boolean searchWord(String word) {

		Node curr = root;

		for (int i = 0; i < word.length(); i++) {

			int childIdx = word.charAt(i) - 'a';

			if (curr.children[childIdx] == null) {

				return false;

			}

			curr = curr.children[childIdx];

		}

		return curr.isEnd;

	}

	public String solve(String[] A, String[] B) {

		for (String word : A) {

			insertWord(word);

		}

		StringBuilder ans = new StringBuilder();

		HashSet<String> set = new HashSet<>();

		for (String word : B) {

			set.add(word);

			boolean isFound = false;

			char[] charArr = word.toCharArray();

			for (int i = 0; i < charArr.length; i++) {

				char oldChar = charArr[i];

				for (char ch = 'a'; ch <= 'z'; ch++) {

					charArr[i] = ch;

					String newString = new String(charArr);

					if (set.contains(newString)) {

						continue;

					}

					isFound = searchWord(newString);

					if (isFound) {

						break;

					}

				}

				charArr[i] = oldChar;

				if (isFound) {

					break;

				}

			}

			if (isFound) {

				ans.append(1);

			} else {

				ans.append(0);

			}

		}

		return new String(ans);

	}
}




