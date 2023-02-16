package com.vipin.algorithm.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MedianOfARunningStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = List.of(1,2,5,4,3);
		System.out.println(solve(A));
	}
	
	public static ArrayList<Integer> solve(List<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        PriorityQueue<Integer>maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer>minHeap = new PriorityQueue<Integer>();
        for(Integer temp : A) {
        	if(!maxHeap.isEmpty() && temp>maxHeap.peek()) {
        		minHeap.offer(temp);
        		if(minHeap.size()>maxHeap.size()) {
        			maxHeap.offer(minHeap.poll());
        		}
        	} else {
        		maxHeap.offer(temp);
        		if(maxHeap.size()>minHeap.size()+1) {
            		minHeap.offer(maxHeap.poll());
            	} 
        	}
        	ans.add(maxHeap.peek());
        }
        return ans;
    }

}
