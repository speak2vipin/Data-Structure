package com.vipin.algorithm.HCF;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class NumberOnALine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int p[][] = { { 1, 1 }, { 2, 2 }, { 3, 3 } };
		int q[][] = { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };
		int r[][] = { { 3, 3 }, { 1, 4 }, { 1, 1 }, { 2, 1 }, { 2, 2 } };
		 System.out.println(maxPoints(p));
		 System.out.println(maxPoints(q));
		System.out.println(maxPoints(r));

	}

	public static int maxPoints(int[][] points) {
		int n = points.length;

		if (n == 1) {
			return 1;
		}

		int max = 0;

		for (int i = 0; i < n; i++) {
			Map<Double, Integer> map = new HashMap<>();
			for (int j = i + 1; j < n; j++) {
				double slope = calculateSlope(points[i], points[j]);
				System.out.println(slope);

				map.put(slope, map.getOrDefault(slope, 0) + 1);

				max = Math.max(max, map.get(slope));
			}
		}

		return max + 1;
	}

	private static double calculateSlope(int[] p1, int[] p2) {
		int x1 = p1[0], x2 = p2[0];
		int y1 = p1[1], y2 = p2[1];

		if (x1 == x2)
			return Double.MAX_VALUE;
		if (y1 == y2)
			return 0;
		return (double) (y2 - y1) / (double) (x2 - x1);
	}

	static int HCF(int x, int y) {
		if (x == 0) {
			return y;
		}
		if (y == 0) {
			return x;
		}
		return HCF(y, x % y);
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object p) {
		Point point = (Point) p;
		return this.x == point.x && this.y == point.y;
	}

	@Override
	public int hashCode() {
		super.hashCode();
		return 0;
	}
}