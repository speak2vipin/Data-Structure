package com.vipin.algorithms.queue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxPerformanceOfATeam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[] speed = { 2, 10, 3, 1, 5, 8 };
		int[] efficiency = { 5, 4, 3, 9, 7, 2 };
		int k = 2;
		System.out.println(maxPerformance(n, speed, efficiency, k));
		System.out.println(maxPerformance(speed, efficiency, k));

	}

	public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
		int[][] ess = new int[n][2];
		for (int i = 0; i < n; ++i)
			ess[i] = new int[] { efficiency[i], speed[i] };
		Arrays.sort(ess, (a, b) -> b[0] - a[0]);
		PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
		long res = 0, sumS = 0;
		for (int[] es : ess) {
			pq.add(es[1]);
			sumS = (sumS + es[1]);
			if (pq.size() > k)
				sumS -= pq.poll();
			res = Math.max(res, (sumS * es[0]));
		}
		return (int) (res % (long) (1e9 + 7));
	}
	
	 public static int maxPerformance( int[] speed, int[] efficiency, int k) {
	        int N = speed.length;
	        int [][]temp = new int[N][2];
	        for(int i=0; i<N; i++) {
	            temp[i] = new int[] {efficiency[i], speed[i]};
	        }
	        // Sort in Desecnding order by efficiency
	        Arrays.sort(temp, (a,b) -> b[0] - a[0]);
	        // Default order i.e. Ascending order
	        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	        long sum = 0;
	        long netEfficiency = 0;
	        for(int i=0; i<N; i++) {
	            netEfficiency+=temp[i][1];
	            pq.add(temp[i][1]);
	            if(pq.size()>k) {
	                netEfficiency-=pq.poll();
	            }
	            // Trick is here i.e if in Queue, didn't get higher number than              
	            //netEfficiency will not change and we knows A[0] would be in descending order so it's 
	            //multiply will not be higher than it's previous value for sure.
	            sum = Math.max(sum, netEfficiency*temp[i][0]);
	        }
	        return (int) (sum % (long) (1e9 + 7));
	 }

}
