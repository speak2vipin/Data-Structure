package com.vipin.algorithm.heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;


public class SpecialMedians {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 4, 6, 8, 4 };
		SpecialMedians s = new SpecialMedians();
		// System.out.println(s.solve(A));
		// System.out.println(s.findTheLongestBalancedSubstring("00101"));
	}

	PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
	PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());

	public double add(int val) {
		double ans = 0;
		if (maxHeap.size() == 0) {
			maxHeap.offer(val);
		} else if (maxHeap.peek() < val) {
			maxHeap.offer(val);
		} else {
			minHeap.offer(val);
		}

		int diff = Math.abs(minHeap.size() - maxHeap.size());
		if (diff > 1) {
			if (maxHeap.size() > minHeap.size()) {
				minHeap.offer(maxHeap.poll());
			} else {
				maxHeap.offer(minHeap.poll());
			}
		}

		if (maxHeap.size() > minHeap.size()) {
			ans = maxHeap.peek();
		} else if (minHeap.size() > maxHeap.size()) {
			ans = minHeap.peek();
		} else {
			ans = (minHeap.peek() + maxHeap.peek()) / 2.0;
		}

		return (double) ans;
	}

	public int solve(int[] A) {
		int n = A.length;
		for (int i = 1; i < n; i++) {
			double ans = add(A[i - 1]);
			if (ans == (double) A[i]) {
				return 1;
			}
		}

		this.maxHeap.clear();
		this.minHeap.clear();

		for (int i = n - 2; i >= 0; i--) {
			double ans = add(A[i + 1]);
			if (ans == (double) A[i]) {
				return 1;
			}
		}
		return 0;
	}

	public int findTheLongestBalancedSubstring(String s) {
		int l = s.length();
		int i = 0;
		int ans = Integer.MIN_VALUE;
		int zero = 0;
		int one = 0;
		int tempAns = 0; // 01000111
		while (i < l) {
			char temp = s.charAt(i);
			if (temp == '0') {
				if (one != 0) {
					one = 0;
					zero = 0;
				}
				zero++;
			} else {
				if (zero == 0) {
					// continue;
				} else {
					one++;
					tempAns = Math.min(zero, one);
					ans = Math.max(ans, tempAns);
				}
			}
			i++;
		}

		return ans * 2;
	}

	

	
	
	
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
      
    	int n = spells.length;
        int m = potions.length;
        
        // Create an array of pairs containing spell and its original index
        int[][] sortedSpells = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedSpells[i][0] = spells[i];
            sortedSpells[i][1] = i;
        }
        
        // Sort the 'spells with index' and 'potions' array in increasing order
        Arrays.sort(sortedSpells, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(potions);
        
        // For each 'spell' find the respective 'minPotion' index
        int[] answer = new int[n];
        int potionIndex = m - 1;

        for (int[] sortedSpell : sortedSpells) {
            int spell = sortedSpell[0];
            int index = sortedSpell[1];
            
            while (potionIndex >= 0 && (long) spell * potions[potionIndex] >= success) {
                potionIndex -= 1;
            }
            answer[index] = m - (potionIndex + 1);
        }
        
        return answer;
    }
}
    





class Solution2 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        
        // Create an array of pairs containing spell and its original index
        int[][] sortedSpells = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedSpells[i][0] = spells[i];
            sortedSpells[i][1] = i;
        }
        
        // Sort the 'spells with index' and 'potions' array in increasing order
        Arrays.sort(sortedSpells, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(potions);
        
        // For each 'spell' find the respective 'minPotion' index
        int[] answer = new int[n];
        int potionIndex = m - 1;

        for (int[] sortedSpell : sortedSpells) {
            int spell = sortedSpell[0];
            int index = sortedSpell[1];
            
            while (potionIndex >= 0 && (long) spell * potions[potionIndex] >= success) {
                potionIndex -= 1;
            }
            answer[index] = m - (potionIndex + 1);
        }
        
        return answer;
    }
}











