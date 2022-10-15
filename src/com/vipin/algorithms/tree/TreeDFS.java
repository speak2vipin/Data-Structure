package com.vipin.algorithms.tree;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeDFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int in[][] = {{5,5},{6,6},{3,6}, {5,6}};
		System.out.println(numberOfWeakCharacters(in));

	}
	
	public static int numberOfWeakCharacters(int[][] properties) {
		int n = properties.length;
        int count = 0;
        // Sort in decreasing order of properties[0]  and increasing order of properties[1]
        Arrays.sort(properties, (a, b) -> (b[0] == a[0]) ? (a[1] - b[1]) : b[0] - a[0]);
        
        int max = 0;
        for (int i = 0; i < n; i++) {
        // if properties[i][0] and properties[i+1][0] are equal than properties[i][1] will be in increasing order so below condition won't be true.    
            if (properties[i][1] < max) {
                count++;
            }
            max = Math.max(max, properties[i][1]);
        }
        return count;
    }

}
