package com.vipin.algorithm.heaps;

import java.util.PriorityQueue;

public class MyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabbaa";
		int k = 2;
		System.out.println(getLengthOfOptimalCompression(s, k));
	}
	
	 public static int getLengthOfOptimalCompression(String s, int k) {
	        int n = s.length();
	        String t = "";
	        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x,y) -> x[1]-y[1]);
	        for(int i=0; i<n;) {
	            int j=i+1;
	            while(j<n && s.charAt(i)==s.charAt(j)) {
	                j++;
	            }
	            if(j-i>1) {
	                t += (s.charAt(i))+""+(j-i);
	            } else {
	                t += s.charAt(i);
	            }
	            pq.offer(new int[]{s.charAt(i), j-i});
	            i = j;
	        }
	        int len = t.length();
	        while(k>0) {
	            int [] top = pq.poll();
	            if(top[1]<k) {
	                k = k-top[1];
	                if(top[1]==1) {
	                    len -= top[1];
	                } else {
	                    len -= top[1] + 1;
	                }
	                
	            } else if(top[1]==k) {
	                k = k-top[1];
	                if(top[1]==1) {
	                    len -= top[1];
	                } else {
	                    len -= (""+top[1]).length() + 1;
	                }
	            } else {
	                String prev = ""+top[1];
	                len -= prev.length();
	                top[1]= top[1] - k;
	                k=0;
	                String post = ""+top[1];
	                len += post.length();
	            }
	        }
	        return len;
	        
	    }

}
