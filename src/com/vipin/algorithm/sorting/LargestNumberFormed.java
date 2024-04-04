package com.vipin.algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LargestNumberFormed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 88, 9 };
		// System.out.println(largestNumber(A));
		int X[] = { 5, 2, 6, 8, 9, 7 };
		int k = 50;
		// System.out.println(countSubarrays(X, k));
		// 15
		// [[10,2],[12,1],[7,1],[11,1],[5,3],[14,3],[12,2],[14,3],[3,2],[13,3],[11,1],[2,2],[2,1],[4,2]]
		int n = 15;
		int queries[][] = { { 10, 2 }, { 12, 1 }, { 7, 1 }, { 11, 1 }, { 5, 3 }, { 14, 3 }, { 12, 2 }, { 14, 3 },
				{ 3, 2 }, { 13, 3 }, { 11, 1 }, { 2, 2 }, { 2, 1 }, { 4, 2 } };
		for (int a : colorTheArray(n, queries)) {
			System.out.println(a);
		}
	}

	public static String largestNumber(final int[] A) {
		StringBuilder stringBuilder = new StringBuilder();
		int N = A.length;
		String aString[] = new String[N];
		for (int i = 0; i < N; i++) {
			aString[i] = Integer.toString(A[i]);
		}
		Arrays.sort(aString, new Comparator<String>() {
			public int compare(String num1, String num2) {
				int concatNumber1 = Integer.parseInt(num1 + num2);
				int concatNumber2 = Integer.parseInt(num2 + num1);
				return concatNumber2 - concatNumber1;
			}
		});
		if (aString[0].equals("0")) {
			return "0";
		}
		for (String temp : aString) {
			stringBuilder.append(temp);
		}
		return stringBuilder.toString();
	}

	public static long countSubarrays(int[] nums, long k) {
		int N = nums.length;

		int i = 0;
		int j = 0;
		int count = 0;
		int len = 0;
		int sum = 0;
		// 5,2,6,8,9,7}
		while (i < N) {

			sum += nums[i];
			while (sum * (i - j + 1) > k) {
				sum -= nums[j++];
			}
			count += i - j + 1;
			i++;

		}
		return count;
	}

	public static int[] colorTheArray(int n, int[][] queries) {
		int N = queries.length;
		int ans[] = new int[N];
        if(n==1) {
            return ans;
        }
		List<Integer> colorList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			colorList.add(0);
		}
		int tempCount = 0;
		int i = 0;

		for (int[] query : queries) {
			int index = query[0];
			int color = query[1];
			// Reduce same adjacent color count
			if (colorList.get(index) != 0) {
				if (index == 0) {
					if (colorList.get(index) == colorList.get(index + 1)) {
						tempCount--;
					}
				} else if (index == n - 1) {
					if (colorList.get(index) == colorList.get(index-1)) {
						tempCount--;
					}
				} else {
					if (colorList.get(index) == colorList.get(index + 1)) {
						tempCount--;
					}
					if (colorList.get(index) == colorList.get(index - 1)) {
						tempCount--;
					}
				}
			}
			
			// Increasing adjacent color count if it's equal
			if (index == 0) {
				if (color == colorList.get(index + 1)) {
					tempCount++;
				}
			} else if (index == n - 1) {
				if (color == colorList.get(index - 1)) {
					tempCount++;
				}
			} else {
				if (color == colorList.get(index + 1)) {
					tempCount++;
				}
				if (color == colorList.get(index - 1)) {
					tempCount++;
				}
			}
			colorList.set(index, color);
			ans[i++] = tempCount;
		}
		return ans;
	}
	
	

}
