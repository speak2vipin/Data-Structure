package com.vipin.algorithm.array;

import java.util.*;

public class ScoreAfterAllElementsMarking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {2,1,3,4,5,2};
		ScoreAfterAllElementsMarking s = new ScoreAfterAllElementsMarking();
		//System.out.println(s.findScore(nums));
		System.out.println(s.evenOddBit(17));
	}
	
	public long findScore(int[] nums) {
        long score= 0;
        PriorityQueue<Temp> pq = new PriorityQueue<Temp>(new Comparator<Temp>(){
           public int compare(Temp t1, Temp t2) {
               return t1.val==t2.val ? (t1.index-t2.index) : t1.val-t2.val;
           } 
        });
        int N = nums.length;
        for(int i=0; i<N; i++) {
            pq.offer(new Temp(nums[i],i));
        }
        while(!pq.isEmpty()) {
            Temp t = pq.poll();
            if(nums[t.index]!=0) {
	            int tempIndex = t.index;
	            score = score+nums[tempIndex];
	            if(tempIndex+1<N) {
	                nums[tempIndex+1] = 0;
	            } 
	            if(tempIndex-1>-1) {
	                nums[tempIndex-1] = 0;
	            }
            }
        }
        return score;
        
    }
	
	public int[] evenOddBit(int n) {
        int cEven = 0;
        int cOdd = 0;
        for(int i=11; i>-1; i--) {
            int bit = (n>>i)&1;
            if(i%2==0 && bit==1) {
                cEven++;
            } else if(i%2!=0 && bit==1) {
                cOdd++;
            }
        }
        int ans[] = new int[2];
        ans[0] = cEven;
        ans[1] = cOdd;
        return ans;
        
    }
}


class Temp {
    int val;
    int index;
    public Temp(int val, int index) {
        this.val = val;
        this.index = index;
    }
}
