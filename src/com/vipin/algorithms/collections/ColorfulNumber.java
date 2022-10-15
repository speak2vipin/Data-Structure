package com.vipin.algorithms.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ColorfulNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(colorful(23));
		System.out.println(colorful(236));

	}
	
	public static int colorful(int A) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, map.getOrDefault(1, 0) + 1);
        Set<Integer> set = new HashSet<Integer>();
        String s = Integer.toString(A);
        int N = s.length();
        char[] c = s.toCharArray();
       
        for(int i=0; i<N;i++) {
            for(int j=i; j<N; j++) {
                int temp = 1;
                for(int k=i;k<=j;k++) {
                    temp*=c[k]-'0';
                }
                if(!set.add(temp)) {
                    return 0;
                }
            }
        }
        return 1;
    }

}
