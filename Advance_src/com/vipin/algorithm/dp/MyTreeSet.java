package com.vipin.algorithm.dp;

import java.util.*;

public class MyTreeSet {

	// Main driver methodMyTreeSet
	public static void main(String args[]) {
		Integer x = null;
		
		//System.out.println(x.compareTo(0));
		x = new Integer(5);
		System.out.println(x.compareTo(1));
		System.out.println(x.compareTo(6));

		// Creating an empty TreeSet of string type elements
		TreeSet<String> al = new TreeSet<String>();

		// Adding elements
		// using add() method
		al.add("welcome");
		al.add("to");
		al.add("Geeks for Geeks");

		al.add("20");
		al.add("100");
		al.add("1");
		
		Set<String> errors = new HashSet<>();
		errors.add("Vipin"+":"+"Gupta");

		// Traversing elements via help of iterators
		Iterator<String> itr = al.iterator();

		// Holds true until there is element remaining in object
		while (itr.hasNext()) {

			// Moving onto next element with help of next() method
			System.out.println(itr.next());
		}

		int a[] = { 14, 12, 14, 14, 12, 14, 14, 12, 12, 12, 12, 14, 14, 12, 14, 14, 14, 12, 12 };
		System.out.println(new MyTreeSet().minOperations(a));
	}

	public int minOperations(int[] nums) {
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int num : nums) {
			numMap.put(num, numMap.getOrDefault(num, 0) + 1);
		}
		int count = 0;
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (Integer key : numMap.values()) {
			// freqMap.put(numMap.get(key), freqMap.getOrDefault(numMap.get(key), 0) + 1);
			if (key == 1) {
				return -1;
			} else if ((key % 3) == 0) {
				count += key / 3;
			} else if ((key % 3) % 2 == 0) {
				count += key / 3;
				count += 1;
			} else if ((key % 3) % 2 != 0) {
				count += key / 3;
				count += 1;
			}
		}
		
		return count;

	}

}
