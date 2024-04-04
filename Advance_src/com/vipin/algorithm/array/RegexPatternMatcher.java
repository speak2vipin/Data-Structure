package com.vipin.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.regex.Pattern;

public class RegexPatternMatcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "manyata_test2+61@outlook.com";
		String USER_EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		Pattern pattern = Pattern.compile(USER_EMAIL);
		System.out.println(pattern.matcher(s).matches());
		System.out.println(s.matches(USER_EMAIL));

		int i[][] = { { -2147483646, -2147483645 }, { 2147483646, 2147483647 } };
		findMinArrowShots(i);
		String test = "aabcaba";
		System.out.println(minimumDeletions(test, 0));
		
		char tasks[] = {'A','A','A','B','B','B'};
		int n = 2;
		System.out.println(leastInterval(tasks, n));

	}

	public static int findMinArrowShots(int[][] points) {
		// Arrays.sort(points, (x, y) -> x[1] - y[1]);
		Arrays.sort(points, (x, y) -> Integer.compare(x[1], y[1]));

		int arrows = 1;
		// int st = points[0][0];
		// int en = points[0][1];
		int n = points.length;
		int window[] = points[0];
		for (int i = 1; i < n; i++) {
			if (isOverlapped(window, points[i])) {
				window[0] = Math.max(window[0], points[i][0]);
				window[1] = Math.min(window[1], points[i][1]);
			} else {
				arrows++;
				window = points[i];
			}
		}
		return arrows;
	}

	static boolean isOverlapped(int p1[], int p2[]) {
		// return (Math.min(p1[1], p2[1]) - Math.max(p1[0], p2[0])) >= 0;
		return p2[0] <= p1[1];
	}

	public static int minimumDeletions(String word, int k) {

		int freq[] = new int[26];
		int n = word.length();
		int max = 0;
		for (int i = 0; i < n; i++) {
			freq[word.charAt(i) - 'a']++;
			max = Math.max(max, freq[word.charAt(i) - 'a']);
		}
		System.out.println(max);
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (max - freq[i] > k) {  // 10 - 
				count += max - freq[i];
			}
		}
		return count;
	}
	
	public static int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        for(char t : tasks) {
            freq[t-'A']++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int f : freq) {
            if(f!=0) {
                pq.offer(f);
            }
        }
        int count = 0;
        while(!pq.isEmpty()) {
            int cycle = n + 1;
            List<Integer> reprocess = new ArrayList<>();
            int time = 0;
            while(!pq.isEmpty() && cycle>0) {
                int top = pq.poll();
                reprocess.add(top-1);
                time++;
                cycle--;
            }
            for(Integer f : reprocess) {
                if(f>0) {
                    pq.offer(f);
                }
            }
            count += pq.isEmpty()?time:n+1;
        }
        return count;
        
    }
}
