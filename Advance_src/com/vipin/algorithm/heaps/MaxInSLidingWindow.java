package com.vipin.algorithm.heaps;

import java.util.PriorityQueue;

public class MaxInSLidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] slidingMaximum(final int[] A, int B) {
        int N = A.length;
        int M = N-B+1;
        int ans[] = new int[M];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x,y)->y[0]-x[0]);
        int i = 0;
        for(i=0;i<B; i++) {
            pq.offer(new int[]{A[i], i});
        }
        int reject = -1;
        int j = 0;
        while(i<=N) {
            reject = i-B-1;
            while(reject>=pq.peek()[1]) {
                pq.remove();
            }
            ans[j++] = pq.peek()[0];
            pq.offer(new int[]{A[i], i});
            i++;
        }
        return ans;
    }

}
