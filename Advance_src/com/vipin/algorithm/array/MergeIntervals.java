package com.vipin.algorithm.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeIntervals m =new MergeIntervals();
		int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int[] newInterval = {4,8};
		
		List<int[]>l = new ArrayList<int[]>(Arrays.asList(intervals));
		
		l.add(newInterval);
		String[]names = {"A", "B", "C"};
		List<String>sList = new ArrayList<String>(Arrays.asList(names));
		//sList.add(Arrays.asList(names));
		Arrays.fill(newInterval, 0);
		List<Integer>IList = new ArrayList<Integer>();
	
		System.out.println(m.insert(intervals, newInterval));

	}
	
	
	
	public int[][] insert(int[][] intervals, int[] newInterval) {
		intervals = insertInterval(intervals, newInterval);
		List<int[]> ans = new ArrayList<int[]>();
		for (int i = 0; i < intervals.length; i++) {
            int[] currInterval = {intervals[i][0], intervals[i][1]};
            while(i<intervals.length && doesIntervalsOverlap(currInterval, intervals[i])) {
            	currInterval = mergeInterval(currInterval, intervals[i]);
            	i++;
            }
            i--;
            ans.add(currInterval);
		}
		return ans.toArray(new int[ans.size()][2]);
		
	}
	 
	    
	    int[][] insertInterval(int[][] intervals, int[] newInterval) {
	        boolean isIntervalInserted = false;
	        List<int[]>list = new ArrayList<>(Arrays.asList(intervals));
	        for(int i=0; i<intervals.length; i++) {
	        	if(newInterval[0] < intervals[i][0]) {
	        		list.add(i, newInterval);
	        		isIntervalInserted = true;
	        		break;
	        	}
	        }
	        if(!isIntervalInserted) {
	        	list.add(newInterval);
	        }
	        return list.toArray(new int[list.size()][2]);
	        
	    }
	    
	    boolean doesIntervalsOverlap(int a[], int b[]) {
	    	return Math.min(a[1],b[1]) - Math.max(a[0], b[0]) >= 0;
	    }
	    
	    int[]mergeInterval(int []a, int []b) {
	    	int[]mergedInterval = {Math.min(a[0], b[0]), Math.max(a[1], b[1])};
	    	return mergedInterval;
	    }
	
	
	

}
