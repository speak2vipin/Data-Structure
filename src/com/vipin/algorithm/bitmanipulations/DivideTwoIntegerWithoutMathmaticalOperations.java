package com.vipin.algorithm.bitmanipulations;

public class DivideTwoIntegerWithoutMathmaticalOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(8,2));

	}

	public static int divide(int A, int B) {
		long ans = 0; // long is important overflow -- > ans = ans + (1<<31) (line 10)
		boolean neg = ((A < 0) ^ (B < 0)); // either shud be true
		long a = Math.abs(A * 1L); // Math.abs(A) -- > overflow (A == > -2147483648)
		long b = Math.abs(B * 1L); // long is important overflow -- > (b<<31)
		for (int i = 31; i >= 0; i--) {
			if ((b << i) <= a) {
				a = a - (b << i);
				ans += (1L << i); // overflow if (1<<31) == > 2147483648  4294967296
				if (ans >= Integer.MAX_VALUE)
					return (neg ? Integer.MIN_VALUE : Integer.MAX_VALUE);
			}
		}
		return (int) (neg ? ans * -1 : ans);
	}

}
