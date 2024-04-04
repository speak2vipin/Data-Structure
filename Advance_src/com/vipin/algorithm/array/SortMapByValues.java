package com.vipin.algorithm.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortMapByValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> ans1 = new HashMap<>();
		ans1.put("Zebra", 101);
		ans1.put("Apple", 10);
		ans1.put("Peacock", 100);
		sortMapByValues(ans1);
	}

	static void sortMapByValues(Map<String, Integer> map) {
		
		
		ArrayList<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
		//Collections.sort(entries, (e1, e2) ->e1.getValue()-e2.getValue());
		//Map<String, Integer> ans = new LinkedHashMap<>();
		//for (Entry<String, Integer> entry : entries) {
			//ans.put(entry.getKey(), entry.getValue());
		//}
		//for (Entry<String, Integer> entry : ans.entrySet()) {
			//System.out.println(entry.getKey() + " " + entry.getValue());
		//}
		
		ArrayList<Entry<String, Integer>> entriesInJava8 = new ArrayList<>(map.entrySet());
		//entriesInJava8.sort(Map.Entry.comparingByValue());
		Collections.sort(entriesInJava8, (e1,e2)->e1.getValue()-e2.getValue());
		for (Entry<String, Integer> entry : entriesInJava8) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		
	}
}

class ValuesComparator implements Comparator<Entry<String, Integer>> {

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		// TODO Auto-generated method stub
		return (Integer) o1.getValue() - (Integer) o2.getValue();
	}
}
