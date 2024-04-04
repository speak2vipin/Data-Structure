package com.vimeo.interview;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Question_2 {

	//** Write a function to rotate an array by a given number of positions
	//* rotateArray([1, 2, 3, 4, 5], 2) => [3, 4, 5, 1, 2]
	//*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1, 2, 3, 4, 5
		// Q
		// 1 2 3 4 5
			// 2 3 4 5 1
			// 3 4 5 1 2
		
		int input[] = {1,2,3,4,5};
		for(int v : rotateArray(input, 2)) {
			System.out.print(v);
		}
		
	}
	
	static int[] rotateArray(int input[], int k) {
		Queue<Integer> qe = new ArrayDeque<>();
		for(int val : input) {
			qe.offer(val);
		}
		int i=0;
		while(i<k) {
			qe.offer(qe.poll());
			i++;
		}
		int res[] = new int[input.length];
		i=0;
		while(!qe.isEmpty()) {
			res[i++] = qe.poll();
		}
		return res;
	}

}


class Singleton implements Cloneable, Serializable {
	private Singleton() {
		
	}
	
	private static Singleton singelton = null;
	
	public static Singleton getInstance() {
		if(singelton==null) {
			synchronized(Singleton.class) {
				if(singelton==null) {
					singelton = new Singleton();
				}
			}
		}
		return singelton;
		
	}
	
}

class Solution {
    
}
