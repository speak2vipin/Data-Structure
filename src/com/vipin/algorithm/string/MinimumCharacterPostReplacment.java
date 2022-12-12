package com.vipin.algorithm.string;

import java.util.Arrays;

public class MinimumCharacterPostReplacment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("abcabbccd", 3));

	}

	public static int solve(String A, int B) {
		int charCount[] = new int[26];
		char c;
		for (int i = 0; i < A.length(); i++) {
			c = A.charAt(i);
			charCount[c-'a'] = charCount[c-'a'] + 1;
			// charCount[c][1] =
			// 2-d array sort
			// sort Map with values
		}
		Arrays.sort(charCount);
		for (int i = 0; i < 26; i++) {
			if (B > 0) {
				if (charCount[i] > 0) {
					if (charCount[i] > B) {
						charCount[i] = charCount[i] - B;
						B = 0;
					} else {
						B -= charCount[i];
						charCount[i] = 0;
					}
				}
			} else {
				break;
			}
		}
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (charCount[i] > 0) {
				count++;
			}
		}
		return count;
	}
}
