package com.vipin.algorithm.bitmanipulations;

public class MaxXORContest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(4, 6));

	}

	public static int solve(int A, int B) {
		int num = 0;
		for (int i = 31; i > -1; i--) {
			if (((A >> i) & 1) == 1) {
				if (B > 0) {
					num += (1 << i);
					B--;
				} else {
					return num;
				}
			}
		}
		int ans = num;
		for (int j = 0; B > 0; j++) {
			if (((1 << j) & num) == (1 << j)) {
				continue;
			} else {
				ans = ans + (1 << j);
				System.out.println(ans);
				B--;
			}
		}
		return (int) ans;
	}

}
