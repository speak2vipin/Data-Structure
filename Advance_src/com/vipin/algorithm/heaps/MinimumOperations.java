package com.vipin.algorithm.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(24);
		a.add(-68);
		a.add(-29);
		a.add(-9);
		a.add(84);
		Integer A [] = {24, -68, -29, -9, 84};
		//System.out.println(solve(a, 4));
		int X[] = {2,3,4};
		int Y[]	= {3,4,3};
		System.out.println(canCompleteCircuit(X, Y));
	

	}
	
	public static int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int sum = 0;
        for(Integer temp : A) {
            sum += temp;
            pq.offer(temp);
        }
        while(B>0) {
            int top = pq.poll();
            sum -= top;
            pq.offer(-1*top);
            sum += pq.peek();
            B--;
        }
        return sum;
        
    }
	
	
	public static int canCompleteCircuit(int[] gas, int[] cost) {
        int N = gas.length;
      
        for(int i=0; i<N; i++) {
            if(gas[i]>=cost[i]) {
                if(check(N, i, gas, cost)) {
                    return i;
                }
            } 
        }
        return -1;
    }
    
	static boolean check(int L, int index, int[] gas, int[] cost) { 
        int step=0;
        int remainingGas = 0;
        while(step<L && remainingGas>-1) {
            if(index==L-1) {
                remainingGas += gas[index] - cost[index];
                step++;
                index=0;
                continue;
            } else {
                remainingGas += gas[index] - cost[index];
                step++;
                index++;
            }
        }
        return (step==L && remainingGas>-1) ? true : false;
    }

}
