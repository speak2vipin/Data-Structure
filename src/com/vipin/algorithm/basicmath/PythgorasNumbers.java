package com.vipin.algorithm.basicmath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class PythgorasNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int Arr[] = { 3, 2, 4, 6, 5 };
		System.out.println(checkTriplet(Arr, N));
		int a[] = { 2, 1, 17, 15, 8 };
		String b = "RRLRL";
		solve(a, b);

	}

	static boolean checkTriplet(int[] arr, int n) {
		// code here
		int maxVal = Integer.MIN_VALUE;
		for (int val : arr) {
			maxVal = Math.max(maxVal, val);
		}
		int values[] = new int[maxVal + 1];
		for (int val : arr) {
			values[val]++;
		}
		for (int i = 1; i < maxVal + 1; i++) {
			for (int j = 1; j < maxVal + 1; j++) {
				if (values[i] > 0 && values[j] > 0) {
					if (i == j && values[i] < 2) {
						continue;
					}
					int sqrt = (int) (Math.sqrt((values[i] * values[i]) + (values[j] * values[j])));
					if (sqrt * sqrt != (values[i] * values[i]) + (values[j] * values[j])) {
						continue;
					}
					if (values[sqrt] > 0) {
						return true;
					}
				}
			}
		}
		return false;
	}

	int transitionPoint(int arr[], int n) {
		// code here
		int st = 0;
		int en = n - 1;
		while (st <= en) {
			int mid = en - (en - st) / 2;
			if (arr[mid] == 1 && (mid == 0 || arr[mid - 1] == 0)) {
				return mid;
			}
			if (arr[mid] == 0) {
				st = mid + 1;
			} else {
				en = mid - 1;
			}
		}
		return -1;
	}

	public int solve(int A, ArrayList<ArrayList<Integer>> B, int C, int D) {

		Map<Integer, ArrayList<long[]>> adj = new HashMap<>();
		for (ArrayList<Integer> b : B) {
			adj.computeIfAbsent(b.get(0), val -> new ArrayList<long[]>()).add(new long[] { b.get(1), b.get(2) });
			adj.computeIfAbsent(b.get(1), val -> new ArrayList<long[]>()).add(new long[] { b.get(0), b.get(2) });
		}
		long dist[] = new long[A];
		long maxDist = 100000_00000l;
		Arrays.fill(dist, maxDist);
		PriorityQueue<long[]> pq = new PriorityQueue<long[]>((x, y) -> x[1] - y[1] > 0 ? 1 : -1);
		pq.offer(new long[] { C, 0 });
		dist[C] = 0;
		while (!pq.isEmpty()) {
			long top[] = pq.poll();
			int node = (int) top[0];
			long distance = top[1];
			ArrayList<long[]> neighbours = adj.getOrDefault(node, new ArrayList<long[]>());
			for (long[] neighbour : neighbours) {
				if (distance + neighbour[1] <= dist[(int) neighbour[0]]) {
					dist[(int) neighbour[0]] = distance + neighbour[1];
					pq.offer(new long[] { neighbour[0], distance + neighbour[1] });
				}
			}
		}
		return dist[D] == maxDist ? -1 : (int) dist[D];

	}

	public static int solve(int[] A, String B) {
		int n = A.length - 1;
		Stack<int[]> st = new Stack<>();
		int i = 0;
		while (i <= n) {
			int dir = (B.charAt(i) == 'L') ? 1 : -1;
			if (st.isEmpty()) {
				st.push(new int[] { i, dir });
			} else {

				while (!st.isEmpty() && dir != st.peek()[1] && A[i] > A[st.peek()[0]]) {
					st.pop();
				}
				if (st.isEmpty()) {
					st.push(new int[] { i, dir });
				} else if (st.peek()[1] != dir && st.peek()[0] == A[i]) {
					st.pop();
				} else if (st.peek()[1] == dir) {
					st.push(new int[] { i, dir });
				}
			}
			i++;
		}
		return st.size();
	}
	

}
