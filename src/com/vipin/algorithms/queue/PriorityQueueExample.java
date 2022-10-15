package com.vipin.algorithms.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue <Integer> Q = new PriorityQueue<Integer>();
		
		Q.add(-100);
		Q.add(67);
		Q.add(40);
		Q.add(1);
		for(Integer i : Q) {
			System.out.println(i);
		}
		int i [] = {1,2,3,5};
		solve(i);

	}
	
	
	public static int[][] solve(int[] A) {
        int temp = 0;
        int N = A.length;
        int count = (N*(N+1))/2;
        int ans[][] = new int[count][];
        
       
        for(int i=0; i<N; i++) {
            for(int j=i; j<N; j++) {
                List<Integer> l = new ArrayList<Integer>();
                for(int k=i; k<=j;k++) {
                    l.add(A[k]);
                }
                int res[] = new int[l.size()];
                for(int x = 0; x<l.size(); x++) {
                    res[x] = l.get(x);
                }
                ans[temp++] = res;
            }
        }
        return ans;
    }

}
