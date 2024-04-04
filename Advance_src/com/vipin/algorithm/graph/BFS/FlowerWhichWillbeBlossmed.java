package com.vipin.algorithm.graph.BFS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FlowerWhichWillbeBlossmed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int flowers[][] = {{1,6},{3,7},{9,12},{4,13}};
		 int poeple[] = {2,3,7,11};
		 fullBloomFlowers(flowers, poeple);
	}

	public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
		/*
		 * int n = people.length; int answer[] = new int[n]; for(int i=0; i<n; i++) {
		 * int time = people[i]; int count = 0; for(int flower[] : flowers) { int st =
		 * flower[0]; int en = flower[1]; if(time>=st && time<=en) { count++; } }
		 * answer[i] = count; } return answer;
		 */

		int n = people.length;
		int answer[] = new int[n];
		int originalOrderOfPeople[] = new int[n];
		System.arraycopy(people, 0, originalOrderOfPeople, 0, n);
		Arrays.sort(people);
		Arrays.sort(flowers, (a, b) -> a[0] - b[0]);
		Map<Integer, Integer> trackPeople = new HashMap<>();
		int j = 0;
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		for (int i = 0; i < n; i++) {
			int person = people[i];
			while (j < n && flowers[j][0] <= person) {
				heap.offer(flowers[j][1]);
				j++;
			}
			while (!heap.isEmpty() && heap.peek() < person) {
				heap.poll();
			}
			trackPeople.put(person, heap.size());
		}
		for (int i = 0; i < n; i++) {
			answer[i] = trackPeople.get(originalOrderOfPeople[i]);
		}
		return answer;
	}
}
