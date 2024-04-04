package com.vipin.algorithm.sorting;

import java.util.Arrays;
import java.util.Collections;

public class Largest_Submatrix_With_Rearrangements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] = {{0,0,1},{1,1,1},{1,0,1}};
		System.out.println(largestSubmatrix(matrix));

	}
	
	public static int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        int currRow[] = matrix[0];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
            	if(i>0) {
	                if(matrix[i][j]==1) {
	                    currRow[j] = matrix[i][j] + currRow[j];
	                } else {
	                	currRow[j] = 0;
	                }
            	}
            }  
            Arrays.sort(currRow);
            
            for(int k=m-1; k>-1; k--) {
                ans = Math.max(ans, currRow[k] * (m-k));
            }
        }
        return ans;           
    }

}
