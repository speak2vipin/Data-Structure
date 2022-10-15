package com.vipin.algorithms.string;

import java.lang.*;
import java.util.*;

public class ReverseStringWithRecurssion {

	public static void main(String[] args) {
		// YOUR CODE GOES HERE
		// Please take input and print output to standard input/output (stdin/stdout)
		// DO NOT USE ARGUMENTS FOR INPUTS
		// E.g. 'Scanner' for input & 'System.out' for output
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		char[] c = input.toCharArray();
		int N = input.length();
		System.out.print(new String(printReverseString(c, 0, N-1)));
		sc.close();
	}

	static char[] printReverseString(char[] c, int left, int right) {
		if (left >= right) {
			return c;
		}
		char temp = c[left];
		c[left] = c[right];
		c[right] = temp;
		return printReverseString(c, left + 1, right - 1);

	}

}
