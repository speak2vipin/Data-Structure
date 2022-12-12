package com.vipin.algorithm.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2,3,1};
		//containsNearbyAlmostDuplicateN(nums, 1, 2);
		int [] nums1 = {2147483640,2147483641};
		System.out.println(containsNearbyAlmostDuplicateE(nums1, 1, 100));
				
	}

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
	
	public static boolean containsNearbyAlmostDuplicateN(int[] nums, int k, int t) {
	    if (nums == null || nums.length == 0) return false;
	    TreeSet<Long> set = new TreeSet<>();
	    set.add((long) nums[0]);
	    for (int i = 1; i < nums.length; i++) {
	        if (i > k) set.remove((long) nums[i - k - 1]);
	        long left = (long) nums[i] - t;
	        long right = (long) nums[i] + t;
	        if (left <= right && !set.subSet(left, right + 1).isEmpty()) return true;
	        set.add((long) nums[i]);
	    }
	    return false;
	}
	
	public static boolean containsNearbyAlmostDuplicateE(int[] nums, int k, int t) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(nums[0]);
        for(int i=1; i<nums.length;i++) {
            if(i>k) {
                treeSet.remove(nums[i-k-1]);
            }
            int left = nums[i]-t;
            int right = nums[i]+t;
            if(!treeSet.subSet(left, right+1).isEmpty()) {
                return true;
            }
            treeSet.add(nums[i]);
        }
        return false;
    }
}
