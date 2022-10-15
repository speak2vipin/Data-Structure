package com.vipin.algorithms.collections;

import java.util.Set;
import java.util.*;

public class IsDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "helloz", "xello", "interviewbit" };
		String B = "adhbcfegskjlponmirqtxwuvzy";
		System.out.println(solve(s, B));

	}

	public static int solve(String[] A, String B) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < B.length(); i++) {
			map.put(B.charAt(i), i);
		}

		int N = A.length;
		for (int i = 1; i < N; i++) {
			int len = Math.min(A[i - 1].length(), A[i].length());
			for (int j = 0; j < len; j++) {
				if(map.get(A[i].charAt(j)) > map.get(A[i-1].charAt(j))) {
					break;
				} else if(A[i].contains(A[i-1])) {
					break;
				} else if(map.get(A[i].charAt(j)) < map.get(A[i-1].charAt(j))) {
					return 0;
				} else if(A[i-1].contains(A[i]) && A[i-1].length()>A[i].length()) {
					return 0;
				} 
			}
		}
		return 1;
	}

}
