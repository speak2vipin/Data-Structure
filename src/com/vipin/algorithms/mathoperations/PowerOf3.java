package com.vipin.algorithms.mathoperations;

public class PowerOf3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = (int)Math.pow(3, 19);
		int y = (int)Math.pow(2, 31)-1;
		System.out.println(y);
		//1162261467
		System.out.println(i);
		System.out.println(Math.pow(3, 19));
	}

	public boolean isPowerOfThree(int n) {
		return ((n ^ n - 1) == 1 && n % 5 != 0) ? true : false;
	}

}
