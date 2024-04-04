package com.vipin.algorithm.greedyalgorithms;

public class MinimumNoOfTripsByEachBus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []time = {5,10,10}; 
		int totalTrips = 9;
		System.out.println(minimumTime(time, totalTrips));
	}
	
	static boolean isPossible(int[]time, long givenTime, int trips) {
		int left = 0;
		int right = 10_000_000;
		long actualTrips = 0;
		for(int x : time) {
			actualTrips += givenTime/x;
		}
		return actualTrips>=trips;
	}
    
	static public long minimumTime(int[] time, int totalTrips) {

        int maxTime = time[0];
        for(int x : time) {
            maxTime = Math.max(maxTime, x);
        }
        long low = 1;
        long high = ((long)maxTime)*totalTrips;
        long mid = 0;
        while(low<high) {
        	mid = low + (high-low)/2;
        	if(isPossible(time, mid, totalTrips)) {
        		high = mid;
        	} else {
        		low = mid+1;
        	}
        }
        return (long)low;
    }


}
