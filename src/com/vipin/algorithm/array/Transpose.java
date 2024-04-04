package com.vipin.algorithm.array;

public class Transpose {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = {{1,2,3},{4,5,6}};
		
		for(int x[] : transpose(a)) {
			for(int value : x) {
				System.out.print(value);
			}
			System.out.println();
		}
	}
	
	public static int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int transpose[][] = new int[m][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                transpose[j][i] = matrix[i][j];
 
            }
        }
        return transpose;
    }

}
