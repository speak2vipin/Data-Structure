package com.vipin.algorithms.hashing;

import java.util.HashSet;
import java.util.Set;

public class MyCalender {
	static Set<Integer> hours;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCalender my = new MyCalender();

		int[][] input = { { 20, 29 }, { 13, 22 }, { 44, 50 }, { 1, 7 }, { 2, 10 }, { 14, 20 }, { 19, 25 }, { 36, 42 },
				{ 45, 50 }, { 47, 50 }, { 39, 45 }, { 44, 50 }, { 16, 25 }, { 45, 50 }, { 45, 50 }, { 12, 20 },
				{ 21, 29 }, { 11, 20 }, { 12, 17 }, { 34, 40 }, { 10, 18 }, { 38, 44 }, { 23, 32 }, { 38, 44 },
				{ 15, 20 }, { 27, 33 }, { 34, 42 }, { 44, 50 }, { 35, 40 }, { 24, 31 } };
		for(int[] in : input) {
			System.out.println(in[0] + " " + in[1] +" " + book(in[0], in[1]));
		}

	}

	public MyCalender() {
		hours = new HashSet<Integer>();
	}

	public static boolean book(int start, int end) {
		for (int i = start; i < end; i++) {
			if (hours.contains(i)) {
				for(int j=start; j<i;j++) {
					hours.remove(j);
				}
				return false;
			} else {
				hours.add(i);
			}
		}
		return true;
	}

}
