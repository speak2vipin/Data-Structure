package com.vipin.algorithm.array;

import java.util.HashMap;
import java.util.HashSet;

public class SlidingWindowNumOfDiffElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {5,5,5,5};
		System.out.println(countCompleteSubarrays(A));
	}

	public static int countCompleteSubarrays(int[] nums) {
		int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int k = set.size();
       // int i = 0;
       // int j = 0;
        int n = nums.length;
        int window = 0;
        int j = 0;
        
      
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            
            while(j<n && window<k) {
                if(map.get(nums[j])==null || map.get(nums[i])==0) {
                    window++;
                }
                map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
                j++;
            }
            if(window==k) {
                count += (n-j+1);
            }
            map.put(nums[i], map.get(nums[i])-1);
            if(map.get(nums[i])==0) {
                window--;
            }
        }
        return count;
        
    }
}
