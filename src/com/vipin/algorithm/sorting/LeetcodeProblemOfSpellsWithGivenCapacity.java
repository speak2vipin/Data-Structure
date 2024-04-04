package com.vipin.algorithm.sorting;

import java.util.Arrays;

public class LeetcodeProblemOfSpellsWithGivenCapacity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LeetcodeProblemOfSpellsWithGivenCapacity l = new LeetcodeProblemOfSpellsWithGivenCapacity();
		int[] spells = { 39, 34, 6, 35, 18, 24, 40 };
		int[] potions = { 27, 37, 33, 34, 14, 7, 23, 12, 22, 37 };
		int success = 43;
		System.out.println(l.successfulPairs2(spells, potions, success));
	}

	public int[] successfulPairs2(int[] spells, int[] potions, long success) {

		int N = spells.length;
		int M = potions.length;

		int ans[] = new int[N];

		int spellIndex[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			spellIndex[i] = new int[] { spells[i], i };
		}

		Arrays.sort(potions);
		Arrays.sort(spellIndex, (a, b) -> (a[0] - b[0]));

		int j = M;
		int count = 0;
		for (int temp[] : spellIndex) {
			int index = temp[1];
			int spell = temp[0];
			while (j-- > 0 && (potions[j] * spell) >= success) {
				count++;
			}
			ans[index] = count;
			count = 0;
			j = M;
		}
		return ans;
	}
}
