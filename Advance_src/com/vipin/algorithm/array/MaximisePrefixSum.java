package com.vipin.algorithm.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximisePrefixSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {-1,-2,0};
		MaximisePrefixSum m = new MaximisePrefixSum();
		System.out.println(m.maxScore(nums));

	}
	
	public int maxScore(int[] nums) {
        List<Integer>positive = new ArrayList<Integer>();
        List<Integer>negative = new ArrayList<Integer>();
        int N = nums.length;
        int count = 0;
        for(int i=N-1; i>-1; i--) {
            if(nums[i]>0){
                positive.add(nums[i]);
            } else {
                negative.add(nums[i]);
            }
        }
        Collections.sort(positive);
        Collections.sort(negative, Collections.reverseOrder());
        int pSize = positive.size();
        int j=0;
        for(int i=0; i<N; i++) {
            if(i<pSize)
                nums[i] = positive.get(i);
            else {
                nums[i] = negative.get(j++);
            }
        }
        if(nums[0]>0) {
            count++;
        }
    
        for(int i=1; i<N; i++) {
            nums[i] = nums[i]+nums[i-1];
            if(nums[i]>0) {
                count++;
            }
        }
        return count;
    }
	
}
