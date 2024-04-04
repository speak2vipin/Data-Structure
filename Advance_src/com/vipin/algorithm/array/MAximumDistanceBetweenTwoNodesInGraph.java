package com.vipin.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MAximumDistanceBetweenTwoNodesInGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x[] = { 1,5, 2, 3};
		int y[] = { 5,4, 1, 5};
		System.out.println(maxDistance(5, x, y));
		

	}
	
	static int maxDistance(int n, int x[], int y[]) {
		int visit[] = new int[n+1];
		int N = x.length;
		Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
		for(int i=0; i<N; i++) {
			adj.computeIfAbsent(x[i], val->new ArrayList<Integer>()).add(y[i]);
			adj.computeIfAbsent(y[i], val->new ArrayList<Integer>()).add(x[i]);
		}
		Queue<Integer> qe = new LinkedList<>();
		qe.offer(1);
		visit[1] = 1;
		int height = -1;
		boolean flag = false;
		while(!qe.isEmpty()) {
			int size = qe.size();
			height++;
			for(int i=0; i<size; i++) {
				int top = qe.poll();
				ArrayList<Integer> gnodes = adj.get(top);
				if(gnodes!=null) {
					int s = gnodes.size();
					for(int node : gnodes) {
						if(visit[node] != 1) {
							qe.offer(node);
							visit[node] = 1;
						}
					}
					if(s>1) {
						flag = true;
					}
				}
			}
		}
		return flag ? height + height - 1 : height;	
	}
}
