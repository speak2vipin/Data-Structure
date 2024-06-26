package com.vipin.algorithm.array;

import java.util.HashSet;
import java.util.Set;

public class special_positions_in_a_binary_matrix {
	
	public static void main(String[] args) {
		int a[][] = {{0,0,0,0,0,1,0,0},
		          	 {0,0,0,0,1,0,0,1},
		        	 {0,0,0,0,1,0,0,0},
		        	 {1,0,0,0,1,0,0,0},
		        	 {0,0,1,1,0,0,0,0}};
		System.out.println(numSpecial(a));
		
	}
	public static int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;
        Set<Integer>rowset = new HashSet<>();
        Set<Integer>colset = new HashSet<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j]==1 && !rowset.contains(i) && !colset.contains(j)) {
                    
                    int row = 0, col = j;
                    int oneCountRow = 0;
                    int oneCountCol = 0;
                    
                    while(row<m) {
                        if(mat[row][col]==1) {
                            oneCountRow++;
                        }
                        row++;
                    }
                    
                    row = i; col = 0;
                    while(col<n) {
                        if(mat[row][col]==1) {
                            oneCountCol++;
                        }
                        col++;
                    }
                    
                    if(oneCountRow==1 && oneCountCol==1) {
                        ans++;
                    }
                    rowset.add(i);
                    colset.add(j);
                } 
            }
        }
        return ans;
    }

}
