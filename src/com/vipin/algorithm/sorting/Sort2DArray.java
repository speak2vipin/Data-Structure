package com.vipin.algorithm.sorting;

import java.util.Arrays;

public class Sort2DArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]input = {{100,1},{10,50},{5,500}};
		sortArray(input);

	}
	
	
	static int[][] sortArray(int[][] temp) {
		Arrays.sort(temp, (A,B) ->  A[0]-B[0]);
		//Arrays.sort(array, ( a, b) -> a[1] - b[1]);
		//Arrays.sort(myArr, (a, b) -> Double.compare(a[0], b[0]));
		return temp;
	}

}
