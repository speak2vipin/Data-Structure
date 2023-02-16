package com.vipin.algorithm.greedyalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumProfitBuyingCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 7, 6, 2, 8, 4, 4, 6, 8, 2 };
		int b[] = { 8, 11, 7, 7, 10, 8, 7, 5, 4, 9};
		ArrayList<Integer> A = new ArrayList<Integer> ();
		ArrayList<Integer> B = new ArrayList<Integer> ();
		for(int x : a) {
			A.add(x);
		}
		for(int x : b) {
			B.add(x);
		}
		System.out.println(solve(A, B));

	}
	
	public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        int N = A.size();
        int input[][] = new int[N][2];
        for(int i=0; i<N; i++) {
            input[i][0] = A.get(i);
            input[i][1] = B.get(i);
        }
        Arrays.sort(input, (X,Y)-> Integer.compare(X[0], Y[0]));
        PriorityQueue<Integer>pq = new PriorityQueue<Integer>();
        int profit = 0;
        int mod = 1000000007;
        int time = 0;
        for(int i=0; i<N; i++) {
            if((input[i][0]-1)>=time) {
                profit = (profit%mod + input[i][1]%mod)%mod;
                pq.offer(input[i][1]);
                time++;
            } else {
                if(input[i][1]>pq.peek()){
                    profit -= pq.poll();
                    profit = (profit%mod + input[i][1]%mod)%mod;
                    pq.offer(input[i][1]);
                }
            }  
        }
     
        return profit;
    }

}
