package com.vipin.algorithm.array;

import java.util.HashMap;
import java.util.Map;

public class SwapElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x[] = {1,2,3,4,5,6};
		rearrange(x, 6);
		
		long y[] = {0, 0, 5, 5, 0, 0};
		System.out.println(findSubarray(y, 6));
	}

	public static void rearrange(int arr[], int n) {
		// initialize index of first minimum and first
		// maximum element
		int max_idx = n - 1, min_idx = 0;

		// store maximum element of array
		int max_elem = arr[n - 1] + 1;

		// traverse array elements
		for (int i = 0; i < n; i++) {
			// at even index : we have to put
			// maximum element
			if (i % 2 == 0) {
				arr[i] += (arr[max_idx] % max_elem) * max_elem;
				max_idx--;
			}

			// at odd index : we have to put minimum element
			else {
				arr[i] += (arr[min_idx] % max_elem) * max_elem;
				min_idx++;
			}
		}

		// array elements back to it's original form
		for (int i = 0; i < n; i++)
			arr[i] = arr[i] / max_elem;

	}
	
	 public static long findSubarray(long[] arr ,int n) 
	    {
	        //Your code here
	        long count = 0;
	        Map<Long, Long> map = new HashMap<>();
	        map.put(0l,1l);
	        long prefixSum = 0l;
	        for(int i=0; i<n; i++) {
	            prefixSum += arr[i];
	            if(map.get(prefixSum)!=null) {
	                count += map.get(prefixSum);
	            }
	            map.put(prefixSum, map.getOrDefault(prefixSum, 0l)+1);
	        }
	        return count;
	    }
}
