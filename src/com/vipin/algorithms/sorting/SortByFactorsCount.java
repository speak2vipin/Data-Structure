package com.vipin.algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByFactorsCount {
	
	public static void main(String[] args) {
		int []A = {2, 100, 6, 8, 17, 1, 16, 25, 49};
		for(Integer i : sortByFactors(A))
			System.out.println(i);
		
	}
	
	static List<Integer> sortByFactors(int[] A) {
		List<Integer> l = new ArrayList<Integer>();
		for(int i : A) {
			l.add(i);
		}
		Collections.sort(l, new Comparator<Integer>() {
			
			int countFactor(int x) {
				int count=0;
				for(int i=1; i<=Math.sqrt(x);i++) {
					if(x%i==0) {
						if(x/i == i) {
							count+=1;
						} else {
							count+=2;
						}
					}
				}
				return count;
			}

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				int countFactor1 = countFactor(o1);
				int countFactor2 = countFactor(o2);
				return countFactor1 - countFactor2;
			}
			
		});
		
		return l;
		
	}

}
