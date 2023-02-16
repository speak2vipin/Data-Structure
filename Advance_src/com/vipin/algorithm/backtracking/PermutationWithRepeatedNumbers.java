package com.vipin.algorithm.backtracking;

import java.util.ArrayList;

public class PermutationWithRepeatedNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer> ();
		A.add(1);
		A.add(1);
		A.add(3);
		PermutationWithRepeatedNumbers p = new PermutationWithRepeatedNumbers();
		System.out.println(p.permute(A));

	}

	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
	int N = 0;

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
		int freq[] = new int[11];
		N = A.size();
		for (int i = 0; i < N; i++) {
			freq[A.get(i)] += 1;
		}
		ArrayList<Integer> permutation = new ArrayList<Integer> ();
		permute(0, freq, permutation);
		return ans;
	}

	void permute(int index, int[] freq, ArrayList<Integer> permutation) {
		if (index == N) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(permutation);
			ans.add(temp);
			return;
		}
		for (int i = 0; i < 11; i++) {
			if (freq[i] != 0) {
				permutation.add(i);
				freq[i]--;
				permute(index + 1, freq, permutation);
				freq[i]++;
				int size = permutation.size();
				permutation.remove(size-1);
			}
		}
	}


}
