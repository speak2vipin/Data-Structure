package com.vipin.algorithm.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumberMorethanOneThirdinLinearComplexity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int D [] = {2, 1, 1, 1, 2};
		//[2, 1, 1, 1, 2], ['', 'PP', 'PP', 'GM', '']
		String T[]= { "", "", "PP", "GM", ""};
		System.out.println(solution(D, T));
	}

	public int repeatedNumber(final List<Integer> a) {
		int max1 = a.get(0);
		int count1 = 1;
		int max2 = 0;
		int count2 = 0;
		int temp;
		for (int i = 1; i < a.size(); i++) {
			temp = a.get(i);
			if (temp == max1) {
				count1++;
			} else if (temp == max2) {
				count2++;
			} else if (count1 == 0) {
				max1 = temp;
				count1++;
			} else if (count2 == 0) {
				max2 = temp;
				count2++;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) == max1) {
				count1++;
			} else if (a.get(i) == max2) {
				count2++;
			}
		}
		if (count1 > a.size() / 3)
			return max1;
		if (count2 > a.size() / 3)
			return max2;

		return -1;
	}
	
	 public int solution(int[] A) {
	        // write your code in Java SE 8
		 List<Integer> you  = Arrays.stream( A ).boxed().collect(Collectors.toList() );
	        for(int i=1;i<100000;i++) {
	            if(!you.contains(i)){
	                return i;
	            }
	        }
	        return -1;
	    }
	 
	 public static int solution(int[] D, String[] T) {
	        // write your code in Java SE 8
	        int dLen = D.length;
	        int prefix[] = new int[dLen];
	        prefix[0] = D[0];
	        for(int i=1;i<dLen;i++) {
	            prefix[i] = prefix[i-1] + D[i];
	        }
	        int tLen = T.length;
	        int trashCount[][] = new int[tLen][3];
	        for(int j=0;j<tLen;j++) {
	            String temp = T[j];
	            for(int k=0;k<temp.length();k++) {
	                if(temp.charAt(k)=='P') {
	                   trashCount[j][0] =  trashCount[j][0]+1;
	                  
	                } else if(temp.charAt(k)=='G') {
	                   trashCount[j][1] =  trashCount[j][1]+1;
	                 
	                } else if(temp.charAt(k)=='M') {
	                   trashCount[j][2] =  trashCount[j][2]+1;    
	                }
	            }
	        }

	        int ans = Integer.MIN_VALUE;
	        int count = 0;
	        for(int[] tempA : trashCount) {
	        	int tempAns = 0;
	        	if(tempA[0]!=0 || tempA[1]!=0 || tempA[2]!=0 ) {
	        		tempAns+= 2*prefix[count] + tempA[0]+ tempA[1] + tempA[2];
	        	}
	            ans = tempAns>ans ? tempAns :ans;
	            count++;
	        }
	        return ans;
	 }
	 
	 public boolean isPowerOfFour(int n) {
	        long temp =0;
	        int count =0;
	        while(temp<n) {
	            temp = (long)(Math.pow(4,count));
	            count++;
	        }
	        return temp==n;
	            
	    }
	 
	 public int solve(int[] A) {
		 //Arrays.asList(A);	-	 Can't covert an array of primitive to array of wrapper
	     //Arrays.sort(Arrays.asList(A), Collections.reverseOrder());	-	Arrays.asList() -> return List of int array i.e. List<int[]>temp
		 //Arrays.sort(A, Collections.reverseOrder())	--> This collection.reverseOrder works on wrappaer not on primitives array
		 Arrays.sort(A);
		 int N = A.length;
		 int temp;
		 for(int i=0;i<N/2;i++) {
			 temp = A[i];
			 A[i] = A[N-1-i];
			 A[N-1-i] = temp;
		 }
	        
	        int ans = 0;
	        int count = 0;
	        for(int i=0;i<A.length;i++) {
	            // Basically to take care equals number in an Array 
	            if(i>0 && A[i]!=A[i-1]) {
	                count=i;
	            }
	            if(count==A[i]) {
	                ans++;
	            }
	        }
	        return ans;
	    }

}
