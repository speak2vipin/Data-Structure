package com.vipin.algorithm.heaps;

import java.util.PriorityQueue;

public class MagiciansAndChocolates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A = 5;
		int [] B = { 2147483647, 2000000014, 2147483647 };
		System.out.println(nchoc(A, B));
	}
	
	public static int nchoc(int A, int[] B) {
        int mod = 1000000007;
        		  //147483629
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int N = B.length;
        for(int i=0; i<N; i++) {
            pq.offer((-1) * B[i]);
        }
        int chocolates = 0;
        while(A>0) {
            int tempChocolates = pq.poll() *(-1);
            chocolates = (chocolates%mod + tempChocolates%mod)%mod;
            System.out.println(chocolates);
            pq.offer((-1)*tempChocolates/2);
            A--;
        }
        pq.clear();
       
        return (int)chocolates%mod;
    }

}
