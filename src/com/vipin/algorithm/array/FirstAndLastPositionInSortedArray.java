package com.vipin.algorithm.array;

public class FirstAndLastPositionInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]nums = {8,8};
		int target = 8;
		System.out.println(searchRange(nums, target));
	}
	
	public static int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        if(nums.length!=0) {
            start = minIndex(nums, target);
            end = maxIndex(nums, target);
        } 
        int result[] = {start, end};
        return result;
       
    }
    
	static int minIndex(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int mid = -1;
		int index = -1;
		while (start <= end) {
			mid = (start + end) / 2;
			if (nums[mid] >= target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
			if(nums[mid]==target) {
				if(index==-1)
					index = mid;
				else
					index = mid<index ? mid: index;
			}
		}
		return index;
	}

	static int maxIndex(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int mid = -1;
		int index = -1;
		while (start <= end) {
			mid = (start + end) / 2;
			if (nums[mid] <= target) {
				start = mid + 1;		
			} else {
				end = mid - 1;
			}
			if(nums[mid]==target) {
				index = mid>index ? mid: index;
			}
		}
		return index;
	}

}
