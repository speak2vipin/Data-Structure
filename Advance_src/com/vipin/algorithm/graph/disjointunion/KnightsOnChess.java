package com.vipin.algorithm.graph.disjointunion;

import java.util.LinkedList;
import java.util.Queue;

public class KnightsOnChess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A = 8;
		int B = 8;
		int C = 1;
		int D = 1;
		int E = 8;
		int F = 8;
		KnightsOnChess k = new KnightsOnChess();
		System.out.println(k.knight(A, B, C, D, E, F));

	}

	public int knight(int A, int B, int C, int D, int E, int F) {
		int dx[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int dy[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
		Queue<int[]> qe = new LinkedList<>();
		qe.offer(new int[] { C, D });
		boolean[][] chess = new boolean[A + 1][B + 1];
		chess[C][D] = true;
		int count = -1;
		while (!qe.isEmpty()) {
			int size = qe.size();
			count++;
			for (int j = 0; j < size; j++) {
				int top[] = qe.poll();
				int x1 = top[0];
				int y1 = top[1];
				if (x1 == E && y1 == F) {
					return count;
				}

				for (int i = 0; i < 8; i++) {
					if (isValid(x1 + dx[i], y1 + dy[i], A, B) && !chess[x1 + dx[i]][y1 + dy[i]]) {
						chess[x1 + dx[i]][y1 + dy[i]] = true;
						qe.offer(new int[] { x1 + dx[i], y1 + dy[i] });
						// System.out.println((x1+dx[i]) + " " + (y1+dy[i]));
					}
				}
			}
		}
		return -1;
	}

	boolean isValid(int x, int y, int A, int B) {
		return x > 0 && x < A + 1 && y > 0 && y < B + 1;
	}

}
