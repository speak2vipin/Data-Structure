package com.vipin.algorithm.bitmanipulations;

public class CompressBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 1, 1 };
		System.out.println(compressBits(A));
		System.out.println(addBinary("100", "110010"));

	}

	public static int compressBits(int[] A) {
		int N = A.length;
		int temp1, temp2;
		for (int i = 0; i < N - 1; i++) {
			temp1 = A[i];
			temp2 = A[i + 1];
			A[i] = temp1 & temp2;
			A[i + 1] = temp1 | temp2;
		}
		int res = A[0];
		for (int i = 1; i < N; i++) {
			res = res ^ A[i];
		}
		return res;
	}

	public static String addBinary(String a, String b) {
		int M = a.length();
		int N = b.length();
		int min = Math.min(M, N);
		char bc, ac;
		char carry = '0';
		String result = "";
		int i;
		for (i = min - 1; i > -1; i--) {
			ac = a.charAt(i);
			bc = b.charAt(i);
			if (ac == '0') {
				if (bc == '0') {
					if (carry == '0') {
						result = '0' + result;
					} else {
						result = '1' + result;
						carry = '0';
					}

				} else {
					if (carry == '0') {
						result = '1' + result;
					} else {
						result = '0' + result;
						carry = '1';
					}
				}
			} else if (ac == '1') {
				if (bc == '0') {
					if (carry == '0') {
						result = '1' + result;
					} else {
						result = '0' + result;
						carry = '1';
					}
				} else {
					if (carry == '0') {
						result = '0' + result;
						carry = '1';
					} else {
						result = '1' + result;
						carry = '1';
					}
				}
			}
		}
			String temp = min == a.length() ? b : a;
			
			for (i = temp.length()-1-min; i >-1; i--) {
				if (temp.charAt(i) == '0') {
					if (carry == '0') {
						result = '0' + result;
					} else {
						result = '1' + result;
						carry = '0';
					}
				} else if (temp.charAt(i) == '1') {
					if (carry == '0') {
						result = '1' + result;
					} else {
						result = '0' + result;
						carry = '1';
					}
				}
			}
			result = carry == '1' ? '1' + result : result;
		
		return result;
	}

}
