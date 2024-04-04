package com.vipin.algorithm.binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class KthWeakestRow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {{1,1,0},{1,0,0},{1,0,0},{1,1,1},{1,1,0},{0,0,0}};
				
		int k = 4;
		KthWeakestRow ki = new KthWeakestRow();
		System.out.println(ki.kWeakestRows(mat, k));
	}

	public int[] kWeakestRows(int[][] mat, int k) {
		TreeMap<Integer, List<Integer>> t = new TreeMap<>();
		for (int i = 0; i < mat.length; i++) {
			int sol = index(mat[i]);
			t.computeIfAbsent(sol, val -> new ArrayList<Integer>()).add(i);
		}
		int response[] = new int[k];
		int index = 0;
		for (Integer key : t.keySet()) {
			for (Integer val : t.get(key)) {
				response[index++] = val;
				if (index == k) {
					return response;
				}
			}
		}
		return response;
	}

	int index(int line[]) {
		int st = 0;
		int en = line.length - 1;
		int val = -1;
		while (st <= en) {
			int mid = (en + st) / 2;
			if (line[mid] == 1) {
				val = mid;
				st = mid + 1;
			} else {
				en = mid - 1;
			}
		}
		return val + 1;
	}

}
