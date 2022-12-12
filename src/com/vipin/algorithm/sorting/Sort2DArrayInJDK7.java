package com.vipin.algorithm.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class Sort2DArrayInJDK7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[][] = { { 4, 8 }, { 1, 2 }, { 8, 1 }, { 4, 6 } };
		Arrays.sort(A, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}

			}
		});
		for (int[] x : A) {
			System.out.println(x[0] + " " + x[1]);
		}
		System.out.println(Math.pow(-10, 2));
		
		int X[][] = {
				  {-855, 944},
				  {1000, -795},
				  {-719, 657},
				  {803, -782},
				  {-644, 748},
				  {994, -1088},
				  {-818, 702},
				  {616, -878},
				  {-622, 765},
				  {891, -657},
				  {-974, 678},
				  {961, -983},
				  {-862, 909},
				  {638, -776},
				  {-608, 863},
				  {940, -908},
				  {-1050, 720},
				  {1003, -774},
				  {-955, 872},
				  {1006, -877},
				  {-690, 1085},
				  {718, -1060},
				  {-790, 811},
				  {-10, 1},
				  {324, -402},
				  {-407, 364},
				  {497, -139},
				  {-112, 484},
				  {106, -309},
				  {-138, 346},
				  {230, -440},
				  {-380, 263},
				  {72, -22},
				  {-381, 238},
				  {93, -426},
				  {-462, 283},
				  {496, -167},
				  {-486, 492},
				  {110, -353},
				  {-230, 325},
				  {329, -352},
				  {-407, 485},
				  {431, -233},
				  {-475, 122},
				  {287, -404},
				  {-2, 281},
				  {185, -269},
				  {-2, 326},
				  {422, -108},
				  {-228, 348},
				  {422, -6},
				  {-477, 414},
				  {377, -16}
				};
			int Y = 30;
			X = solve(X, Y);
			for (int[] x : X) {
				System.out.println(x[0] + " " + x[1]);
			}
	}

	public static int[][] solve(int[][] A, int B) {
		Arrays.sort(A, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				int d1 = o1[0]*o1[0] + o1[1]*o1[1];
				int d2 = o2[0]*o2[0] + o2[1]*o2[1];
				return (int) (d1 - d2);

			}
		});
		int ans[][] = new int[B][2];
		for (int i = 0; i < B; i++) {
			ans[i] = A[i];
		}
		return ans;
	}

	
	

}
