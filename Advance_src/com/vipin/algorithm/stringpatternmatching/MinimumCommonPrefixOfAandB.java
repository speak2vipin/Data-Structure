package com.vipin.algorithm.stringpatternmatching;

public class MinimumCommonPrefixOfAandB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "tom";
		String B = "reddy";
		System.out.println(smallestPrefix(A, B));
	}

	public static String smallestPrefix(String A, String B) {
		StringBuilder sb = new StringBuilder("");
		int l1 = A.length();
		int l2 = B.length();
		int i = 0, j = 0;
		while (i < l1 && A.charAt(i)> B.charAt(j)) {
			sb.append(A.charAt(i++));
		}
		while(i<l1 && A.charAt(i) < B.charAt(j)) {
			sb.append(A.charAt(i++));
		}
		if(i==0) {
			sb.append(A.charAt(i));
		}
		if (j == 0) {
			sb.append(B.charAt(j));
		}
		return sb.toString();
	}

}
