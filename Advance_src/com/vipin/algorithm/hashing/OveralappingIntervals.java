package com.vipin.algorithm.hashing;

import java.util.Arrays;

public class OveralappingIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2147483647
		int points[][] = {{10,12},{1,2},{-2147483646,-2147483645},{2147483646,2147483647}, {-2147483646,-2147483644}};
		System.out.println(findMinArrowShots(points));
		// 1, 0, -1
		System.out.println(Integer.compare(2147483645,214748364));
    
	}
	
	public static int findMinArrowShots(int[][] points) {
        // Interval Overlapping Pattern
       /* Map<PointClass, Integer> map = new HashMap<PointClass, Integer>();
        for(int point[] : points) {
        	PointClass temp = new PointClass(point[0], point[1]);
        	map.put(temp, map.getOrDefault(temp, 0)+1);
        }
        return map.size(); 
        */
		Arrays.sort(points, (a,b)-> Integer.compare(a[1],b[1]));
        int N = points.length;
        int shootPoint = points[0][1];
        int count = 1;
        for(int point[] : points) {
            if(point[0]<=shootPoint) {
                continue;
            } else {
                shootPoint = point[1];
                count++;
            }
        }
        return count;
    }
}

class PointClass {
    int X1;
    int X2;
    public PointClass(int X1, int X2) {
        this.X1 = X1;
        this.X2 = X2;
    }
    
    @Override
    public boolean equals (Object X) {
    	PointClass p = (PointClass)X;
    	return !(p.X2<this.X1 || p.X1>this.X2);
    }
    
    @Override
    public int hashCode() {
    	super.hashCode();
    	return 0;
    }   
}

