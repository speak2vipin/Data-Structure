package com.vipin.algorithm.array;

public class LengthOfLongestConsecutiveOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(solve("111011101"));
		//System.out.println(solve("111000"));
		//System.out.println(solve("1110111"));
		//System.out.println(solve("000000000000000"));
		//System.out.println(solve("00100"));
		//System.out.println(solve("1001110110000111000011"));
		//System.out.println(solve("10010011001100010000110000001"));
		System.out.println(solve("0111000000000"));
	}

	public static int solve(String A) {
		boolean isAllZero = true;
		char[] aArray = A.toCharArray();
		int N = A.length();
		int[] binary = new int[N];
		int oneCount = 0;

		for (int i = 0; i < N; i++) {
			binary[i] = aArray[i] - '0';
			if(isAllZero && binary[i]==1) {
				isAllZero = false;
			}
			if(binary[i]==1) {
				oneCount++;
			}
			
		}
		if(isAllZero) {
			return 0;
		}
		int prefix[] = new int[N];
		int suffix[] = new int[N];
		prefix[0] = binary[0];
		for (int i = 1; i < N; i++) {
			if (binary[i] == 1) {
				prefix[i] = prefix[i - 1] + 1;
				
			} else {
				prefix[i] = 0;
			}
		}
		suffix[N - 1] = binary[N - 1];
		for (int i = N - 2; i > -1; i--) {
			if (binary[i] == 1) {
				suffix[i] = suffix[i + 1] + 1;
			} else {
				suffix[i] = 0;
			}
		}
		// Sliding window to find 101 pattern
		/*
		 * int count = 0; int j = 0; boolean yes = false; for (int i = 2; i < N; i++) {
		 * if (binary[i - 2] == 1 && binary[i - 1] == 0 && binary[i] == 1) { i++;
		 * while(i<N) { if(binary[i]==1) { i++; continue; } else { i++; while(i<N) {
		 * if(binary[i]==1) { i = N; yes = true; break; } i++; } } } } }
		 */
		
		
		int max = 0;
		int temp = 0;
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				temp = suffix[1];
			} else if (i == N - 1) {
				temp = prefix[N - 2];
			} else {
				temp = prefix[i - 1] + suffix[i + 1];
			}
			if(temp<oneCount) {
				temp = temp+1;
			}

			max = Math.max(temp, max);
		}
		int sum = Integer.MAX_VALUE;
		return max;
	}

}
