package com.vipin.algorithm.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class IsNumbersOnALine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coordinates[][] = {{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}};
		
		int coordinates1[][] = {{1,0},{2,0},{2,3}};
		System.out.println(checkStraightLine(coordinates1));
		IsNumbersOnALine i = new IsNumbersOnALine();
		System.out.println(i.checkStraightLineLeetCodeSol(coordinates1));
	}
	
	public static boolean checkStraightLine(int[][] coordinates) {
        int dx = coordinates[1][0] - coordinates[0][0];
        int dy = coordinates[1][1] - coordinates[0][1];
        int N = coordinates.length;
        for(int i=1; i<N-1; i++) {
            int coordinate1[] = coordinates[i];
            int coordinate2[] = coordinates[i+1];
            int xDiff = (coordinate2[0] - coordinate1[0]);
            int yDiff = (coordinate2[1] - coordinate1[1]);
            if(dy==0 && yDiff!=0 || dy!=0 && yDiff==0) {
                return false;
            
            } else if(dy==0 && yDiff==0 || dy==0 && yDiff==0) {
            	continue;
            } else {
                if((double)dx/dy != (double)xDiff/yDiff) {
                    return false;
                }
            }
        }
        return true;
    }
	
	
	    // Returns the delta Y.
	    int getYDiff(int[] a, int[] b) {
	        return a[1] - b[1];
	    }
	    
	    // Returns the delta X.
	    int getXDiff(int[] a, int[] b) {
	        return a[0] - b[0];
	    }
	    
	    public boolean checkStraightLineLeetCodeSol(int[][] coordinates) {
	        int deltaY = getYDiff(coordinates[1], coordinates[0]);
	        int deltaX = getXDiff(coordinates[1], coordinates[0]);
	        
	        for (int i = 2; i < coordinates.length; i++) {
	            // Check if the slope between points 0 and i, is the same as between 0 and 1.
	            if (deltaY * getXDiff(coordinates[i], coordinates[0])
	                != deltaX * getYDiff(coordinates[i], coordinates[0])) {
	                return false;
	            }
	        }
	        
	        Map<Integer, int[]> adj = new HashMap<>();
	        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
	            public int compare(int x[], int y[]) {
	                return x[0]-y[0];
	            }
	        });
	        return true;
	    }
	

}
