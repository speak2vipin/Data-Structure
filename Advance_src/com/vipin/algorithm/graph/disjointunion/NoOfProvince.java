package com.vipin.algorithm.graph.disjointunion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NoOfProvince {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int is[][] = {{1,1,0},{1,1,0},{0,0,1}};
		NoOfProvince n = new NoOfProvince();
		//System.out.println(n.findCircleNum(is));
		
		Integer x[] = {2,4,3};
		
		//System.out.println(n.checkMedian(Arrays.asList(x)));
		System.out.println(n.solve(Arrays.asList(x)));
	}
	
	 Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
	    public int findCircleNum(int[][] isConnected) {
	        int N = isConnected.length;
	        for(int i=0; i<N; i++) {
	           // int temp[] = isConnected[i];
	            for(int j=0; j<N; j++) {
	                if(i==j) {
	                    continue;
	                } else if(isConnected[i][j]==1) {
	                    adj.computeIfAbsent(i, val->new ArrayList<Integer>()).add(j);
	                    adj.computeIfAbsent(j, val->new ArrayList<Integer>()).add(i);
	                }
	            }
	        }
	        int res = 0;
	        boolean visited[] = new boolean[N];
	        for(int i=0; i<N; i++) {
	            if(!visited[i]) {
	                res++;
	                dfs(i, visited);
	            }
	        
	        }
	        return res;
	    }
	    
	    void dfs(int source, boolean visited[]) {
	        visited[source] = true;
	        for(Integer node : adj.getOrDefault(source, new ArrayList<Integer>())) {
	            if(!visited[node]) {
	                dfs(node, visited);
	            }
	        }
	    }






    public int solve(List<Integer> A) {

        ArrayList<Integer> temp = new ArrayList<Integer>();

        for(int i=A.size()-1;i>=0;i--){
            temp.add(A.get(i));
        }

        if(solve1(A) || solve1(temp)){
            return 1;
        }

        return 0;
    }

    boolean checkMedian(List<Integer> A){

        PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();

        PriorityQueue<Integer> maxHeap= new PriorityQueue<Integer>(Collections.reverseOrder());

        maxHeap.add(A.get(0));

        for(int i=1;i<A.size()-1;i++){

            if(A.get(i) <= maxHeap.peek()){
                maxHeap.add(A.get(i));
            } else {
                minHeap.add(A.get(i));
            }
            //either both the heaps will have equal number of elements or max-heap will have one more element
            // than the min heap
            if(maxHeap.size() > minHeap.size()+1){

                minHeap.add(maxHeap.poll());
            } else if(maxHeap.size() < minHeap.size()){
                maxHeap.add(minHeap.poll());
            }

            if(maxHeap.size()==minHeap.size()){
                //we have even number of elements , take average of middle elements
                double ans=((long)maxHeap. peek()+ minHeap. peek())/2.0;

                if(ans==A.get(i+1)){
                    return true;
                }
            } else {
               
                if(maxHeap.peek().equals(A. get(i+1))){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean solve1(List<Integer> A) {
        int N = A.size();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.offer(A.get(0));
        for(int i=1; i<N-1; i++) {
            int num = A.get(i);
            if(num<=maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
            if(maxHeap.size() > minHeap.size()+1) {
                minHeap.offer(maxHeap.poll());
            } else if(maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            if(maxHeap.size() == minHeap.size()) {
                double ans = ((long)maxHeap.peek() + minHeap.peek())/2.0;
                if(ans==A.get(i+1)) {
                    return true;
                }
            }else {
                    if(maxHeap.peek().equals(A.get(i+1))) {
                        return true;
                    }
                }
            }
            
        
        return false;
    }
    
    
}
    
    

