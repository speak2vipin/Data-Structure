package com.vipin.algorithms.queue;
import java.util.PriorityQueue;
import java.util.Queue;

public class DistanceAndFuelPriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target = 100;
		int startFuel = 10;
		int[][]stations = {{10,60},{20,30},{30,30},{60,40}};
		System.out.println(minRefuelStops(target, startFuel, stations));
	}
	
	
	public static int minRefuelStops(int target, int cur, int[][] s) {
        Queue<Integer> pq = new PriorityQueue<>();
        int i = 0, res;
        for (res = 0; cur < target; res++) {
            while (i < s.length && s[i][0] <= cur)
                pq.offer(-s[i++][1]);
            if (pq.isEmpty()) return -1;
            cur += -pq.poll();
        }
        return res;
    }

}
