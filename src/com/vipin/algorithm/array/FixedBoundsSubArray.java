package com.vipin.algorithm.array;

public class FixedBoundsSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]nums = {1,3,5,2,7,5};
		int minK = 1, maxK = 5;
		FixedBoundsSubArray f = new FixedBoundsSubArray();
		System.out.println(f.countSubarrays(nums, minK, maxK));
	}
	
	public long countSubarrays(int[] nums, int minK, int maxK) {
        int N = nums.length;
        long ans = 0;
        long leftBound = -1;
        long minNum = -1;
        long maxNum = -1;
        for(int i=0; i<N; i++) {
            if(nums[i]>maxK || nums[i]<minK) {
                leftBound = i;
            }
            if(nums[i]==minK) {
                minNum = i;
            }
            if(nums[i]==maxK) {
                maxNum = i;
            }
            ans = ans + Math.max(0, Math.min(minNum, maxNum)-leftBound);
        }
        return ans; 
    }

}
