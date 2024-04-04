package com.vipin.algorithm.array;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddAndMinusKToMakeLesserDifference implements Cloneable, Serializable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {6,1, 9, 1, 1, 7, 9, 5, 2, 10};
		int b = 4;
		int n=10;
		System.out.println(getMinDiff(a, n,  b));
	}
	
	static int getMinDiff(int[] arr, int n, int k) {
        // code here
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        List<List<String>> in = new ArrayList<>();
        String input[] = in.get(0).get(1).split(":");
        for(int i=0; i<n; i++) {
            if(arr[i]<k) {
                max = Math.max(max, arr[i]+k);
                min = Math.min(min, arr[i]+k);
            } 
        }
        for(int i=0; i<n; i++) {
            if(arr[i]>=k) {
                int add = arr[i] + k;
                int minus = arr[i] - k;
                if(add>=min && add<=max) {
                    
                } else if(minus>=min && minus<=max) {
                    
                } else if(minus<min) {
                    if(max-minus<=add-min) {
                        min = minus;
                    } else {
                        max = add;
                    }
                } else if(minus>max) {
                    max = minus;
                }
            } 
        }
        return max-min;
    }

}

