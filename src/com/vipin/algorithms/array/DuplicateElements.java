package com.vipin.algorithms.array;

import java.util.HashSet;
import java.util.Set;

public class DuplicateElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {99,99};
		System.out.println(containsNearbyDuplicate(nums, 2));
	}
	
	public static boolean containsNearbyDuplicate(int[] nums, int k)  {
        int j = nums.length;
        for(int i = 0; i<j; i++) {
            for(int l=i+1;l<j; l++) {
                if(nums[i] == nums[l] && Math.abs(i-l)<=k) {
                    return true;
                }
            }
        }
        return false;
    }
	
	public static boolean containsNearbyDuplicateI(int[] nums, int k)  {
        Set<Integer> numSet = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++) {
            if(i>k) {
                numSet.remove(nums[i-k-1]);
            }
            if(!numSet.add(nums[i])) {
                return true;
            }
        }
        return false;
    
    }

}
