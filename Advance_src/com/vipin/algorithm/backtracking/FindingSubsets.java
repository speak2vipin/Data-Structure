package com.vipin.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindingSubsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = Arrays.asList(1,2,3);
		FindingSubsets fs = new FindingSubsets();
		fs.subsets(A);

	}

	ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
	int N = 0;

	public ArrayList<ArrayList<Integer>> subsets(List<Integer> A) {
		N = A.size();
		Collections.sort(A);
		// Find Subsets
		helper(0, A, new ArrayList<Integer>());
		// Sort collection based on value first if it is equal than sort it by size
		Collections.sort(subsets, (ArrayList<Integer> X, ArrayList<Integer> Y) -> {
			for (int i = 0; i < X.size() && i < Y.size(); i++) {
				if (X.get(i) > Y.get(i)) {
					return 1;
				}
				if (Y.get(i) > X.get(i)) {
					return -1;
				}
			}
			if (X.size() > Y.size()) {
				return 1;
			}
			return -1;
		});

		return subsets;
	}

	void helper(int index, List<Integer> A, ArrayList<Integer> subset) {
		if (index == N) {
			ArrayList<Integer> s = new ArrayList<>();
			s.addAll(subset);
			subsets.add(s);
			return;
		}
		subset.add(A.get(index));
		helper(index + 1, A, subset);
		int size = subset.size();
		subset.remove(size - 1);
		helper(index + 1, A, subset);
	}
}
