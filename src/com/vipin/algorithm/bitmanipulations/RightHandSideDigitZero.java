package com.vipin.algorithm.bitmanipulations;

public class RightHandSideDigitZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(93, 4));
	}
	
	public static long solve(long A, int B) {
        int i = 0;
        int temp = 1;
        while(B!=0) {
            temp = 1<<i;
            A = (A^temp) < A ? A^temp : A;
            B--;
            i++;
        }
        return A;
    }

}
