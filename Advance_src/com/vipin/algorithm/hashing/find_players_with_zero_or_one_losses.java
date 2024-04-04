package com.vipin.algorithm.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class find_players_with_zero_or_one_losses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {71,55,82,55};
		System.out.println(sumSubarrayMins(a));
		
	}
	
	public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        
        for(int match[] : matches) {
            in.put(match[1], in.getOrDefault(match[1], 0)+1);
            out.put(match[0], out.getOrDefault(match[0], 0)+1);
        }
        
        TreeSet<Integer> winners = new TreeSet<>();
        TreeSet<Integer> oneLoose = new TreeSet<>();
        for(Integer w : out.keySet()) {
            if(in.containsKey(w) && in.get(w)==1) {
                oneLoose.add(w);
            } else if(!in.containsKey(w)) {
                winners.add(w);
            }
        }
        for(Integer w : in.keySet()) {
            if(in.get(w)==1 && !oneLoose.contains(w)) {
                oneLoose.add(w);
            }
        }
        return Arrays.asList(new ArrayList<>(winners), new ArrayList<>(oneLoose));
        
    }
	
	 public static int sumSubarrayMins(int[] arr) {
	        int n = arr.length;
	        //int left[] = leftNextLesser(arr);
	        //int right[] = rightNextGreater(arr);
	        int total = 0;
	        for(int i=0; i<n; i++) {
	            int li = i-1;
	            int c1 = 0;
	            while(li>-1 && arr[li]>=arr[i]) {
	                c1++;
	                li--;
	            }
	            int ri = i+1;
	            int c2 =0;
	            while(ri<n && arr[i]<arr[ri]) {
	                c2++;
	                ri++;
	            }
	            System.out.println(c1 + " " + c2 + " " + arr[i]);
	            total += (c1+1)*(c2+1)*arr[i];
	        }
	        return total;
	        
	    }

}


class A {
	List<String> names;
}

class B extends A {
	List<String> names;
}