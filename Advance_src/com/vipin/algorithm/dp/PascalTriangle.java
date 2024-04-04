package com.vipin.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generate(5);
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> response = new ArrayList<>();
		List<Integer> curr = new ArrayList<>();
		curr.add(1);
		response.add(curr);
		
		while (numRows > 1) {
			List<Integer> next = new ArrayList<>();
			int currSize = curr.size();
			next.add(1);
			for (int i = 1; i < currSize; i++) {
				int nextElement = 0;
				if (i - 1 > -1) {
					nextElement += curr.get(i - 1);
				}
				if (i < currSize) {
					nextElement += curr.get(i);
				}
				next.add(nextElement);
			}
			next.add(1);
			response.add(next);
			curr = next;
			numRows--;
		}
		return response;
	}

}
