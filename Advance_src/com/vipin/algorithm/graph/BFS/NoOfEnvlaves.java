package com.vipin.algorithm.graph.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NoOfEnvlaves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = { { 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0 },
				{ 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0 }, { 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1 },
				{ 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0 }, { 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0 } };
		NoOfEnvlaves n = new NoOfEnvlaves();
		System.out.println(n.numEnclaves(grid));

		int A[][] = { { 0, 0, 1 }, { 0, 1, 1 }, { 1, 1, 1 } };
		System.out.println(n.solve1(A));

	}

	int n = 0;
	int m = 0;

	public int numEnclaves(int[][] grid) {
		n = grid.length;
		m = grid[0].length;
		boolean visit[][] = new boolean[n][m];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1 && !visit[i][j]) {
					ans += bfs(grid, visit, i, j);
				}
			}
		}
		return ans;
	}

	int bfs(int grid[][], boolean visit[][], int i, int j) {
		int count = 0;
		boolean isEnclaves = true;
		visit[i][j] = true;
		Queue<int[]> qe = new LinkedList<>();
		qe.offer(new int[] { i, j });
		int dx[] = { -1, 0, 1, 0 };
		int dy[] = { 0, 1, 0, -1 };
		while (!qe.isEmpty()) {
			int top[] = qe.poll();
			int x = top[0];
			int y = top[1];

			count++;
			for (int k = 0; k < 4; k++) {
				if (x + dx[k] < 0 || x + dx[k] > n - 1 || y + dy[k] < 0 || y + dy[k] > m - 1) {
					isEnclaves = false;
				} else if (!visit[x + dx[k]][y + dy[k]] && grid[x + dx[k]][y + dy[k]] == 1) {
					visit[x + dx[k]][y + dy[k]] = true;
					qe.offer(new int[] { x + dx[k], y + dy[k] });
				}
			}
		}
		return isEnclaves ? count : 0;
	}

	public int solve1(int[][] A) {
		int N = A.length;
		int M = A[0].length;

		for (int j = 0; j < M; j++) {
			for (int i = 1; i < N; i++) {
				A[i][j] = (A[i][j] == 0) ? A[i][j] : (A[i][j] + A[i - 1][j]);
			}
		}
		int maxArea = Integer.MIN_VALUE;
		for (int a[] : A) {
			maxArea = Math.max(maxArea, findMaxRectangleArea(a));
		}
		return maxArea;
	}

	int findMaxRectangleArea(int A[]) {
		int area = Integer.MIN_VALUE;
		int NSLI[] = NSLI(A);
		int NSRI[] = NSRI(A);
		for (int i = 0; i < A.length; i++) {
			area = Math.max(area, A[i] * (NSRI[i] - 1 - (NSLI[i] + 1) + 1));
		}
		return area;
	}

	int[] NSLI(int A[]) {
		int N = A.length;
		int result[] = new int[N];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < N; i++) {
			while (!st.isEmpty() && A[st.peek()] >= A[i]) {
				st.pop();
			}
			if (st.isEmpty()) {
				result[i] = -1;
			} else {
				result[i] = st.peek();
			}
			st.push(i);
		}
		return result;
	}

	int[] NSRI(int A[]) {
		int N = A.length;
		int result[] = new int[N];
		Stack<Integer> st = new Stack<>();
		for (int i = N - 1; i > -1; i--) {
			while (!st.isEmpty() && A[st.peek()] >= A[i]) {
				st.pop();
			}
			if (st.isEmpty()) {
				result[i] = N;
			} else {
				result[i] = st.peek();
			}
			st.push(i);
		}
		return result;
	}
}
