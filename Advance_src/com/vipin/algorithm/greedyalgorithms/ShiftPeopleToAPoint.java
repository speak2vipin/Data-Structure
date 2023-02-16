package com.vipin.algorithm.greedyalgorithms;

import java.util.ArrayList;
import java.util.List;

public class ShiftPeopleToAPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(seats1("xx.x.xx..x."));

	}

	public static int seats(String A) {
		int N = A.length();
		int st = -1;
		int en = -1;
		char[] characters = A.toCharArray();
		for (int i = 0; i < N; i++) {
			if (characters[i] == 'x') {
				if (st == -1) {
					st = i;
				}
				en = i;
			}
		}
		int mod = 10000003;
		int mid = (en + st) / 2;
		int count = 0;
		int total = 0;
		for (int i = mid; i > -1; i--) {
			if (characters[i] == 'x') {
				int shift = mid - i - count;
				if (shift != 0) {
					characters[i + shift] = 'x';
					characters[i] = '.';
				}
				total = (total + shift) % mod;
				count++;
			}
		}
		count = 0;
		for (int i = mid; i < N; i++) {
			if (characters[i] == 'x') {
				int shift = i - mid - count;
				if (shift != 0) {
					characters[i - shift] = 'x';
					characters[i] = '.';
				}
				total = (total + shift) % mod;
				count++;
			}
		}
		return total;
	}

	public static int seats1(String A) {
		List<Integer> list = new ArrayList<Integer>();
		int N = A.length();
	
		int xcount = 0;
		char[] characters = A.toCharArray();
		for (int i = 0; i < N; i++) {
			if (characters[i] == 'x') {
				xcount++;
				list.add(i);
			}
		}
		if(xcount==0) {
			return 0;
		}
		int mid = -1;
		int mod = 10000003;
		int count = 0;
		int total = 0;
		if ((xcount % 2) != 0) {
			mid = list.get((xcount-1) / 2);
			for (int i = mid; i > -1; i--) {
				if (characters[i] == 'x') {
					int shift = mid - i - count;
					
					total = (total + shift) % mod;
					count++;
				}
			}
			count = 0;
			for (int i = mid; i < N; i++) {
				if (characters[i] == 'x') {
					int shift = i - mid - count;
					
					total = (total + shift) % mod;
					count++;
				}
			}
		} else {
			count = 0;
			int half = xcount / 2;
			int mid1 = list.get((half) - 1);
			
			int total1 = 0;
			for (int i = mid1; i > -1; i--) {
				if (characters[i] == 'x') {
					int shift = mid1 - i - count;
					total1 = (total1 + shift) % mod;
					count++;
				}
			}
			count = 0;
			int mid2 = list.get(half);
			int total2 = 0;
			for (int i = mid2; i < N; i++) {
				if (characters[i] == 'x') {
					int shift = i - mid2 - count;
					total2 = (total2 + shift) % mod;
					count++;
				}
			}
			if(total1==total2) {
				total += total1 + total2 + half*(mid2-mid1-1);
			} else if (total1 > total2) {
				total += total1 + total2 + half * (mid2-mid1-1);
			} else {
				total += total1 +  half* (mid2-mid1-1) + total2;
			}
		}
		return total;
	}

}
