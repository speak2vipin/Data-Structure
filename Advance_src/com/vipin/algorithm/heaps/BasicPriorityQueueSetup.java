package com.vipin.algorithm.heaps;

import java.util.*;

public class BasicPriorityQueueSetup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<int[]> pq = 
				new PriorityQueue<int[]>((a,b) -> a[0]-b[0]);
		int a[] = {3,2,10,5};
		int b[] = {2,8,11,61};
		pq.offer(a);
		pq.offer(b);
		
		System.out.println(pq.peek()[0] + " " +pq.peek()[1] + " " 
				+pq.peek()[2] + " " +pq.peek()[3] + " " );
		
		PriorityQueue<int[]> pqNew = 
				new PriorityQueue<int[]>(new Comparator<int[]>(){
					public int compare(int x[], int y[]) {
						return x[0]-y[0];
					}
				});
	}

}
