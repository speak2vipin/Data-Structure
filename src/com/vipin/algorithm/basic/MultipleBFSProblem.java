package com.vipin.algorithm.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MultipleBFSProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]input = {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,77,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,
		               7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,11};
		MultipleBFSProblem m = new MultipleBFSProblem();
		System.out.println(m.myminJumps(input));

	}

	public int minJumps(int[] arr) {
		int n = arr.length;
		if (n == 1) {
			return 0;
		}

		Map<Integer, List<Integer>> valueToIndex = new HashMap<>();
		for (int i = 0; i < n; i++) {
			valueToIndex.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
		}
		

		boolean[] visited = new boolean[n];
		visited[0] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		int steps = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int curr = queue.poll();
				if (curr == n - 1) {
					return steps;
				}

				if (curr - 1 >= 0 && !visited[curr - 1]) {
					visited[curr - 1] = true;
					queue.offer(curr - 1);
				}

				if (curr + 1 < n && !visited[curr + 1]) {
					visited[curr + 1] = true;
					queue.offer(curr + 1);
				}

				for (int index : valueToIndex.getOrDefault(arr[curr], Collections.emptyList())) {
					if (!visited[index]) {
						visited[index] = true;
						queue.offer(index);
					}
				}

				// remove the indices with the same value to avoid revisiting them
				valueToIndex.remove(arr[curr]);
			}
			steps++;
		}

		return -1;
	}
	
public int myminJumps(int[] arr) {
        
        Map<Integer, ArrayList<Integer>>valueToIndex = new HashMap<Integer, ArrayList<Integer>>();
        int N = arr.length;
        if(N<=1) {
            return 0;
        }
       for(int i=0; i<N; i++) {
			valueToIndex.computeIfAbsent(arr[i], val-> new ArrayList<Integer>()).add(i);
        }
        int steps = 0;
        Queue<Integer> qe = new LinkedList<Integer> ();
        qe.offer(0);
        boolean[]visit = new boolean[N];
        visit[0] = true;
        while(!qe.isEmpty()) {
            int size = qe.size();
            for(int i=0; i<size; i++) {
                int index = qe.poll();
                if(index==N-1) {
                    return steps;
                }
                if(index+1<N && !visit[index+1]) {
                    qe.offer(index+1);
                    visit[index+1] = true;
                }
                if(index-1>-1 && !visit[index-1]) {
                    qe.offer(index-1);
                    visit[index-1] = true;
                }
                ArrayList<Integer>sameNumberIndex = valueToIndex.getOrDefault(arr[index], new ArrayList<Integer>());
                for(int sameNumber : sameNumberIndex) {
                    if(!visit[sameNumber]){
                        qe.offer(sameNumber);
                        visit[sameNumber] = true;
                    }
                }
                valueToIndex.remove(arr[index]);
            }
            
            steps++;
        }
       return -1; 
    }

}
