package com.vipin.algorithms.array;

public class SerachInRotatedSortArrayUsingBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,5,6,7,0,1,2}; int target = 0;
		System.out.println(search(nums, target));
	}
	
	static public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = -1;
        while(start<end){
             mid = (start+end)/2;
            if(target == nums[mid]) {
                return mid;
            } else {
                if(nums[start]<nums[mid]) {
                    if(target<nums[start]) {
                    	start = mid+1;             
                        continue;
                    }
                    else {
                    	end=mid-1;
                        continue;
                    }
                } else {
                   if(target<nums[start]) {
                        end=mid-1;
                        continue;
                    }
                    else {
                        start = mid+1;  
                        continue;
                    }
                }
        }
        }
        
        return target==nums[start]?start:-1;
        
    }
    

}
