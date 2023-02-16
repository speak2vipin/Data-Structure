package com.vipin.algorithm.trie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class UniqueCompaniesNames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ideas[] = {"aaa","baa","caa","bbb","cbb","dbb"};
		UniqueCompaniesNames u =  new UniqueCompaniesNames();
		System.out.println(u.distinctNames(ideas));

	}

	UniqueCompanyNameTrie trieLetterFirst = new UniqueCompanyNameTrie();
	UniqueCompanyNameTrie trie = new UniqueCompanyNameTrie();
    int total = 0;
    Set<String> set = new HashSet<String>();
    public long distinctNames(String[] ideas) {
        int N = ideas.length;
        int firstLetterSame = 0;
        total = N*(N-1);
        formTrieWithFirst(ideas);
        formTrie(ideas);
        
        for(int i=0; i<26; i++) {
            if(trieLetterFirst.trieArray[i]!=null) {
                int c = trieLetterFirst.trieArray[i].count;
                //total = total - (c * (c-1));
            }
        }
        
        for(String sec : set) {
        	UniqueCompanyNameTrie temp = trie;
            for(int i=0; i<sec.length(); i++) {
                int index = sec.charAt(i)-'a';
                temp = temp.trieArray[index];
            }
            int count = temp.count;
            for(String word : temp.words) {
                int tempIndex = word.charAt(0)-'a';
                total = total - ((trieLetterFirst.trieArray[tempIndex].count-1)*count);
            }
        }
        return total;
        
    }
    void formTrieWithFirst(String ideas[]) {
        int N = ideas.length;
        for(int i=0; i<N; i++) {
            int index = ideas[i].charAt(0)-'a';
            if(trieLetterFirst.trieArray[index]==null) {
            	trieLetterFirst.trieArray[index] = new UniqueCompanyNameTrie();
            }
            trieLetterFirst.trieArray[index].count += 1;
        }
    }
    void formTrie(String ideas[]) {
        int N = ideas.length;
        for(int i=0; i<N; i++) {
            String s = ideas[i];
            int l = s.length();
            UniqueCompanyNameTrie temp = trie;
            if(l>1) {
                for(int j=1; j<l; j++) {
                    int index = ideas[i].charAt(j)-'a';
                    if(temp.trieArray[index]==null) {
                        temp.trieArray[index] = new UniqueCompanyNameTrie();
                    }    
                    temp = temp.trieArray[index];  
                }
                temp.words.add(s);
                
                set.add(s.substring(1));
                  
                int oldCount = temp.count * (temp.count-1);
                temp.count += 1;
                total = total-(temp.count * (temp.count-1) - oldCount);
            }   
        }
    }
 }



class UniqueCompanyNameTrie {
    int count;
    UniqueCompanyNameTrie[] trieArray;
    List<String> words;
    public UniqueCompanyNameTrie() {
        count = 0;
        trieArray = new UniqueCompanyNameTrie[26];
        words = new ArrayList<String>();
    }
}