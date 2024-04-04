package com.vipin.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PepsicoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> sources = new ArrayList<>();
		
		List<String> s1 = new ArrayList<>();
		s1.add("P1:a");s1.add("P3:b");s1.add("P5:x");
		List<String> s2 = new ArrayList<>();
		s2.add("P1:b");s2.add("P2:q");s2.add("P5:x");
		sources.add(s1);
		sources.add(s2);
		computeParameterValue(sources);

	}
	
	public static List<String> computeParameterValue(List<List<String>> sources) {
        int n = sources.size();
        int p = sources.get(0).size();
        List<String> answer = new ArrayList<>();
        PriorityQueue<Stock> pq = 
                new PriorityQueue<Stock>((s1, s2)->s2.priority-s1.priority); 
        for(int i=0; i<p; i++) {
        	 Map<String, String> unique = new HashMap<>();
            for(int j=0; j<n; j++) {
                String input[] = sources.get(j).get(i).split(":");
                String tempKey = input[0].substring(1);
                String tempValue = input[1];
                unique.put(tempKey, tempValue);
                
                
            }
            for(String key : unique.keySet()) {
                pq.offer(new Stock(
                    Integer.parseInt(key), unique.get(key)));
            }
            answer.add(pq.poll().value);
        }
        while(!pq.isEmpty()) {
        	answer.add(pq.poll().value);
        }
        return answer;
    }




}
class Stock {
    Integer priority;
    String value;
    public Stock(Integer priority, String value) {
        this.priority = priority;
        this.value = value;
    }
}