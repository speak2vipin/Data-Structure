package com.vipin.algorithm.heaps;

import java.util.*;

public class MinmizeMaximumOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {13,13,20,0,8,9,9};
		System.out.println(minimizeArrayValue1(nums));
	}

	public static int minimizeArrayValue(int[] nums) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int x[], int y[]) {
				return y[0] - x[0];
			}
		});
		int N = nums.length;
		for (int i = 1; i < N; i++) {
			pq.offer(new int[] { nums[i], i });
		}
		int ans = Integer.MIN_VALUE;
		while (!pq.isEmpty()) {
			int top[] = pq.poll();
			int index = top[1];
			System.out.println(top[0] + " " + top[1]);

			if (nums[index] == top[0] && nums[index - 1] < nums[index]) {
				nums[index] = nums[index] - 1;
				nums[index - 1] = nums[index - 1] + 1;
				pq.offer(new int[] { nums[index], index });
				if(index-1!=0)
					pq.offer(new int[] { nums[index - 1], index-1 });
			}
		}
		for (int num : nums) {
			ans = Math.max(ans, num);
		}
		return ans;
	}
	
	
	    public static int minimizeArrayValue1(int[] nums) {
	        // Initialize answer and the prefix sum.
	        double answer = 0, prefixSum = 0;   
	        // 3,7,1,6

	        // Iterate over nums, update prefix sum and answer.
	        for (int i = 0; i < nums.length; ++i) {
	            prefixSum += nums[i];
	            answer = Math.max(answer, Math.ceil(prefixSum/(i + 1)));
	        }

	        return (int)answer;
	    
	}
}
