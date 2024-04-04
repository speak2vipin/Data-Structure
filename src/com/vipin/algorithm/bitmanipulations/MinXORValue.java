package com.vipin.algorithm.bitmanipulations;

import java.util.HashMap;
import java.util.Map;

public class MinXORValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Integer.MAX_VALUE, Integer.MAX_VALUE));
		System.out.println(test("dccbcdaac", "bab"));
	}
	
	public static int solve(int A, int B) {
        int bitsC = 0;
        for(int i=30; i>-1; i--){
            if(((B>>i)&1)==1){
                bitsC++;
            }
        }
        int res=0;
        for(int i=30; i>-1; i--){
            if(((A>>i)&1)==1 && bitsC>0){
            	res = res + (1<<i);
                bitsC--;
            }
        }
        if(bitsC>0) {
	        for(int i=0; i<31; i++){
	            if((A&(1<<i))==1 && bitsC>0){
	            	res = res + (1<<i);
	            }
	            bitsC--;
	        }
        }
        return res;
    }
	
	public static int test(String a, String b) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i<a.length(); i++) {
			char temp = a.charAt(i);
			map.put(temp, map.getOrDefault(temp, 0)+1);
		}
		
		for(int i=0; i<b.length(); i++) {
			char temp = b.charAt(i);
			if(map.get(temp)==null || map.get(temp)==0) {
				return 0;
			}
			map.put(temp, map.get(temp)-1);
		}
		return 1;
	}
}
