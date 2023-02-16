package com.vipin.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class FindSubsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer>a = new ArrayList<Integer>();
		a.add(25);
		a.add(20);
		a.add(21);
		FindSubsets f= new FindSubsets();
		//System.out.println(f.subsets(a));
		System.out.println(f.subsetsNew(a));

	}
	
	ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
    int N = 0;
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        N = A.size();
        Collections.sort(A);
        helper(0, A, new ArrayList<Integer>());
        
        Collections.sort(subsets, (ArrayList < Integer > first, ArrayList < Integer > second) -> {
            for (int i = 0; i < first.size() && i < second.size(); i++) {
                if (first.get(i) < second.get(i))
                    return -1;
                if (first.get(i) > second.get(i))
                    return 1;
            }
            if (first.size() > second.size())
                return 1;
            return -1;
        });
        
        Collections.sort(subsets, (ArrayList<Integer> X, ArrayList<Integer>Y) -> {
        for(int i=0; i<X.size() && i<Y.size(); i++) {
            if(X.get(i)>Y.get(i)) {
                return 1;
            } 
            if(Y.get(i)>X.get(i)) {
                return -1;
            }
        }
            if(X.size()>Y.size()) {
                return 1;
            }
            return -1;
        });
        return subsets;
    }

    void helper(int index, ArrayList<Integer> A, ArrayList<Integer> subset) {
        if(index==N) {
        	ArrayList<Integer> temp = new ArrayList<Integer>();
        	temp.addAll(subset);
            subsets.add(temp);
            return ;
        }
        subset.add(A.get(index));
        helper(index+1, A, subset);
        int size = subset.size();
        subset.remove(size-1);
        helper(index+1, A, subset);

    }
    
    public ArrayList<ArrayList<Integer>> subsetsNew(ArrayList<Integer> A) {
        int n = A.size();
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> sub = new ArrayList<>();
       
        for (int i = 0; i < (1<<n) ; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for ( int j =0; j < n; j++) {
                if (checkbit(i,j)) {
                    temp.add(A.get(j));
                }
            }
            sub.add(temp);
        }
       
        Collections.sort(sub, (ArrayList < Integer > first, ArrayList < Integer > second) -> {
            for (int i = 0; i < first.size() && i < second.size(); i++) {
                if (first.get(i) < second.get(i))
                    return -1;
                if (first.get(i) > second.get(i))
                    return 1;
            }
            if (first.size() > second.size())
                return 1;
            return -1;
        });
       
   
        return sub;
    }
    public boolean checkbit(int A, int i) {
    	System.out.println(A+" "+((1<<i)));
    	//System.out.println(A & (1<<i));
        return ((A & (1<<i)) != 0);
    }

}
