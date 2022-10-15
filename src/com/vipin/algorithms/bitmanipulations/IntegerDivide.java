package com.vipin.algorithms.bitmanipulations;

public class IntegerDivide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(0, 1));
		System.out.println(divide(10, 3));
		System.out.println(divide(15, 5));
		System.out.println(divide(Integer.MAX_VALUE, -1));
		System.out.println(divide(-2147483648, -10000000));

	}

	public static int divide(int A, int B) {// Use Quotient * Divisor <= Divident
		long ans = 0;
		boolean sign = ((A < 0 && B > 0) || (A > 0 && B < 0)) ? true : false;
		long a = Math.abs(1l * A);
		long b = Math.abs(1l * B);
		for (int k = 31; k > -1; k--) {
			if ((1l << k) * b <= a) {
				ans += 1l << k;
				a -= (1l << k) * b;
			}
		}
		if (ans >= Integer.MAX_VALUE)
			return (sign ? -Integer.MIN_VALUE : Integer.MAX_VALUE);
		if (sign)
			return (int) ans * -1;
		return (int) ans;
		//return (int) (ans * sign);
	}

}
