package com.vipin.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class IsDoubledArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = {6,3,0,1};
		System.out.println(findOriginalArray(input));

	}
	
	public static int[] findOriginalArray(int[] changed) {
		int N = changed.length;
		Integer[] temp = new Integer[N];
		Arrays.setAll(temp, i -> changed[i]);
		Arrays.sort(temp, Collections.reverseOrder());
		List<Integer> list = Arrays.asList(temp);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(Integer t : list) {
			map.put(t, map.getOrDefault(t, 0)+1);
		}
		int count = 0;
		Iterator<Integer> iterator = list.iterator();
		List<Integer> output = new ArrayList<Integer>();
		while (iterator.hasNext()) {
			int num = (Integer) iterator.next();
			if (num%2==0 && num==num/2 && map.get(num/2)>1) {
				output.add(num/2);
				map.put(num/2, map.get(num/2)-2);	
			} else if(num%2==0 && num!=num/2 && map.get(num/2)>0) {
				output.add(num/2);
				map.put(num/2, map.get(num/2)-1);
			}
		}
	
		int size = output.size();
		if(size%2!=0 && size!=N/2) {
			return new int[] {};
		}
		int ans[] = new int[size];
	    for(int i=0; i<size;i++) {
	    	ans[i] = output.get(i);
	    }
		return ans;
	}
}
