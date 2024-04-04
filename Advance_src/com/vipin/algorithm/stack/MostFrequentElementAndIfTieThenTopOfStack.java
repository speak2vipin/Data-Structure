package com.vipin.algorithm.stack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class MostFrequentElementAndIfTieThenTopOfStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[][] = { { 1,2},{1,3},{2,0},{2,0},{1,5},{1,5},{1,1},{2,0},{1,6 } };
		for (int x : solve(A)) {
			System.out.println(x);
		}
		int B[] = {-46,-34,-46};
				
		int k = 3; 
		int x = 3;
		for(int temp : getSubarrayBeauty(B, k, x)) {
			System.out.println(temp);
		}
		
	}

	public static int[] solve(int[][] A) {
		/*PriorityQueue<Stack<Integer>> maxHeap = new PriorityQueue<>(new Comparator<Stack<Integer>>() {

			@Override
			public int compare(Stack<Integer> s1, Stack<Integer> s2) {
				int size1 = s1.size();
				int size2 = s2.size();
				int top1 = s1.peek();
				int top2 = s2.peek();
				return size1 == size2 ? top2 - top1 : size2 - size1;
			}

		});
		int N = A.length;
		int ans[] = new int[N];
		Map<Integer, Stack<Integer>> map = new HashMap<>();
		int index = 0;
		for (int a[] : A) {
			int tempAns = -1;
			if (a[0] == 1) {
				map.computeIfAbsent(a[1], val -> new Stack<Integer>()).push(index);
				// maxHeap.offer(map.get(a[1]));
			} else {
				maxHeap.clear();
				for (Integer s : map.keySet()) {
					maxHeap.offer(map.get(s));
				}
				Stack<Integer> top = maxHeap.poll();
				tempAns = A[top.pop()][1];
				if(top.isEmpty()) {
					map.remove(map)
				}
			}
			ans[index] = tempAns;
			index++;
		}
		return ans;*/
		
		int N = A.length;
		int ans[] = new int[N];
		int index = 0;
		HashMap<Integer, Integer> freq = new HashMap<>();
		HashMap<Integer, Stack<Integer>> stackHM = new HashMap<>();
		for(int a[] : A) {
			int val = -1;
			if(a[0]==1) {
				insert(freq, a[1], stackHM);
			} else {
				val = pop(freq, stackHM);
			}
			ans[index++] = val;
		}
		return ans;
	}
	static int maxCount = 0;
	static int insert(HashMap<Integer, Integer> freq, int number, HashMap<Integer, Stack<Integer>> stackHM) {
		freq.put(number, freq.getOrDefault(number, 0)+1);
		int frequency = freq.get(number);
		if(stackHM.containsKey(frequency)) {
			Stack<Integer> top = stackHM.get(frequency);
			top.push(number);
			stackHM.put(frequency, top);
		} else {
			Stack<Integer> st = new Stack<>();
			st.push(number);
			stackHM.put(frequency, st);
			maxCount++;
		}
		return -1;
	}
	
	static int pop(HashMap<Integer, Integer> freq, HashMap<Integer, Stack<Integer>> stackHM) {
		Stack<Integer> top = stackHM.get(maxCount);
		int val = top.pop();
		if(top.isEmpty()) {
			stackHM.remove(maxCount);
			maxCount--;
		} else {
			stackHM.put(maxCount, top);
		}
		int count = freq.get(val);
		if(count==1) {
			freq.remove(val);
		} else {
			freq.put(val, count-1);
		}
		return val;
	}
	
public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        
       
        Map<Integer, Integer> treeMap = new TreeMap<>();
        int N = nums.length;
        int len = N - k + 1;
        int ans[] = new int[len];
        
        for(int i=0; i<k; i++) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i],0)+1);
        }
        int index = 0; //[1, -1, -3, -2, 3]
        Set<Integer> set = treeMap.keySet();
        List<Integer> list = new ArrayList<Integer>(set);
        ans[index++] = list.get(x-1);
        for(int i=k; i<N; i++) {
            int val = treeMap.get(nums[i-k]);
            if(val==1) {
                treeMap.remove(nums[i-k]);
            } else {
                treeMap.put(nums[i-k], val-1);
            }
            
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i],0)+1);
            set = treeMap.keySet();
            list = new ArrayList<Integer>(set);
            
            ans[index++] = list.get(x-1);
        }
        return ans;
    }

}


// Logic
    // Intution Sliding window
    // Take a initial window of k size, count the vowels
        // Evaluate ans = Math.max(ans, count)
    // If i-k character is vowel reduce count
    // if i character is vowel increase count
        // Evaluate ans = Math.max(ans, count)
    // Return ans

class Solution1 {

int ans = 0;
public int maxVowels(String s, int k) {
    int N = s.length();
    int count = 0;
 
    for(int i=0; i<N; i++) {
        if(i<k) {
        	count += isVowel(s.charAt(i)) ? 1 : 0 ;
        } else {
        	count -= isVowel(s.charAt(i-k)) ? 1 : 0 ;
            count += isVowel(s.charAt(i)) ? 1 : 0 ;
        }
        ans = Math.max(ans, count);
    }
    return ans;
}

boolean isVowel(char character) {
    return 
        character=='a' || character=='i' || character== 'o' || 
        character=='u' || character=='e';
}
}


class Solution {

    // Ban the candidate "toBan", immediate next to "startAt"
    public void ban(String senate, boolean[] banned, char toBan, int startAt) {
        // Find the next eligible candidate to ban
        int pointer = startAt;
        while (true) {
            if (senate.charAt(pointer) == toBan && !banned[pointer]) {
                banned[pointer] = true;
                break;
            }
            pointer = (pointer + 1) % senate.length();
        }
    }

    public String predictPartyVictory(String senate) {

        // To mark Banned Senators
        boolean[] banned = new boolean[senate.length()];

        // Count of Each Type of Senator who are not-banned
        int rCount = 0, dCount = 0;
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                rCount++;
            } else {
                dCount++;
            }
        }

        // Turn of Senator at this Index
        int turn = 0;

        // While both parties have at least one senator
        while (rCount > 0 && dCount > 0) {

            if (!banned[turn]) {
                if (senate.charAt(turn) == 'R') {
                    ban(senate, banned, 'D', (turn + 1) % senate.length());
                    dCount--;
                } else {
                    ban(senate, banned, 'R', (turn + 1) % senate.length());
                    rCount--;
                }
            }

            turn = (turn + 1) % senate.length();
        }

        return dCount == 0 ? "Radiant" : "Dire";
    }
}