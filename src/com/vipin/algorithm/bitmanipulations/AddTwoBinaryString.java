package com.vipin.algorithm.bitmanipulations;

public class AddTwoBinaryString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("100", "11"));

	}

	public static String addBinary(String A, String B) {
		A = new StringBuffer(A).reverse().toString();
		B = new StringBuffer(B).reverse().toString();
		int l1 = A.length();
		int l2 = B.length();
		int l = Math.min(l1, l2);
		int lMax = Math.max(l1, l2);
		String ans = "";
		char carry = '\u0000';
		for (int i = 0; i < l; i++) {
			if (A.charAt(i) == '1' && B.charAt(i) == '1') {
				if (carry == '1') {
					ans += '1';
				} else {
					ans += '0';
				}
				carry = '1';
			} else if (A.charAt(i) == '0' && B.charAt(i) == '0') {
				if (carry == '1') {
					ans += '1';
					carry = '0';
				} else {
					ans += '0';
				}
			} else {
				if (carry == '1') {
					ans += '0';
					carry = '1';
				} else {
					ans += '1';
				}
			}
		}
		String lMaxString = l1 == l ? B : A;
		for (int i = l; i < lMax; i++) {
			if (lMaxString.charAt(i) == '0') {
				if (carry == '1') {
					ans += '1';
					carry = '0';
				} else {
					ans += '0';
				}
			} else if (lMaxString.charAt(i) == '1') {
				if (carry == '1') {
					ans += '0';
					carry = '1';
				} else {
					ans += '1';
				}
			}
		}
		if (carry == '1') {
			ans += '1';
		}
		return new StringBuffer(ans).reverse().toString();
	}

	public String solve(int[] A) {

		int temp = A[0];
		int N = A.length;
		for (int i = 1; i < N; i++) {
			temp ^= A[i];
		}
		String response = "No";
		if ((temp % 2) == 0) {
			response = "Yes";
		}
		return response;

	}

	public int divide(int A, int B) {
			//method
			// A/B => 125/5 ==> 
			// 125 = 5*25 ==> 5 * ( 2^4 * (1) + 2^3 * (1) + 2^2* (0) + 2^1 * (0)+ 2^0 * (1) );
			boolean sign = (A<0) ^ (B<0);
			long answer = 0 L;
			long tempA = Math.abs(A * 1 L);
			long tempB = Math.abs(B * 1 L);

			for (int i = 31; i >= 0; i--) {
				long power = (long) tempB<< i;
				while (power<= tempA) {
					tempA -= power;
					answer += (1 L<< i);
				}
			}
			if (answer >= Integer.MAX_VALUE)
				return (sign ? -Integer.MIN_VALUE : Integer.MAX_VALUE);
			if (sign)
				return (int) answer * -1;
			return (int) answer;
		}

}
