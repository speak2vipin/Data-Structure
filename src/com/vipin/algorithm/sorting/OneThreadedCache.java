package com.vipin.algorithm.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class OneThreadedCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int A[][] = {{1,2},{2,4},{3,2},{4,1}};
		int B[][] = {{19,13},{16,9},{21,10},{32,25},{37,4},{49,24},{2,15},{38,41},{37,34},{33,6},{45,4},{18,18},{46,39},{12,24}};
		            //[[19,13],[16,9],[21,10],[32,25],[37,4],[49,24],[2,15],[38,41],[37,34],[33,6],[45,4],[18,18],[46,39],[12,24]]  
		// (2, 15), (16,9), 
		
		//int out1[] = getOrder(A);
		//for(Integer i : out1) {
			//System.out.println(i);
		//}
		int outB[] = getOrder(B);
		for(Integer i : outB) {
			System.out.println(i);
		}
		System.out.println();

	}

	public static int[] getOrder(int[][] tasks) {
		ProcessinTimeComparator com = new ProcessinTimeComparator();
		PriorityQueue<Temp> pq = new PriorityQueue<Temp>(com);
		Map<Integer, List<Temp>>map = new HashMap<Integer, List<Temp>>();
		int N = tasks.length;
		int start = tasks[0][0];
		for(int i=0; i<N; i++) {
			start = Math.min(start, tasks[i][0]);
			map.computeIfAbsent(tasks[i][0], val -> new ArrayList<Temp>()).add(new Temp(i, tasks[i][1], tasks[i][0]));
		}
		int ans[]= new int[N];
		int i=0;
		
		for(Temp temp : map.get(start)) {
			pq.offer(temp);
		}
		while(i<N) {
			Temp process = pq.poll();
			ans[i] = process.index;
			i++;
			
			for(int k=1; k<=process.processingTime; k++) {
				if(map.get(++start)!=null) {
					for(Temp temp : map.get(start)) {
						pq.offer(temp);
					}
				}	
			}
		}
		return ans;
	}
	
}

class Temp {
	int index;
	int processingTime;
	int start;

	public Temp(int index, int processingTime, int start) {
		this.index = index;
		this.processingTime = processingTime;
		this.start = start;
	}

}

class ProcessinTimeComparator implements Comparator<Temp>{	
	@Override
	public int compare(Temp o1, Temp o2) {
		// TODO Auto-generated method stub
		return o1.processingTime == o2.processingTime ? o1.index - o2.index : o1.processingTime - o2.processingTime;
	}	
	
	class Solution {
	    public int[] getOrder(int[][] tasks) {
	        
	        // Sort based on min task processing time or min task index.
	        // Store enqueue time, processing time, task index.
	        PriorityQueue<int[]> nextTask = new PriorityQueue<int[]>((a, b) -> (a[1] != b[1] ? (a[1] - b[1]) : (a[2] - b[2])));
	        
	        // Store task enqueue time, processing time, index.
	        int sortedTasks[][] = new int[tasks.length][3];
	        for (int i = 0; i < tasks.length; ++i) {
	            sortedTasks[i][0] = tasks[i][0];
	            sortedTasks[i][1] = tasks[i][1];
	            sortedTasks[i][2] = i;
	        }
	        
	        Arrays.sort(sortedTasks, (a, b) -> Integer.compare(a[0], b[0]));
	        int tasksProcessingOrder[] = new int[tasks.length];
	        
	        long currTime = 0;
	        int taskIndex = 0;
	        int ansIndex = 0;
	        
	        // Stop when no tasks are left in array and heap.
	        while (taskIndex < tasks.length || !nextTask.isEmpty()) {
	            if (nextTask.isEmpty() && currTime < sortedTasks[taskIndex][0]) {
	                // When the heap is empty, try updating currTime to next task's enqueue time. 
	                currTime = sortedTasks[taskIndex][0];
	            }
	            
	            // Push all the tasks whose enqueueTime <= currtTime into the heap.
	            while (taskIndex < tasks.length && currTime >= sortedTasks[taskIndex][0]) { 
	                nextTask.add(sortedTasks[taskIndex]);
	                ++taskIndex;
	            }
	            
	            int processTime = nextTask.peek()[1];
	            int index = nextTask.peek()[2];
	            nextTask.remove();
	            
	            // Complete this task and increment currTime.
	            currTime += processTime; 
	            tasksProcessingOrder[ansIndex++] = index;
	        }
	        
	        return tasksProcessingOrder;
	    }
	}
}