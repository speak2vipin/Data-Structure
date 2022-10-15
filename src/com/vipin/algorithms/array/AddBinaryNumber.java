package com.vipin.algorithms.array;

public class AddBinaryNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("111", "000"));
		System.out.println(addBinary("11", "000"));
		System.out.println(addBinary("11", "111"));
		System.out.println(addBinary("111", "1000"));
		
		System.out.println(addBinary("101011", "1000011011000000111100110"));
		System.out.println(byMethods("101011", "1000011011000000111100110"));

	}

	public static String addBinary(String A, String B) {
		int aLen = A.length();
		int bLen = B.length();
		String Ans = "";
		char carry = '0';
		String minTemp;
		String maxTemp;
		if(aLen>bLen) {
			minTemp = B;
			maxTemp = A;
		} else {
			minTemp = A;
			maxTemp = B;
		}
		
		int i,k;
		for (i = minTemp.length()-1, k = maxTemp.length()-1 ; i > -1; i--, k--) {
			if (minTemp.charAt(i) == '0' && maxTemp.charAt(k) == '0') {
				if (carry == '0') {
					Ans = '0' + Ans;
				} else {
					Ans = '1' + Ans;
					carry = '0';
				}
			} else if (minTemp.charAt(i) == '0' && maxTemp.charAt(k) == '1') {
				if (carry == '0') {
					Ans = '1' + Ans;
				} else {
					Ans = '0' + Ans;
					carry = '1';
				}
			} else if (minTemp.charAt(i) == '1' && maxTemp.charAt(k) == '0') {
				if (carry == '0') {
					Ans = '1' + Ans;
				} else {
					Ans = '0' + Ans;
					carry = '1';
				}
			} else if (minTemp.charAt(i) == '1' && maxTemp.charAt(k) == '1') {
				if (carry == '0') {
					Ans = '0' + Ans;
					carry = '1';
				} else {
					Ans = '1' + Ans;
					carry = '1';
				}
			}
		}
		
		for (; k > -1; k--) {
				if (maxTemp.charAt(k) == '0' && carry == '0') {
					Ans = '0' + Ans;
				} else if (maxTemp.charAt(k) == '1' && carry == '0') {
					Ans = '1' + Ans;
				} else if (maxTemp.charAt(k) == '0' && carry == '1') {
					Ans = '1' + Ans;
					carry = '0';
				} else if (maxTemp.charAt(k) == '1' && carry == '1') {
					Ans = '0' + Ans;
					carry = '1';
				}
		}
		
		if (carry == '1') {
			Ans = '1' + Ans;
		}
		return Ans;
	}
	
	static String byMethods(String A, String B) {

        int a = Integer.parseInt(A, 10);
        int b = Integer.parseInt(B, 2);

        int sum = a + b;
        String result = Integer.toBinaryString(sum);
        StringBuilder sb = new StringBuilder("RAM");
        System.out.println(sb.reverse());
        return result;
	}
	
	
}