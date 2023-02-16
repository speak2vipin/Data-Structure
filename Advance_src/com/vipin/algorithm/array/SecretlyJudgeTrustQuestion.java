package com.vipin.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecretlyJudgeTrustQuestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecretlyJudgeTrustQuestion A= new SecretlyJudgeTrustQuestion();
		int[][]trust = {{1,3}};
		System.out.println(A.findJudge(3, trust));
	}

	public int findJudge(int n, int[][] trust) {
		boolean[] people = new boolean[n+1];
		Arrays.fill(people, true);
		int ans = -1;

		for (int[] t : trust) {
			people[t[0]] = false;
		}

		for (int i = 1; i < n+1; i++) {
			if (people[i]) {
				if (ans == -1) {
					ans = i;
				} else {
					ans = -1;
				}
			}

		}
		return ans;
	}

}
