package com.vipin.algorithm.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;

public class BeautifulArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,1,2,3,5};
		System.out.println(minDeletion(nums));
		
		String t[][] = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		
		List<List<String>> tickets = new ArrayList<>();
		for(String T[] : t) {
			tickets.add(Arrays.asList(T));
		}
		System.out.println(findItinerary(tickets));
	}
	
	public static int minDeletion(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int index = 0;
        int deletion = 0;
        for(int i=0; i<n; i++) {
            if(st.isEmpty()) {
                st.push(nums[i]);
            } else {
                if((index%2)!=0 && nums[i]==st.peek()) {
                    deletion++;
                    continue;
                } else {
                    st.push(nums[i]);
                }
            }
            index++;
        }
        return ((n-deletion)%2)==0 ? (deletion) : (deletion+1);
    }
	public static List<String> findItinerary(List<List<String>> tickets) {
		Map<String, PriorityQueue<String>> graph = new HashMap<>();
	    for(List<String> ticket : tickets) {
	    	graph.computeIfAbsent(ticket.get(0), val->new PriorityQueue<String>()).add(ticket.get(1));
	    }
	    LinkedList<String> itinary = new LinkedList<String>();
	    String source = "JFK";
	    helper(source, graph, itinary);
	    return itinary;
	}
	
	static void helper(String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> itinary) {
		PriorityQueue<String> airports = graph.get(airport);
		
		while(airports!=null && !airports.isEmpty()) {
			helper(airports.poll(), graph, itinary);
		}
		itinary.addFirst(airport);
		
	}

}
