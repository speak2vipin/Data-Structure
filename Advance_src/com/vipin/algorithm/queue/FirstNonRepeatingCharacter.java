package com.vipin.algorithm.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("abadbc"));
		System.out.println(solve("abcabc"));
		System.out.println(solve("iergxwhddh"));


	}

	public static String solve(String A) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Queue<Character> queue = new LinkedList<Character>();
		int N = A.length();
		StringBuilder ans = new StringBuilder();
		char temp = A.charAt(0);
		queue.add(temp);
		map.put(temp, 1);
		ans.append(queue.peek());
		for (int i = 1; i < N; i++) {
			temp = A.charAt(i);
			if (map.get(temp) == null) {
				queue.add(temp);
			} 
			map.put(temp, map.getOrDefault(temp, 0) + 1);
			while(!queue.isEmpty() && map.get(queue.peek())>1)	{
				queue.remove();
			}
			if(queue.isEmpty()) {
				ans.append('#');
			} else {
				ans.append(queue.peek());
			}		
		}
		queue.clear();

		return ans.toString();
	}

}
