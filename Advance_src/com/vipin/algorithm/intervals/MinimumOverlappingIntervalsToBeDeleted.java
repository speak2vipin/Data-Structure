package com.vipin.algorithm.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumOverlappingIntervalsToBeDeleted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intervals[][] = 
		 {{-3035,30075},{1937,6906},{11834,20971},{44578,45600},
			{28565,37578},{19621,34415},{32985,36313},{-8144,1080},
			{-15279,21851},{-27140,-14703},{-12098,16264},
			{-36057,-16287},{47939,48626},
			{-15129,-5773},{10508,46685},{-35323,-26257}};
		
		MinimumOverlappingIntervalsToBeDeleted m = new MinimumOverlappingIntervalsToBeDeleted();
		System.out.println(m.eraseOverlapIntervals(intervals));
	}
	
	public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[1]-b[1]);
        //Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        
        int initial[] = intervals[0];
        
        int count = 0;
        for(int i=1; i<intervals.length; i++) {
            int temp[] = intervals[i];
            if(isOverlap(initial, temp)) {
                count++;
            } else {
                initial = temp; 
            }    
        }
        return count;
        
    }
	
	public int eraseOverlapIntervals1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        int k = Integer.MIN_VALUE;
        
        for (int i = 0; i < intervals.length; i++) {
            int x = intervals[i][0];
            int y = intervals[i][1];
            
            if (x >= k) {
                // Case 1
                k = y;
            } else {
                // Case 2
                ans++;
            }
        }
        
        return ans;
    }
	
	boolean isOverlap(int x[], int y[]) {
		return Math.min(x[1], y[1]) - Math.max(x[0],y[0])>0;
	}

}


class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        int k = Integer.MIN_VALUE;
        
        for (int i = 0; i < intervals.length; i++) {
            int x = intervals[i][0];
            int y = intervals[i][1];
            
            if (x >= k) {
                // Case 1
                k = y;
            } else {
                // Case 2
                ans++;
            }
        }
        
        return ans;
    }
}
