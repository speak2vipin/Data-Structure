package com.vipin.algorithm.queue;

import java.util.ArrayList;
import java.util.Stack;

public class ReverseFirstBElementInQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0; i<B; i++) {
            st.push(A.get(i));
        }
        int index = 0;
        while(!st.isEmpty()) {
            A.set(index++, st.pop());
        }
        return A;
    }

}
