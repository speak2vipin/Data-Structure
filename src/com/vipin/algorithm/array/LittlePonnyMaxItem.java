package com.vipin.algorithm.array;

import java.util.Arrays;

/**
 * A = [2, 4, 3, 1, 5], B = 3 
 * U need to remove 4 and 5. If element doesn't exist i.e. 3 then return -1
 * @author vipingupta
 *
 */

public class LittlePonnyMaxItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(int[] A, int B) {
        Arrays.sort(A);
        boolean flagIsElement = false;
        int count = 0;
        for(int i=0; i<A.length;i++) {
            if(A[i]<B) {
                continue;
            } else if(A[i]==B) {
                flagIsElement = true;
            } else {
                if(flagIsElement) {
                    count++;
                } else {
                    return -1;
                }
            }
        }
    return count;
    }

}
