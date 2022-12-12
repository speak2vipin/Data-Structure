package com.vipin.algorithm.bitmanipulations;

import java.util.ArrayList;
import java.util.List;

public class MinimumXOR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]A = { 12, 4, 6, 2 };
		System.out.println(-4%4);
		System.out.println(findMinXor(A));
	}

	public static int findMinXor(int[] A) {
		List<Integer> inputs = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			inputs.add(A[i]);
		}
		return minXor(inputs, 31);
	}

	static int minXor(List<Integer> inputs, int index) {
		int size = inputs.size();
		if (size < 2) {
			return Integer.MAX_VALUE;
		}
		if (size == 2) {
			return inputs.get(0) ^ inputs.get(1);
		}
		if (index == 0) {
			int ans = 0;
			for (Integer temp : inputs) {
				ans ^= temp;
			}
			return ans;
		}
		List<Integer> list0 = new ArrayList<Integer>();
		List<Integer> list1 = new ArrayList<Integer>();
		for (Integer temp : inputs) {
			if (((temp >> index) & 1) == 1) {
				list1.add(temp);
			} else {
				list0.add(temp);
			}
		}
		int output_1 = minXor(list0, index - 1);
		int output_2 = minXor(list1, index - 1);
		return Math.min(output_1, output_2);
	}

}
