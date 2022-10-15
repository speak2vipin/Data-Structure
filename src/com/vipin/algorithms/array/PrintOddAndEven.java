package com.vipin.algorithms.array;

import java.lang.*;
import java.util.*;

public class PrintOddAndEven {
	public static void main(String[] args) {
		// YOUR CODE GOES HERE
		// Please take input and print output to standard input/output (stdin/stdout)
		// DO NOT USE ARGUMENTS FOR INPUTS
		// E.g. 'Scanner' for input & 'System.out' for output
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int len = sc.nextInt();
			int array[] = new int[len];
			int oddC = 0;
			int evenC = 0;
			for (int j = 0; j < len; j++) {
				array[j] = sc.nextInt();
				if (array[j] % 2 == 0) {
					evenC++;
				} else {
					oddC++;
				}
			}
			int resultOdd[][] = getArray(array, oddC, evenC);
			
			for (int[] x : resultOdd) {
				for(int x1 : x) {
					System.out.print(x1+" ");
				}
				System.out.print('\n');
			}
		

		}
	}

	static int[][] getArray(int[] A, int odd, int even) {
		int oddArray[] = new int[odd];
		int evenArray[] = new int[even];
		int indexOdd = 0;
		int indexEven = 0;
		
		for (int i : A) {
			if (i % 2 != 0) {
				oddArray[indexOdd] = i;
				indexOdd++;
			} else {
				evenArray[indexEven] = i;
				indexEven++;
			}
		}
		int[][] result = { oddArray, evenArray};
		return result;
	}

}
