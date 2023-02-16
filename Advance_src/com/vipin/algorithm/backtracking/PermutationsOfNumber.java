package com.vipin.algorithm.backtracking;

import java.util.ArrayList;

public class PermutationsOfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> A = new ArrayList<Integer> ();
		A.add(1);
		A.add(2);
		A.add(3);
		
		PermutationsOfNumber p = new PermutationsOfNumber();
		System.out.println(p.permute(A));
	}
	
	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    int N = 0;
    ArrayList<Integer> input = null;
    
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        N = A.size();
        input = A;
        boolean vst[] = new boolean[9];
        helper(0, new ArrayList<Integer>(), vst);
        return results;

    }

    void helper(int index, ArrayList<Integer>permutation, boolean vst[]) {
        if(index==N) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(permutation);
            results.add(temp);
            return;
        }
        for(int i=0; i<N; i++) {
            if(!vst[i]) {
                vst[i] = true;
                permutation.add(input.get(i));
                helper(index+1, permutation, vst);
                vst[i] = false;
                int size = permutation.size();
                permutation.remove(size-1);      
            }
        }
    }

}
