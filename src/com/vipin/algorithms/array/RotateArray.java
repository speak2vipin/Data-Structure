package com.vipin.algorithms.array;

import java.util.Scanner;

public class RotateArray {

	public static void main(String[] args) {
		// YOUR CODE GOES HERE
		// Please take input and print output to standard input/output (stdin/stdout)
		// DO NOT USE ARGUMENTS FOR INPUTS
		// E.g. 'Scanner' for input & 'System.out' for output
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		B = B % N;
		int temp;
		for (int i = 0, j = N - B; i < B; i++, j++) {
			temp = A[i];
			A[i] = A[j];
			A[j] = temp;
		}
		for (int k = 0; k < N; k++) {
			System.out.print(A[k] + " ");
		}

	}
}
