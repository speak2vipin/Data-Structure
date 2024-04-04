package com.vipin.algorithm.heaps;

import java.util.*;
import java.util.Map.Entry;

public class MaxKNumberWithHighestFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int A[] = {1,5,5,5,2,3};
		int k = 2;
		MaxKNumberWithHighestFrequency m = new MaxKNumberWithHighestFrequency();
		int res[] = m.topKFrequent(A, k);
		System.out.println(res[0] + " " + res[1]);
		
		int res2[] = m.topKFrequentWithoutHeap(A, k);
	}
	
	public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            new Comparator<int[]>() {
                @Override
                public int compare(int x[], int y[]) {
                    return y[1] - x[1];
                }
            });
        for(Integer key : map.keySet()) {
            pq.offer(new int[]{key, map.get(key)});
        }
        int res[] = new int[k];
        int i = 0;
        while(k>0) {
            res[i] = pq.poll()[0];
            k--;
            i++;
        }
        return res;
    }
	
	public int[] topKFrequentWithoutHeap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
  
        
        Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(" Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return map.get(o2)-map.get(o1);
			}
        	
        });
        treeMap.putAll(map);
        
        
        int res[] = new int[k];
        int i = 0;
        for(Integer key: treeMap.keySet()) {
        	res[i++] = key;
        }
        return res;
    }
	
	

}
