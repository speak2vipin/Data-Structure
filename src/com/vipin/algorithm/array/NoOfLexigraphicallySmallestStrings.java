package com.vipin.algorithm.array;

public class NoOfLexigraphicallySmallestStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[]queries = {"bbb","cc"};
		String[]words = {"a","aa","aaa","aaaa"};
		numSmallerByFrequency(queries, words);
	}

	public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        
        int [] fCount = new int[11];
        
        for(String word : words){
            int count = calculateFrequency(word);
            fCount[count]++;
        }
        
        
        int sum = 0;
        for(int i=0;i<fCount.length;i++){
            sum += fCount[i];
            fCount[i] = sum;
        }
        
        int [] res = new int[queries.length];
        
        for(int i=0;i<queries.length;i++){
            
            int count = calculateFrequency(queries[i]);
            res[i] = fCount[fCount.length -1] - fCount[count];
        }
        
        return res; 
    }
    

	static int calculateFrequency(String s) {
		char c = '\u0000';
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i == 0) {
				c = s.charAt(i);
				count++;
			} else {
				if (c == s.charAt(i)) {
					count++;
				} else if (c > s.charAt(i)) {
					c = s.charAt(i);
					count = 1;
				}
			}
		}
		return count;
	}
}