package com.vipin.algorithms.tree;

import java.util.*;
import java.util.LinkedList;

public class MinimumGeneticMutationWithBFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String start = "AACCTTGG";
		String end = "AATTCCGG";
		String[] bank = { "AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"};
		
		//System.out.println(minMutation(start, end, bank));
		System.out.println(minMutation(start, end, bank, true));
	}

	public static int minMutation(String start, String end, String[] bank) {
		if (start.equals(end))
			return 0;

		Set<String> bankSet = new HashSet<>();
		for (String b : bank)
			bankSet.add(b);

		char[] charSet = new char[] { 'A', 'C', 'G', 'T' };

		int level = 0;
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.offer(start);
		visited.add(start);

		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				String curr = queue.poll();
				if (curr.equals(end))
					return level;

				char[] currArray = curr.toCharArray();  //AAAAACCC || AAAACCCC","AAACCCCC","AACCCCCC" || AACCCCCC
				for (int i = 0; i < currArray.length; i++) {

					char old = currArray[i];
					for (char c : charSet) {
						currArray[i] = c;
						String next = new String(currArray);
						if (!visited.contains(next) && bankSet.contains(next)) {
							visited.add(next);
							queue.offer(next);
						}
					}
					currArray[i] = old;
				}
			}
			level++;
		}
		return -1;
	}
	
	public static int minMutation(String start, String end, String[] bank, boolean flag) {
		char genes[] = { 'A', 'C', 'G', 'T' };
		if (start.equals(end)) {
			return 0;
		} else if (bank.length == 0) {
			return -1;
		}
		
		int level = 0;
		List<String> bankString = new ArrayList<String>();
		for(String b : bank) {
			bankString.add(b);
		}
		Queue<String> sList = new LinkedList<String>();
		Set<String>visited = new HashSet<String> ();
		sList.offer(start);
		while (!sList.isEmpty()) {
			int size = sList.size();
			while (size-- > 0) {
				
				String s = sList.poll();		//AAAAACCC || AAAACCCC","AAACCCCC","AACCCCCC" || AACCCCCC
				if(s.equals(end)) {
					return level;
				}
				for (int i = 0; i < s.length(); i++) {
					char[] charArray = s.toCharArray();
					for (int j = 0; j < genes.length; j++) {
						charArray[i] = genes[j];
						String temp = new String(charArray);
						if (visited.add(temp) && bankString.contains(temp)) {
							sList.offer(temp);
							//visited.add(temp);
						}

					}
				}
			}
			if(!sList.isEmpty())
				level++;
		}
		return -1;
	}
}
