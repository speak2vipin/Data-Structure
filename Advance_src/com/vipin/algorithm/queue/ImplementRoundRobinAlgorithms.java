package com.vipin.algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementRoundRobinAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {2,3,1,5,4};
		int []B = {1, 3, 5, 4, 2};
		System.out.println(solve(A, B));

	}
	
	public static int solve(int[] A, int[] B) {
        Queue<Integer> qe = new LinkedList<Integer>();
        int totalCycles = 0;
        int M = A.length;
        for(int i=0; i<M; i++) {
            qe.add(A[i]);
        }
        int N = B.length;
        int task;
        for(int i=0; i<N; i++) {
            task = B[i];
            while(qe.peek()!=task) {
            	qe.add(qe.poll());
            	totalCycles++;
            }
            qe.poll();
            totalCycles++;
        }
        return totalCycles;
	}
}
