package com.vipin.algorithm.hashing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TomNHarryGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {20,20,30,30,30};
		int b[] = {20,20,30,30};
		System.out.println(solve(a));
		System.out.println(solve(b));
		

	}
	
	public static String solve(int[] A) {
		Map<Integer, Integer>map = new HashMap<Integer, Integer>();
        int N = A.length;
        for(int i=0; i<N; i++) {
            map.put(A[i], map.getOrDefault(A[i],0)+1);
        }
        
        int size = map.size();

        if(size==2) {
        	List<Integer>keys = (List<Integer>) map.keySet();
            return map.get(keys.get(0)) == map.get(keys.get(1)) ? "WIN" : "LOSE";
        }
        
        return "LOSE";
    }


}
