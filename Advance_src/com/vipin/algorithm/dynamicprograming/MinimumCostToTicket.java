package com.vipin.algorithm.dynamicprograming;

import java.util.HashMap;

public class MinimumCostToTicket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumCostToTicket m= new MinimumCostToTicket();
		int days[] = {1,4,6,7,8,20};
		int costs[] = {2,7,15};
		System.out.println(m.mincostTickets(days, costs));
	}
	
	public int mincostTickets(int[] days, int[] costs) {
	       // int N = days.length-1;
	        HashMap<Integer, Integer> dayMap = new HashMap<>();
	        for(int day : days) {
	            dayMap.put(day, 1);
	        }
	        int dp[] = new int[366];
	        for(int i=1; i<=365; i++) {
	            if(dayMap.get(i)!=null) {
	                dp[i] = Math.min(dp[Math.max(0, i-1)] + costs[0],
	                                Math.min(dp[Math.max(0, i-7)] + costs[1], 
	                                         dp[Math.max(0, i-30)] + costs[2]));
	            } else {
	                dp[i] = dp[i-1];
	            }
	        }
	        return dp[365];
	    }

}
