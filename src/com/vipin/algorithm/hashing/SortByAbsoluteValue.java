package com.vipin.algorithm.hashing;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortByAbsoluteValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { -10, -6, 1, 0, 10, 5 };
		Integer aA[] = new Integer[A.length];
		Arrays.setAll(aA, i -> A[i]);
		Arrays.sort(aA, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {

				return (int) (Math.abs(i1) - Math.abs(i2));
			}
		});
		for(Integer i : aA) {
			System.out.println(i);
		}
	}
}
