package com.vipin.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
    	
        int n = nums.length;
        int result[] = new int[n];
        
        // Calculate prefix products and store them in the nums array
        int prefixProduct = 1;
        for (int i = 0; i < n; i++) {
        	result[i] = prefixProduct;
            prefixProduct *= nums[i];
        }
        
        // Calculate suffix products and multiply them with prefix products stored in nums
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
        	result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        System.out.println("Product of elements except self: " + Arrays.toString(result));
        int nums1[] = {0, 0, 1, 0,  0, 0, 1, 1};
        System.out.println(findMaxLength(nums1));
    }
    
    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer>map = new HashMap<>();
        int total = 0;
        int len = 0;
        for(int i=0; i<n; i++) {
            if(nums[i]==0) {
                total += -1;
            } else {
                total += 1;
            }
            if(total==0) {
                len = Math.max(len, i+1);
            }
            if(map.get(total)==null) {
                map.put(total, i);
            } else {
                len = Math.max(len, i-map.get(map));
            }
        }
        return len;
        
    }
}

