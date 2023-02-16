package com.vipin.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubarrayWithSumEqualtoK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 1,1,1,-1,-1,1};
		SubarrayWithSumEqualtoK s = new SubarrayWithSumEqualtoK();
		System.out.println(s.subarraySum(A, 2));
		
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		Integer[][]X = new Integer[4][];
		X[0] = a.get(0).toArray(new Integer[4]);
	}

	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0, res = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k))
				res += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return res;
	}
	
	

}
