package com.vipin.algorithm.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Meetings_Rooms_Three {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int meetings[][] = {{1,20},{2,10},{3,5},{4,9},{6,8}};
		System.out.println(mostBooked(n, meetings));

	}

	public static int mostBooked(int n, int[][] meetings) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            (x,y)->x[1]==y[1] ? (x[0]-y[0]) : (x[1]-y[1]));
        Arrays.sort(meetings, (x,y)->x[0]-y[0]);
        int index = 0;
        for(int i=0; i<meetings.length; i++) {
            if(!pq.isEmpty() && pq.peek()[1]<=meetings[i][0]) {
                int top[] = pq.poll();
                pq.offer(new int[]{
                    top[1], 
                    top[1] + (meetings[i][1] - meetings[i][0]), 
                    top[2], 
                    top[3]+1});
            } else {
                if(index<n) {
                    pq.offer(new int[]{
                        meetings[i][0], meetings[i][1], index, 1});
                    index++;
                } else {
                    int top[] = pq.poll();
                    pq.offer(new int[]{
                        top[1], 
                        top[1] + (meetings[i][1] - meetings[i][0]), 
                        top[2], 
                        top[3]+1});
                }
            }    
        }
        
        int temp = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;
        while(!pq.isEmpty()) {
            int top[] = pq.poll();
            if(top[3]>=temp && top[2]<ans) {
                ans = top[2];
                temp = top[3];
            }
        }
        return ans;
        
        
    }

}
