package com.vipin.algorithm.stack;

import java.util.Stack;

public class BurstAesteroidsReturnRemainingCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {8,-8};
		System.out.println(asteroidCollision(a));
	}
	
	 public static int[] asteroidCollision(int[] asteroids) {
	        Stack<Integer> st = new Stack<>();
	        for(int asteroid : asteroids) {
	            boolean isPush = true;
	            while(!st.isEmpty() && st.peek()>0 && asteroid < 0) {
	                if(st.peek()==asteroid) {
	                    isPush = false;
	                    st.pop();
	                    break;
	                } else if(st.peek()<asteroid) {
	                    st.pop();
	                } else {
	                    isPush = false;
	                    break;
	                }
	            }
	            if(isPush)
	            	st.push(asteroid);
	        }
	        
	        int res[] = null;
	        if(!st.isEmpty()) {
	            int size = st.size();
	            res = new int[size];
	            while(!st.isEmpty()) {
	                res[size-1] = st.pop();
	                size--;
	            }
	        } else {
	            return new int[]{};
	        }
	        return res;
	    }

}
