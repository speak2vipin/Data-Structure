package com.vipin.algorithm.basicmath;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NoOfPairInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 2, 3, 4, 5 };
		System.out.println(solve(A, 2));
		
		int[] B = {5, 17, 100, 11};
		System.out.println(solve(B, 28));

	}

	public static int solve(int[] A, int B) {
		int N = A.length;
		int modulus = 1000000007;
		HashMap<Integer, Long> freq = new HashMap<>();
		long ans = 0L;
		for (int num : A) {
			int t = num % B;
			if (freq.get(t) == null) {
				freq.put(t, 1l);
			} else {
				freq.put(t, freq.get(t) + 1);
			}
		}
		Set<Integer> keySet = freq.keySet();
		for (Integer temp : keySet) {
			long value = freq.get(temp);
			if (temp % B == 0) {
				//ans = (ans + ((value * (value - 1))) % modulus) % modulus;
                ans = (ans + (value * (value - 1)));
			} else {
				if(B - temp == temp) {
					ans = (ans + (value * (value - 1)));
				} else if (keySet.contains(B - temp)) {
					ans = (ans + (value * freq.get(B - temp)));
				}
			}
		}
		return (int) ((ans/2)%modulus);
   
	}

}
