package com.vipin.algorithm.mathoperation;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DivideBy0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(1/0);
		long l = 1l;
		long d = 0l;
		float f = 1;
		// Will return infinity.
		System.out.println(f / 0);
		int[] A = { 48, 45, -3, 7, -25, 38, 2, 13, 13, 18, -44, 34, -27, -46, 48, -39, -41, -32, -16, 17, -6, 44, -28,
				-44, -6, -43, -16, 30, -3, -27, 32, 38, -26, 20, 4, -44, -37 };
		int[] B = { 47, -42, 41, 22, -4, -35, -45, -22, 5, -20, 21, -13, 47, 32, -48, 47, 17, -23, 30, -30, 37, 42, 44,
				23, 1, -40, -9, 34, -34, 49, 16, -35, 2, -19, 31, 23, -37 };

		System.out.println(solve(A, B));

	}

	public static int solve(int[] A, int[] B) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int N = A.length;
		int ans = 0;
		String temp = "";
		int x;
		int y;
		int gcd;
		for (int i = 0; i < N; i++) {
			int equal = 0;
			int maxi = 0;
			for (int j = i + 1; j < N; j++) {
				if (A[j] == A[i] && B[j] == B[i]) {
					equal++;
				} else {
					x = (A[j] - A[i]);
					y = (B[j] - B[i]);
					gcd = gcd(x, y);
					System.out.println(x + " " + gcd + " " + y);
					temp = (x / gcd) + "*" + (y / gcd);
					map.put(temp, map.getOrDefault(temp, 0) + 1);
					maxi = Math.max(maxi, map.get(temp));
				}	
			}
			ans = Math.max(ans, maxi+equal);
			map.clear();
			
		}
		return ans + 1;

	}

	static int gcd(int x, int y) {
		if (x == 0) {
			return y;
		}
		return gcd(y % x, x);
	}

	public int solve1(int[] A, int[] B) {
		int n = A.length, totalPoints = 0, equal, maxi;
		HashMap<String, Integer> hm = new HashMap<>(); // we can also create HashMap inside the outer loop
		for (int i = 0; i < n; i++) { // but then we have to remove #hm.clear() method.
			maxi = 0;
			equal = 0;
			for (int j = i + 1; j < n; j++) {
				if (A[i] == A[j] && B[i] == B[j])
					equal++; // for points that are overlaping.
				else {
					int x = A[j] - A[i]; // slope for any 2 points with co-ordinates (x,y) & (x1,y1)
					int y = B[j] - B[i]; // is (y1-y)/(x1-x)…
					int gcd = GCD(y, x); // dividing every co-ordinates with their gcd to get smallest
					String str = (x / gcd) + "*" + (y / gcd); // possible ratio and then converting them to string.
					hm.put(str, hm.getOrDefault(str, 0) + 1);
					maxi = Math.max(maxi, hm.get(str));
				}
			}
			totalPoints = Math.max(totalPoints, equal + maxi + 1);// this extra 1 is added because for any
			// frequency in HashMap the count of corresponding or fixed point should also be
			// counted…
			hm.clear();
		}
		return totalPoints;
	}

	public int GCD(int x, int y) {
		if (x == 0)
			return y;
		return GCD(y % x, x);
	}
}
