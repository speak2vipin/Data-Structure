package com.vipin.algorithm.trie;

public class ShortestAlias {
	
	TrieNew trie = new TrieNew(1);
	TrieNew tempTrie = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[]A = { "zebra", "dog", "duck", "dove" };
		//String[]B = { "a", "b", "ab", "abcd" };
		ShortestAlias  a = new ShortestAlias();
		a.prefix(A);
	}
	
    public String[] prefix(String[] A) {
        
        int len = A.length;
        for(int i=0; i<len; i++) {
            String word = A[i];
            int length = word.length();
            tempTrie = trie;
            for(int j=0; j<length; j++) {
                int index = word.charAt(j)-'a';
                if(tempTrie.trieArray[index] == null) {
                    tempTrie.trieArray[index] = new TrieNew(1);
                } else {
                    tempTrie.trieArray[index].data = 0;
                }
                tempTrie = tempTrie.trieArray[index];
            }
        }
        String ans[] = new String[len];
        for(int i=0; i<len; i++) {
            String word = A[i];
            int length = word.length();

            tempTrie = trie;
            for(int j=0; j<length; j++) {
                int index = word.charAt(j)-'a';
                if(tempTrie.trieArray[index] != null && tempTrie.trieArray[index].data==1 ) {
                    ans[i] = word.substring(0,j+1);
                    break;
                }
                tempTrie = tempTrie.trieArray[index]; 
            }
            if(ans[i]  == null) {
                ans[i] = word;
            } 
        }
        return ans;
    }
}

class TrieNew {
    int data;
    TrieNew[] trieArray;

    public TrieNew(int data) {
        this.data = data;
        trieArray = new TrieNew[26];
    }
}
