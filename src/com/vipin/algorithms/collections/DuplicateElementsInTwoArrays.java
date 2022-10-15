package com.vipin.algorithms.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DuplicateElementsInTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {2, 1, 4, 10, 10};
		int B[] = {3, 6, 2, 10, 10};
		solve(A, B);
		
	}
	
	public static int[] solve(int[] A, int[] B) {
        Map<Integer, Integer>map = new HashMap<Integer, Integer>();
        for(int i=0;i<A.length;i++) {
        	if(map.containsKey(A[i]))
        		map.put(A[i], map.get(A[i])+1);
        	else {
        		map.put(A[i], 1);
        	}
        }
        List<Integer>ansList = new ArrayList<Integer>();
        for(int i=0;i<B.length;i++) {
            if(map.get(B[i])!=null && map.get(B[i])>0) {
                ansList.add(B[i]);
                map.put(A[i], map.get(A[i])-1);
            }
        }
        int ans[] =  new int[ansList.size()];
        int i=0;
        for (Object o :ansList.toArray()) {
        	ans[i] = (int) o;
        	i++;
        }
        return ans;
    }

}
