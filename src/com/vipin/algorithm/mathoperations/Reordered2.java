package com.vipin.algorithm.mathoperations;

import java.util.Arrays;

public class Reordered2 {

	public static void main(String[] args) {
		
	}
	
	public static boolean reorderedPowerOf2(int n) {
		/*
		 * while((n&1) != 1) { n = n>>1; }
		 */
		// return (n>>1)==0;

		String s1 = Integer.toString(n);
		char[] c1 = s1.toCharArray();
		Arrays.sort(c1);
		s1 = new String(c1);
		for (int i = 0; i < 32; i++) {
			char[] c2 = Integer.toString(i << 1).toCharArray();
			Arrays.sort(c2);
			String s2 = new String(c2);
			if (s1.equals(s2)) {
				return true;
			}
		}
		return false;
	}
}
