package com.vipin.algorithm.heaps;

import java.util.Map;
import java.util.TreeMap;

public class MinimumStepsToCompleteTasks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
        int N = tasks.length;
        for(int i=0; i<N; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0)+1);
        }
        int step = -1;
        
        for(Integer temp : map.keySet()) {
            int val = map.get(temp);
            if(val==1) {
            	return -1;
            }
            if(val%3==0) {
            		step += val/3;
            } else if(val%3==1) {
            		step += (val/3) - 1 + 2;
            } else {
            	step += (val/3)+1;            	
            }
        }
        return step;  
    }
}
