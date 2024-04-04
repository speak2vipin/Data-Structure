package com.vipin.algorithm.graph.BFS;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ExactNoOfSteps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sx = 3;
		int sy = 1;
		int fx = 7;
		int fy = 3;
		int t = 3;
		ExactNoOfSteps e = new ExactNoOfSteps();
		System.out.println(e.isReachableAtTime(sx, sy, fx, fy, t));
	}
	
	Map<int[], Boolean> visit = null;
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int dx[] = {-1, -1, 0, 1, 1,  1,  0, -1};
        int dy[] = { 0 , 1, 1, 1, 0, -1, -1, -1};
        visit = new HashMap<>();
        Queue<int[]> qe = new LinkedList<>();
        qe.offer(new int[] {sx, sy});
        visit.put(new int[] {sx, sy}, true);
        while(!qe.isEmpty() && t>0) {
            t--;
            int size = qe.size();
            for(int i=0; i<size; i++) {
                int top[] = qe.poll();
                if(top[0]==fx && top[1]==fy) {
                    return t==0;
                }
                for(int j=0; j<8; j++) {
                    int newX = top[0] + dx[j];
                    int newY = top[1] + dy[j];
                    if(isValid(newX, newY)) {
                        qe.offer(new int[]{newX, newY});
                    }
                }
            }
        }
        return false;
    }
    
    boolean isValid(int x, int y) {
        return x>0 && y>0 && x<1000_000_001 && y<1000_000_001 && visit.get(new int[] {x, y})==null;
    }
    
    int count = 0;
    public int minDeletions(String s) {
        Map<Character, Integer> freqMap = new HashMap<>(); 
        int freq[] = new int[26];
        int n = s.length();
        int index = 0;
        char c = '\u0000';
        for(int i=0; i<n; i++) {
            c = s.charAt(i);
            index = c-'a';
            freq[index]++;
            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        }
        for(int i=0; i<26; i++) {
            if(freq[i]!=0) {
                nextIndex(i, freq);
            }
        }
        return count;
        
    }
    
    void nextIndex(int index, int freq[]) {
        boolean flag = false;
        for(int i=0; i<26; i++) {
            if(freq[index]!=0 && freq[i]==freq[index]) {
                flag = true;
                break;
            }
        }
        if(flag) {
        	freq[index]--;
            nextIndex(index-1, freq);
            count++;
        }
    }

}
