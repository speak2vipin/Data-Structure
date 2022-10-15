package com.vipin.algorithms.collections;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sudoku = {
						   "53..7....", "6..195...", ".98....6.", 
						   "8...6...3", "4..8.3..1", "7...2...6",
						   ".6....28.", "...419..5", "....8..79" 
						  };
		System.out.println(isValidSudoku(sudoku));
	}

	public static int isValidSudoku(final String[] A) {
		int N = A.length;
		char[][] sudoku = new char[9][9];
		for (int i = 0; i < 9; i++) {
			sudoku[i] = A[i].toCharArray();
		}
		Set<Character> set1 = new HashSet<Character>();
		Set<Character> set2 = new HashSet<Character>();
		Set<Character> set3 = new HashSet<Character>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (sudoku[i][j] != '.' && !set1.add(sudoku[i][j])) {
					return 0;
				}
				if (sudoku[j][i] != '.' && !set2.add(sudoku[j][i])) {
					return 0;
				}
			}
			set1.clear();
			set2.clear();
		}
		
		for (int k = 0; k < 3; k++) {
			for (int i = k * 3; i < k * 3 + 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (sudoku[i][j] != '.' && !set1.add(sudoku[i][j])) {
						return 0;
					}
				}
				for (int j = 3; j < 6; j++) {
					if (sudoku[i][j] != '.' && !set2.add(sudoku[i][j])) {
						return 0;
					}
				}
				for (int j = 6; j < 9; j++) {
					if (sudoku[i][j] != '.' && !set3.add(sudoku[i][j])) {
						return 0;
					}
				}
			}
			set1.clear();
			set2.clear();
			set3.clear();
		}
		return 1;
	}

}
