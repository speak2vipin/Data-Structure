package com.vipin.algorithms.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MaximumNumberFormedWithNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s1[]= {3, 30, 34, 5, 9 };
		int s2[]= {0, 0, 0, 0, 0 };
		System.out.println(largestNumber(s2));

	}
	
	public static String largestNumber(final int[] A) {    
        int N = A.length;
        String s[] = new String[N];
        for(int i=0;i<N;i++) {
            s[i] = Integer.toString(A[i]);
        }
        Arrays.sort(s, new Comparator<String>() {
        	public int compare(String S1, String S2) {
                // Remember of appending both Strings so that u will get the biggest String formed
        		String temp1 = S1.concat(S2);
        		String temp2 = S2.concat(S1);
                // 
        		return temp1.compareTo(temp2);
        	}
		});     
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i=N-1;i>-1;i--) {
        	sb.append(s[i]);
        	count++;
        }
        if(count==N) {
        	return "0";
        }
        return sb.toString(); 
	}

}
