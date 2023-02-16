package com.vipin.algorithm.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LexigraphicalSmallestString {
	int min;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LexigraphicalSmallestString l = new LexigraphicalSmallestString();
		String s1 = "parker";
		String s2 = "morris";
		String baseStr = "parser";
		System.out.println(l.smallestEquivalentString(s1, s2, baseStr));

	}

	public String smallestEquivalentString(String s1, String s2, String baseStr) {
		Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
		int L = s1.length();
		for (int i = 0; i < L; i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			adj.computeIfAbsent(c1 - 'a', val -> new ArrayList<Integer>()).add(c2 - 'a');
			adj.computeIfAbsent(c2 - 'a', val -> new ArrayList<Integer>()).add(c1 - 'a');
		}
		int L1 = baseStr.length();
		String ans = "";

		// Array to store the final character mappings.
		int mappingChar[] = new int[26];
		for (int i = 0; i < 26; i++) {
			mappingChar[i] = i;
		}
		int visited[] = new int[26];
		// If Character try to play with array of 26
		// Visited array to track not to visit that node again 
		for (int i = 0; i < 26; i++) {
			if (visited[i] == 0) {
				min = 27;
				// Component array is basically to keep track of all the visited node so that we can update its min mapping in one go only.
				List<Integer> component = new ArrayList<Integer>();
				DFS(adj, i, visited, component);

				for (Integer temp : component) {
					mappingChar[temp] = min;
				}
			}
		}
		for (int i = 0; i < baseStr.length(); i++) {
			ans += (char) (mappingChar[baseStr.charAt(i) - 'a'] + 'a');
		}

		return ans;
	}

	void DFS(Map<Integer, List<Integer>> adj, int child, int[] visited, List<Integer> component) {
		List<Integer> l = adj.get(child);
		component.add(child);
		visited[child] = 1;
		System.out.println(((char) (child + 'a')));

		// Update the minimum character in the component.
		min = Math.min(min, child);
		if (l != null) {
			for (int i = 0; i < l.size(); i++) {
				int temp = l.get(i);
				System.out.println(((char) (temp + 'a')));
				if (visited[temp] != 0) {
					continue;
				}
				DFS(adj, temp, visited, component);
			}
		}

	}
	


}
