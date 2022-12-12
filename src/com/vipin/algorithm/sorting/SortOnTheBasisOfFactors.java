package com.vipin.algorithm.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortOnTheBasisOfFactors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 6, 8, 9, 11 };
		A = solve(A);
		System.out.println(A[0] + " " + A[1] + " " + A[2]);
	}
	
	public static int[] solve(int[] A) {
        Map<Integer, List<Integer>>map = new TreeMap<Integer, List<Integer>>();
        for(int j =0 ; j<A.length; j++) {
            int count = 0;
            for(int i=1;i*i<=A[j];i++) {
                if(A[j]%i==0) {
                    if(A[j]==i*i) {
                        count = count+1;
                    } else {
                        count = count+2;
                    }
                }
            }
            if(map.get(count)==null) {
                List<Integer>list = new ArrayList<Integer>();
                list.add(A[j]);
                map.put(count, list);
            } else {
            	map.get(count).add(A[j]);
                map.put(count, map.get(count));
            }
        }
        int tempIndex = 0;
        for(List<Integer> l1 : map.values()) {
        	Collections.sort(l1);
            for(Integer i : l1) {
                A[tempIndex] = i;
                tempIndex++; 
            }
        }
        return A;
    }

}
