package com.vipin.algorithms.string;

public class ReverseStrungWithSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("hv xdq op qoddptokkz vemmoxrgf ombt gg  crulgzfkif "));

	}
	
	
		 public static String solve(String A) {  
	            A = A.trim();
	            int x=0;
	            int y=0;
	            
	            while(y<A.length()) {
	                if(A.charAt(y)==' ') {
	                	StringBuilder sb = new StringBuilder();
	                    A = sb.append(A.substring(0,y+1)).append(A.substring(y+1).trim()).toString();
	                    //x=y+1;
	                }
	                y++;
	            }
	            //A = sb.toString();     
		        int i=0;
		        int j=A.length()-1;
		        char temp;
		        char[] charA = A.toCharArray();
		        while(i<j) {
		            temp = charA[i];
		            charA[i] = charA[j];
		            charA[j] = temp;
		            i++;
		            j--;
		        }
		        int l = 0, m=0;
		        for(int k=0; k<A.length(); k++) {
		            if(charA[k]==' ') {
		                m=k-1;
		                while(l<m) {
		                    temp = charA[l];
		                    charA[l] = charA[m];
		                    charA[m] = temp;
		                    l++;
		                    m--;
		                }
		                l = k+1;
		            }
		        }
		        return new String(charA);
	    
	    }
}
