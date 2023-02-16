package com.vipin.algorithm.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Max3ElementsMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Max3ElementsMultiplication m = new Max3ElementsMultiplication();
		 ArrayList<Integer>ans = new ArrayList<Integer>();
		 ans.add(9);ans.add(11);ans.add(15);
		 
		 ArrayList<Integer>ans1 = new ArrayList<Integer>();
		 ans1.add(10);ans1.add(15);ans1.add(17);
		 System.out.println(m.solve(ans));
		 ArrayList<ArrayList<Integer>>ans2 = new ArrayList<ArrayList<Integer>>();
		 ans2.add(ans);
		 ans2.add(ans1);
		 System.out.println(m.solve(ans2, 6));
		 

	}
	
	public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer>ans = new ArrayList<Integer>();
        PriorityQueue<Integer>pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        
        
       
        int N = A.size();
        int calculated = 0;
        if(N==1) {
            ans.add(-1);
            
        } else if(N==2) {
            ans.add(-1);
            ans.add(-1);
            
        } else {
            ans.add(-1);
            pq.offer(A.get(0));
            ans.add(-1);
            pq.offer(A.get(1));
            for(int i=2; i<N; i++) {
                pq.offer(A.get(i));
                int temp1 = pq.poll();
                int temp2 = pq.poll();
                int temp3 = pq.poll();
                calculated = temp1 * temp2 * temp3;
                ans.add(calculated);
                pq.offer(temp1);
                pq.offer(temp2);
                pq.offer(temp3);

            }
        }
    return ans;  
    }
	
	
	 public int solve(ArrayList<ArrayList<Integer>> A, int B) {
	        int rows = A.size();
	        int column = A.get(0).size();
	        int total = rows * column;
	        
	        //rows = (int)Math.ceil(B/column); 
	        
	        if((B%column)==0) {
	        	rows = (B/column)-1;
	            column = column-1;
	            
	        } else {
	            column = (B%column)-1;
	            rows = B/column;

	        }
	        return A.get(rows).get(column);
	    }

}

