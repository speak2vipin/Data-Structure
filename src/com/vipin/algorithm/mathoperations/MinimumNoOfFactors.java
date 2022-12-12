package com.vipin.algorithm.mathoperations;

import java.util.HashSet;
import java.util.Set;

public class MinimumNoOfFactors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solve(12));

	}

	public static int solve(int A) {
		int spf[] = new int[A+1];
		spf[0] = -1;
		spf[1] = -1;
		for (int i = 2; i <= A; i++) {
			if (spf[i] == 0) {
				for (int j = i; j <= A; j = j + i) {
					if (spf[j] == 0) {
						spf[j] = i;
					}
				}
			}
		}
		int ans = 0;
		for (int i = 2; i <= (A); i++) {
			Set<Integer> set = new HashSet();
			int divisor1 = i / spf[i];
			if(divisor1==1) {
				continue;
			}
			if (divisor1 == spf[divisor1]) {
				set.add(spf[i]);
				set.add(divisor1);
			} else {
				set.add(spf[i]);
				while (divisor1 != spf[divisor1]) {
					set.add(spf[divisor1]);
					divisor1 = divisor1 / spf[divisor1];
				}
				set.add(spf[divisor1]);
			}
			if (set.size() == 2) {
				ans++;
			}
		}
		return ans;
	}

}
