package com.vipin.algorithm.stringpatternmatching;

public class MinimumLettersToMakeItPalindromeUsingZAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumLettersToMakeItPalindromeUsingZAlgorithms m = new MinimumLettersToMakeItPalindromeUsingZAlgorithms();
		
		System.out.println(m.solve("aaaa"));
	}
	
	public int solve(String A) {
		int x = A.length();
        StringBuilder reverse = new StringBuilder(A).reverse();
        
        String temp = new StringBuilder(A).append("@").append(reverse).toString();
        
        int Z[] = ZAlgorithms(temp.toCharArray());
        int max = 0;
        int N = temp.length();
        for(int i=x+1; i<N; i++) {
        	if(i+Z[i]==N) {
        		return max = x - Z[i];
        	}
        }
        return max;

    }

    int [] ZAlgorithms(char [] letter) {
    	int N = letter.length;
        int l = 0, r = 0;
        
        int Z[] = new int[N];
        for(int i=1; i<N; i++){
            
            if(r<i) {
            	l = i; r = i;
                while(r<N && letter[r-l]==letter[r]) {
                    r++;
                }
                Z[i] = r-l;
                r--;
            } else {
                if(l + Z[i-l] <= r) {
                    Z[i] = Z[i-l]; 
                } else {
                    l = i;
                    if(r<i) {
                        while(r<N && letter[r-l]== letter[r]) {
                            r++;
                        }
                        Z[i] = r-l;
                        r--;
                    }
                }
            }
        }
        return Z;
    }

}
