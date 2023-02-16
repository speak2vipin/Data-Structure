package com.vipin.algorithm.mathoperation;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MathCeilAndFloorMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]piles = {4,3,6,7};
		//System.out.println(minStoneSum(piles, 3));
		System.out.println(minStoneSumWithHeap(piles, 3));

	}
	
	public static int minStoneSum(int[] piles, int k) {
        int total = 0;
        int N = piles.length-1;
        while(k>0) {
            Arrays.sort(piles);
            int temp = (int)(Math.ceil(piles[N]/2.0));
            piles[N] = temp;
            k--;
        }
        for(int i=0; i<=N; i++) {
            total += piles[i];
        }
        return total;  
    }
	
	public static int minStoneSumWithHeap(int[] piles, int k) {
        int total = 0;
        int N = piles.length-1;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0; i<=N; i++) {
            pq.add((-1)*piles[i]);
        }
        while(k>0) {
            int temp = pq.remove();
            pq.add(temp-(temp/2));
            k--;
        }
       
        for(Integer stones : pq) {
            total += (-1)*stones;
        }
        return total; 
    }
}
