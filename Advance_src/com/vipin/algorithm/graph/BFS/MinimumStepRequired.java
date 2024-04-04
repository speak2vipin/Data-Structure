package com.vipin.algorithm.graph.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class MinimumStepRequired {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

	public static int solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C) {
		int N = A.size();
		int M = A.get(0).size();
		Queue<ArrayList<Integer>> qe = new ArrayDeque<>();
		qe.offer(B);
		int direction[][] = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
		
		int distance[][] = new int[N][M];
		for (int d[] : distance) {
			Arrays.fill(d, Integer.MAX_VALUE);
		}
		distance[B.get(0)][B.get(1)] = 0;
		while (!qe.isEmpty()) {
			int size = qe.size();
			for (int i = 0; i < size; i++) {
				ArrayList<Integer> top = qe.poll();
				int x = top.get(0);
				int y = top.get(1);

				for (int j = 0; j < 4; j++) {
					int count = 0;
					int dx = x;
					int dy = y;
					while (dx + direction[j][0] > -1 && dx + direction[j][0] < N && dy + direction[j][1] > -1
							&& dy + direction[j][1] < M && A.get(dx + direction[j][0]).get(dy + direction[j][1]) != 1) {
						dx = dx + direction[j][0];
						dy = dy + direction[j][1];
						count++;
					}
					if (distance[dx][dy] > distance[x][y] + count) {
						distance[dx][dy] = distance[x][y] + count;
						ArrayList<Integer> temp = new ArrayList<>();
						temp.add(dx);
						temp.add(dy);
						qe.offer(temp);
					}
				}
			}
		}
		return distance[C.get(0)][C.get(1)]==Integer.MAX_VALUE?-1:distance[C.get(0)][C.get(1)];
	}
	
	public int[] intersection(int[] nums1, int[] nums2) {
        //HashSet<Integer> set = new HashSet<>();
        
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).filter(set::contains).toArray();
        
    }
}
