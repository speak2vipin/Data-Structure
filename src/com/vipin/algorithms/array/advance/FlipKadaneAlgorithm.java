package com.vipin.algorithms.array.advance;

import java.util.ArrayList;
import java.util.List;

public class FlipKadaneAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		flip("011");

	}
	
	public static int[] flip(String A) {
        int length = A.length();
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<length; i++) {
            if(A.charAt(i)=='0') {
                list.add(1);
            } else {
                list.add(-1);
            }
        }
        int currSum = 0;
        int maxSum = 0;
        int start = 0;
        int end = -1;
        int index = 0;
        for(int i=0; i<length; i++) {
            currSum +=list.get(i);
            if(currSum<0) {
            	currSum = 0;
                index = i+1;
            } else if(currSum > maxSum) {
            	maxSum = currSum;
            	start = index;
                end = i;
            }            
        }
        int result[]= {};
        if(end!=-1) {
        	result = new int[2];
        	result[0] = start + 1;
        	result[1] = end + 1;
        } else {

        }
        return result;
    }

}
