package com.vipin.algorithms.collections;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementInSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1, 2, 1, 3, 4, 3};
		dNums(A, 3);
	}
	
	public static int[] dNums(int[] A, int B) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int N = A.length;
        int ans[] = new int[N-B+1];
        //Initially placing B elements in Map
        for(int i=0; i<B; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) +1);
        }
        ans[0] = map.size();
        int index = 0;
        for(int i=B;i<N;i++) {
            map.put(A[i], map.getOrDefault(A[i], 0)+1);
            // Sliding window -> Check the freq of left most element if it is 1 remove it.
            if(map.get(A[index])==1) {
                map.remove(A[index]);
            } else {
            	// If freq of left most element is not 1 then decrease it.
                map.put(A[index], map.get(A[index])-1);
            }
            index++;
            ans[index] = map.size();
        }
        return ans;
    }
}
