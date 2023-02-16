package com.vipin.algorithm.heaps;

import java.util.PriorityQueue;

public class ConnectingRopes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int solve(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        int N = A.length;
        for(int i=0; i<N; i++) {
            pq.offer(A[i]);
        }
        int sum = 0;
        while(!pq.isEmpty()) {
        	int stepSum = 0;
        	stepSum += pq.poll();
        	if(pq.isEmpty()) {
        		break;
        	} else {
        		stepSum += pq.poll();
        	}
        	sum += stepSum;
        	pq.offer(stepSum);
        }
        return sum;
    }

}
