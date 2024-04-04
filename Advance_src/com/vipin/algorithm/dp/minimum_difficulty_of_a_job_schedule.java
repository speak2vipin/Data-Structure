package com.vipin.algorithm.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class minimum_difficulty_of_a_job_schedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int j[] = { 11, 111, 22, 222, 33, 333, 44, 444 };
		int d = 6;
		int i[] = { 6, 5, 4, 3, 2, 1 };
		int k = 2;
		//System.out.println(minDifficulty(j, d));
		System.out.println(minDifficulty(i, k));

	}

	static int dp[][] = null;
	static int max = Integer.MIN_VALUE;

	public static int minDifficulty(int[] jobDifficulty, int d) {
		int n = jobDifficulty.length;
		if (n < d) {
			return -1;
		}
		for (int job : jobDifficulty) {
			max = Math.max(job, max);
		}

		dp = new int[d + 1][n];
		for (int temp[] : dp) {
			Arrays.fill(temp, -1);
		}
		return helper(jobDifficulty, d, 0);
	}

	static int helper(int[] jobDifficulty, int d, int index) {
		if(d==1) {
            int max = 0;
            while(index<jobDifficulty.length) {
                max = Math.max(max, jobDifficulty[index++]);
            }
            return max;
        }
		if (dp[d][index] != -1) {
			return dp[d][index];
		}
		int left = 0;
		int res = Integer.MAX_VALUE;
		for (int i = index; i < jobDifficulty.length - d + 1; i++) {
			left = Math.max(left, jobDifficulty[i]);
			int right = helper(jobDifficulty, d - 1, i + 1);
			res = Math.min(res, left + right);
		}
		Map map = Collections.EMPTY_MAP;
		map.keySet();
		return dp[d][index] = res;
	}

}
