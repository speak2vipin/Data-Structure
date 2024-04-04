package com.vipin.algorithm.basiccollectionoperations;

public class Trie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


    char character;
    Trie[] trieArray;
    boolean isEnd;
    Trie root = null;

    public Trie() {
        trieArray = new Trie[26];
    }
    public Trie(char character) {
        this.character = character;
        this.isEnd = false;
    }
    
    public void insert(String word) {
        int N = word.length();
        Trie temp = null;
        if(root ==null){
            root = new Trie();
        }
        temp = root;
        
        for(int i=0; i<N; i++) {
            char charAtI = word.charAt(i);
            int index = charAtI - 'a';
            if(temp.trieArray[index]==null) {
               temp.trieArray[index] = new Trie(charAtI);
            }
            temp = temp.trieArray[index];
        }
        temp.isEnd = true;
        
    }
    
    public boolean search(String word) {
        int N = word.length();
        Trie temp = root;
        for(int i=0; i<N; i++) {
            char charAtI = word.charAt(i);
            int index = charAtI - 'a';
            if(temp.trieArray[index]==null) {
               return false;
            }
            temp = temp.trieArray[index];
         }
        return temp.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        int N = prefix.length();
        Trie temp = root;
        for(int i=0; i<N; i++) {
            char charAtI = prefix.charAt(i);
            int index = charAtI - 'a';
            if(temp.trieArray[index]==null) {
               return false;
            }
            temp = temp.trieArray[index];
         }
        return true;
    }
}



