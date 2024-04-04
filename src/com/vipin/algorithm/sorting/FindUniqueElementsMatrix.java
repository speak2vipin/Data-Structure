package com.vipin.algorithm.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindUniqueElementsMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FindUniqueElementsMatrix f = new FindUniqueElementsMatrix();
		int nums[] = { 1, 3, 4, 1, 2, 3, 1 };
		System.out.println(f.findMatrix(nums));

	}

	public List<List<Integer>> findMatrix(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		List<List<Integer>> ans = new ArrayList<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		List<Integer> discard = new ArrayList<>();
		int size = map.size();
		while (discard.size() < size) {
			List<Integer> temp = new ArrayList<>();
			for (Integer key : map.keySet()) {
				int val = map.get(key);
				if (val > 0 && !discard.contains(key)) {
					temp.add(key);
					if (val == 1) {
						discard.add(key);
					} else {
						map.put(key, map.get(key) - 1);
					}
				}
			}
			ans.add(temp);
		}
		return ans;

	}

}
