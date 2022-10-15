package com.vipin.algorithms.array;
import java.util.*;
public class SortArrayMinimumSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer>A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(4);
		A.add(0);
		System.out.println(solve(A));
	}
	
	public static int solve(ArrayList<Integer> A) {
        int size = A.size();
        int count = 0;
        for(int i=0; i<size; i++) {
            if(A.get(i)!=i) {
                swap(A, i);
                count++;
            }
        }
        return count;
    }
	static void swap(ArrayList<Integer> A, int i, int j) {
		A.set(A.get(i), null)
        A.set(i, i);
    }
	
	

}
