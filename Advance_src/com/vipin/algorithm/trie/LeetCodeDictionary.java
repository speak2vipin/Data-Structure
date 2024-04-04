package com.vipin.algorithm.trie;

public class LeetCodeDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCodeDictionary l = new LeetCodeDictionary();
		l.addWord("a");
		System.out.println(l.search("a"));
		System.out.println(l.search("aa"));

	}
	MyTrie root;

    public LeetCodeDictionary() {
        root = new MyTrie('\u0000');
    }
    
    public void addWord(String word) {
    	MyTrie temp = root;
        int N = word.length();
        for(int i=0; i<N; i++) {
            char tempLetter = word.charAt(i);
            int index = tempLetter - 'a';
            if(temp.trieArray[index]==null) {
                temp.trieArray[index] = new MyTrie(tempLetter);
            }
            temp = temp.trieArray[index]; 
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
    	MyTrie temp = root;
        int N = word.length();
        char[]letters = word.toCharArray();
        for(int i=0; i<N; i++) {
            char tempLetter = letters[i];
            int index = 0;
            if(tempLetter!='.') {
                index = tempLetter - 'a';
                if(temp.trieArray[index]==null) {
                    return false;
                }
                temp = temp.trieArray[index]; 
            } else {   	
                for(char j='a'; j<='z'; j++) {
                    letters[i] = j;
                    if(search(new String(letters))) {
                        return true;
                    }
                }
                return false;
            }      
        }
        return temp.isEnd;
    }
}

class MyTrie {
    char letter;
    MyTrie [] trieArray;
    boolean isEnd;
    public MyTrie(char letter) {
        this.letter = letter;
        this.trieArray = new MyTrie[26];
        this.isEnd = false;
    }
}