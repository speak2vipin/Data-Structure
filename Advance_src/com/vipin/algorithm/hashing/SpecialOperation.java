package com.vipin.algorithm.hashing;

import java.util.ArrayList;
import java.util.List;

public class SpecialOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[]A= {'+', '?', '?', '+', '-', '?'};
		String B[] = {"99", "1", "1", "361", "241", "101"};
		
		solve(A, B);
		List l = new ArrayList();
		l.add("A");
		l.add("B");
		l.add("A");
		l.remove("A");
		System.out.println(l);
		
	}
	

	    static ArrayList<String> list = new ArrayList<String>();
	    public static int[] solve(char[] A, String[] B) {
	    	int N = A.length;
	        ArrayList<Integer> ans = new ArrayList<Integer>();
	        for(int i=0; i<N; i++) {
	            if(A[i]=='+') {
	                list.add(B[i]);
	            } else if(A[i]=='-') {
	                list.remove(B[i]);
	            } else {
	                String temp = B[i];
	                int count = 0;
	                for(String s : list) {
	                    if(matchPattern(s,temp)) {
	                        count++;
	                    }
	                }
	                ans.add(count);
	            }
	        }
	        int size = ans.size();
	        int finalAns[] = new int[size];
	        for(int i=0; i<size; i++) {
	            finalAns[i] = ans.get(i);
	        }
	        return finalAns;
	    }
	    
	   static boolean matchPattern(String s1, String s2) {
	        int l1 = s1.length();
	        int l2 = s2.length();
	        int len = l1>l2?l1:l2;
	        String temp1 = null;
	        String temp2 = null;
	        int j=0;
	        int tempCount = Math.abs(l1-l2);
	        if(l1>=l2) {
	            temp1 = s1;
	            temp2 = s2;
	            while(j<tempCount) {
		            temp2 = '0'+temp2; 
		            j++;
		        }
	        } else {
	            temp1 = s1;
	            temp2 = s2;
	            while(j<tempCount) {
		            temp1 = '0'+temp1; 
		            j++;
		        }
	        }
	        	        
	        
	        for(int i=len-1; i>-1; i--) {
	            char t1 = temp1.charAt(i);
	            char t2 = temp2.charAt(i);
	            if(t2=='0') {
	                if((t1-'0')%2 == 0) {
	                    continue;
	                } else {
	                    return false;
	                }
	            } else if(t2=='1') {
	                if((t1-'0')%2 == 1) {
	                    continue;
	                } else {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	    

}