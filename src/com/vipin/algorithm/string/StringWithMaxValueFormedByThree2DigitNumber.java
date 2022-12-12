package com.vipin.algorithm.string;

public class StringWithMaxValueFormedByThree2DigitNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(11, 12, 13));
		System.out.println(solve(11, 11, 13));
		System.out.println(solve(11, 11, 11));
		System.out.println(solve(25, 62, 25));

	}

	public static int solve(int A, int B, int C) {
		int max1 = A > B ? (A > C ? A : C) : (B > C ? B : C);
		int max2 = A < B ? (A < C ? A : C) : (B < C ? B : C);
		int max3 = A == max1 && B == max2 ? C
				: (A == max1 && C == max2 ? B
						: (B == max1 && A == max2 ? C
								: (B == max1 && C == max2 ? A
										: (C == max1 && A == max2 ? B : (C == max1 && B == max2 ? A : A)))));

		return max2 * 10000 + max3 * 100 + max1;
	}
	
	public int solve(int A) {
      
        return A%400==0 ? 1 : (A%4==0 && A%100!=0 ?1:0);
    }

}
