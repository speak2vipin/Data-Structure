package com.vipin.algorithms.array;

public class KthMaxElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.toBinaryString(-4));
		System.out.println(-10>>1);
	}

	public int findKthLargest(int[] nums, int k) {
		return findK(nums, nums.length - k, 0, nums.length - 1);
	}

	private int findK(int[] nums, int k, int start, int end) {
		int parti = nums[start], i = start, m = start;
		for (int j = start + 1; j <= end; j++) {
			if (nums[j] > parti)
				continue;
			if (nums[j] <= parti) {
				swap(nums, ++i, j);
				if (nums[j] != parti)
					swap(nums, m++, i);
			}
		}
		if (k >= m && k <= i)
			return nums[k];
		else if (k < m)
			return findK(nums, k, start, m - 1);
		else
			return findK(nums, k, i + 1, end);
	}

	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
