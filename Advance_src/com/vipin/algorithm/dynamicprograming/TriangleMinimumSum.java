package com.vipin.algorithm.dynamicprograming;

import java.util.ArrayList;

public class TriangleMinimumSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>> ();
		ArrayList<Integer> x1 = new ArrayList<Integer>();
		x1.add(2);
		ArrayList<Integer> x2 = new ArrayList<Integer>();
		x2.add(3); x2.add(15);
		ArrayList<Integer> x3 = new ArrayList<Integer>();
		x3.add(20); x3.add(45); x3.add(3);
		ArrayList<Integer> x4 = new ArrayList<Integer>();
		x4.add(1); x4.add(1); x4.add(100); x4.add(20);
		a.add(x1);
		a.add(x2);
		a.add(x3);
		a.add(x4);
		
		TriangleMinimumSum t = new TriangleMinimumSum();
		System.out.println(t.minimumTotal(a));
		System.out.println(t.minimumTotalImprovised(a));

	}
	
	public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int row = a.size();
        
        Integer[][] A = new Integer[row][];
        for(int i=0; i<row; i++) {
        	ArrayList<Integer> temp = a.get(i);
        	int column = temp.size();
        	Integer tempArray[] = new Integer[column];
            for(int j=0; j<column; j++) {
                tempArray[j] = temp.get(j);
            }
            A[i] = tempArray;
        }
        Integer dp[][] = new Integer[row][];
        int column = a.get(a.size()-1).size();
        Integer tempArray[] = new Integer[column];
        for(int j=0; j<column; j++) {
        	tempArray[j] = A[row-1][j];
        }
        dp[row-1] = tempArray;
        for(int i=row-2; i>-1; i--) {
        	int tempColumn = a.get(i).size();
        	Integer tempArray1[] = new Integer[tempColumn];
            for(int j=0; j<tempColumn; j++) {
            	tempArray1[j] = A[i][j] + Math. min(dp[i+1][j], dp[i+1][j+1]);
            } 
            dp[i] = tempArray1;
        }
        return dp[0][0];
	}
	
	
	public int minimumTotalImprovised(ArrayList<ArrayList<Integer>> ax) {
		int r = ax.size();
		for(int i=r-2; i>-1; i--) {
			int c = ax.get(i).size();
			for(int j=0; j<c; j++) {
				ax.get(i).set(j, ax.get(i).get(j) + Math.min(ax.get(i+1).get(j), ax.get(i+1).get(j+1)));
			}
		}
		return ax.get(0).get(0);	
	}
	
	


	   

}
