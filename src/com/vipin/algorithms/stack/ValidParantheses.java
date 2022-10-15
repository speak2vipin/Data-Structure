package com.vipin.algorithms.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ValidParantheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("{[()]}"));
		String words[] ={"abcd","dcba","lls","s","sssll"};
		System.out.println(palindromePairs(words));
	}

	public static int solve(String A) {
		int len = A.length();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < len; i++) {
			char tempPush = A.charAt(i);
			if (tempPush == '(' || tempPush == '[' || tempPush == '{') {
				stack.push(tempPush);
			} else {
				if (!stack.isEmpty()) {
					char tempPop = stack.pop();
					if (tempPush == ')' && tempPop == '(') {
						continue;
					} else if (tempPush == ']' && tempPop == '[') {
						continue;
					} else if (tempPush == '}' && tempPop == '{') {
						continue;
					} else {
						return 0;
					}
				} else {
					return 0;
				}
			}
		}
		if (stack.isEmpty()) {
			return 1;
		}
		return 0;
	}

	public static List<List<Integer>> palindromePairs(String[] words) {
		int N = words.length;
		StringBuilder sb = new StringBuilder();
		sb.insert(0,"R");
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < N; i++) {
			map.put(words[i], i);
		}
		for (int i = 0; i < N; i++) {
			String word = words[i];
			for (int j = 0; j < word.length(); j++) {
				String wordSubString1 = word.substring(0, j);
				String wordSubString2 = word.substring(j);
				if (isPalindrome(wordSubString1)) {
					String tempWordSubString2 = new StringBuilder(wordSubString2).reverse().toString();
					if (map.keySet().contains(tempWordSubString2) && map.get(tempWordSubString2) != i) {
						List<Integer> temp = new ArrayList<Integer>();
						temp.add(i);
						temp.add(map.get(tempWordSubString2));
						result.add(temp);
					}
				}

				if (isPalindrome(wordSubString2)) {
					String tempWordSubString1 = new StringBuilder(wordSubString1).reverse().toString();
					if (map.keySet().contains(tempWordSubString1) && map.get(tempWordSubString1) != i) {
						List<Integer> temp = new ArrayList<Integer>();
						temp.add(i);
						temp.add(map.get(tempWordSubString1));
						result.add(temp);
					}
				}
			}
		}
		return result;
	}

	static boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;
	}

}
