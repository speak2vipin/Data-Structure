package com.vipin.algorithm.heaps;

import java.util.*;

public class MaxJump2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxJump2 m = new MaxJump2();
		int nums[] = {10,9,8,7,6,5,4,3,2,1,1,0};
		System.out.println(m.jump(nums));
	}

	public int jump(int[] nums) {
		
        PriorityQueue<Temp>pq = new PriorityQueue<Temp>(new Comparator<Temp>() {
			@Override
			public int compare(Temp o1, Temp o2) {
				// TODO Auto-generated method stub
				return o2.reach==o1.reach ? (o2.index-o1.index) : o2.reach-o1.reach;
			}
		});
        int i = 0;
        int jump = 1;
        int N = nums.length;
        if(N==1) {
			return 0;
		}
        while(i+nums[i]<N-1) {
            for(int j=i+1; j<=i+nums[i] && j<N-1; j++) {
            	pq.offer(new Temp(j,j+nums[j]));
            }
            Temp top = pq.poll();
            i = top.index;
            jump++;
            pq.clear();
        }
        return jump; 
    }

}

class Temp {
	int index;
	int reach;

	public Temp(int index, int reach) {
        this.index = index;
        this.reach = reach;
    }
}
