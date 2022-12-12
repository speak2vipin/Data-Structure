package com.vipin.algorithm.hashing;

import java.util.HashSet;
import java.util.Set;

public class MaximumRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 1, 1, 2, 2 };
		int B[] = { 1, 2, 1, 2 };
		System.out.println(solve(A, B));

	}

	public static int solve(int[] A, int[] B) {
		Set<Pair> pairSet = new HashSet<Pair>();

		int N = A.length;
		for (int i = 0; i < N; i++) {
			pairSet.add(new Pair(A[i], B[i]));
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (A[j] > A[i] && B[j] > B[i] && pairSet.contains(new Pair(A[i], B[j]))
						&& pairSet.contains(new Pair(A[j], B[i]))) {
					count++;
				}
			}
		}
		return count;

	}
}

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Pair pair = (Pair) obj;
		return (this.x == pair.x && this.y == pair.y);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return x + y;
	}
}
