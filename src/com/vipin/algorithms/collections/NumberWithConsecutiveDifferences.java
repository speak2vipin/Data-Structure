package com.vipin.algorithms.collections;

import java.util.ArrayList;
import java.util.*;

public class NumberWithConsecutiveDifferences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (Integer i : numsSameConsecDiff(3, 1)) {
			System.out.println(i);
		}

	}

	public static int[] numsSameConsecDiff(int n, int k) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int digit = 0;
		int tempK = k;
		while (tempK - digit == k && tempK<10) {
			List<Integer> l = new ArrayList<Integer>();
			l.add(tempK);
			l.add(digit);
			list.add(l);
			tempK++;
			digit++;
		}
		Set<Integer> ans = new HashSet<Integer>();
		for (List<Integer> l : list) {
			int tempN = 0;
			StringBuilder sb1 = new StringBuilder("");
			StringBuilder sb2 = new StringBuilder("");
			while (++tempN <= n) {
				sb1 = sb1.append(l.get(0));
				sb2 = sb2.append(l.get(1));
				if (++tempN <= n) {
					sb1 = sb1.append(l.get(1));
					sb2 = sb2.append(l.get(0));
				}
			}
			if (!(sb1.charAt(0) == '0')) {
				ans.add(Integer.parseInt(sb1.toString()));
			}
			if (!(sb2.charAt(0) == '0')) {
				ans.add(Integer.parseInt(sb2.toString()));
			}
		}
		int[] output = new int[ans.size()];
		int index = 0;
		for (Integer i : ans) {
			output[index] = i;
			index++;
		}
		return output;
	}
}