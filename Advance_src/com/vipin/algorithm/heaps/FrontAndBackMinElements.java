package com.vipin.algorithm.heaps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class FrontAndBackMinElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int costs[] = {25,65,41,31,14,20,59,
				   42,43,57,73,45,30,77,
				   17,38,20,11,17,65,55,
				   85,74,32,84};
		int k = 24;
		int candidates = 8;
		//System.out.println(totalCost(costs, k, candidates));
		
		int a[] = {1,3,6,4,1,2};
		int target = 2;
		System.out.println(maximumJumps(a, target));
		
		int num1[] = {8,7,4};
		int num2[] = {13,4,4};
		System.out.println(maxNonDecreasingLength(num1, num2));
	}

	public static long totalCost(int[] costs, int k, int candidates) {
		PriorityQueue<int[]> minHeapFront = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        PriorityQueue<int[]> minHeapBack = new PriorityQueue<>((a,b) -> a[1]-b[1] );
        int n = costs.length;
        Set<Integer> set = new HashSet<>();
        int i=0;
        for(i=0; i<candidates; i++) {
            minHeapFront.offer(new int[] {i, costs[i]});
        }
        int j = n-1;
        for(j = n-1; j>n-candidates-1; j--) {
            minHeapBack.offer(new int[] {j, costs[j]});
        }
        long res = 0;
        while(k>0 && !minHeapFront.isEmpty() && !minHeapBack.isEmpty()) {
            if(minHeapFront.peek()[1] > minHeapBack.peek()[1]) {
                int temp[] = minHeapBack.poll(); 
                if(set.contains(temp[0])) {
                    continue;
                }
                set.add(temp[0]);
                res += temp[1];
                if(j>-1) {
                    minHeapBack.offer(new int[] {j, costs[j]});
                    j--;
                }
            } else {
                int temp[] = minHeapFront.poll(); 
                if(set.contains(temp[0])) {
                    continue;
                }
                set.add(temp[0]);
                res += temp[1];
                if(i<n) {
                	minHeapFront.offer(new int[] {i, costs[i]});
                    i++;
                }
            }
            k--;
        }
        if(k>0) {
            PriorityQueue<int[]> fin = minHeapBack.isEmpty() 
                                            ? minHeapFront : minHeapBack;
            while(k>0) {
                int temp[] = fin.poll();
                if(!set.contains(temp[0])) {
                    res += temp[1];
                    set.add(temp[1]);
                    k--;
                }
                
            }
        }
        return res;
    }
	public static int maximumJumps(int[] nums, int target) {
        
        int n = nums.length;
        int dp[]= new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        return helper(nums, dp, 0, target, nums[0]); 
    }
    
    static int helper(int nums[], int dp[], int index, int target, int last) {
        if(index==dp.length-1) {
            return 0;
        }
        if(dp[index]!=Integer.MIN_VALUE) {
            return dp[index];
        }
        int res=-1;
        for(int i=index+1; i<dp.length; i++) {
            if(Math.abs(nums[i]-last)<=target) {
                int t = helper(nums, dp, i, target, nums[i]);
                if(t!=-1) {
                    res = Math.max(t+1, res);
                }
            }
        }
        return dp[index] = res;
    }
	 
	 public static int maxNonDecreasingLength(int[] nums1, int[] nums2) {
	        int n = nums1.length;
	        int nums3[] = new int[n];
	        for(int i=0; i<n; i++) {
	        	if(i==0)
	        		nums3[i] = Math.min(nums1[i], nums2[i]);
	        	else {
	        		int temp1 = Math.min(nums1[i], nums2[i]);
	        		int temp2 = Math.max(nums1[i], nums2[i]);
	        		if(temp1>=nums3[i-1]) {
	        			nums3[i] = temp1;
	        		} else if(temp2>=nums3[i-1]) {
	        			nums3[i] = temp2;
	        		} else {
	        			nums3[i] = temp1;
	        		}
	        	}
	        }
	        int res = Integer.MIN_VALUE;
	        int len = 1;
	        for(int i=1; i<n; i++) {
	            if(nums3[i] - nums3[i-1]>=0) {
	                len++;
	            } else {
	                res = Math.max(res, len);
	                len = 1;
	            }
	        }
	        if(len!=0) {
	        	res = Math.max(res, len);
	        }
	        return res;
	        
	    }
	
	class Solution {
	    public long totalCost(int[] costs, int k, int candidates) {
	        PriorityQueue<Integer> headWorkers = new PriorityQueue<>();
	        PriorityQueue<Integer> tailWorkers = new PriorityQueue<>();
	        
	        // headWorkers stores the first k workers.
	        // tailWorkers stores at most last k workers without any workers from the first k workers.
	        for (int i = 0; i < candidates; i++) {
	            headWorkers.add(costs[i]);
	        }
	        for (int i = Math.max(candidates, costs.length - candidates); i < costs.length; i++) {
	            tailWorkers.add(costs[i]);
	        }

	        long answer = 0;
	        int nextHead = candidates;
	        int nextTail = costs.length - 1 - candidates;

	        for (int i = 0; i < k; i++) {
	            if (tailWorkers.isEmpty() || !headWorkers.isEmpty() && headWorkers.peek() <= tailWorkers.peek()) {
	                answer += headWorkers.poll();
	                
	                // Only refill the queue if there are workers outside the two queues.
	                if (nextHead <= nextTail) {
	                    headWorkers.add(costs[nextHead]);
	                    nextHead++;
	                }
	            } 
	            
	            else {
	                answer += tailWorkers.poll();

	                // Only refill the queue if there are workers outside the two queues.
	                if (nextHead <= nextTail) {
	                    tailWorkers.add(costs[nextTail]);
	                    nextTail--;
	                }
	            }
	        }

	        return answer;
	    }
	}
}
