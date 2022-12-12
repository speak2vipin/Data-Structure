package com.vipin.algorithm.string;

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(decodeStringLeetCodeSolution("100[leetcode]"));
	}

	public static String decodeString(String s) {
		while (s.lastIndexOf('[') != -1) {
			int i = s.lastIndexOf('[');
			int count = 0;
			char c = s.charAt(i - 1);
			int tempCount = 0;

			while (c > 47 && c < 58) {

				tempCount += (c - '0') * Math.pow(10, count);
				count++;
				if (i - 1 - count > -1)
					c = s.charAt(i - 1 - count);
				else
					break;
			}
			int k = i + mod(s.substring(i + 1));
			s = s.substring(0, i - count) + recurString(s.substring(i + 1, k), tempCount, "") + s.substring(k + 1);
		}
		return s;
	}

	static String recurString(String s, int A, String temp) {
		if (A == 1) {
			return temp + s;
		}
		return recurString(s, A - 1, temp + s);
	}

	static int mod(String s) {
		int i = 0;
		while (s.charAt(i) != ']') {
			i++;
		}
		return i + 1;
	}

	public static String decodeStringLeetCodeSolution(String s) {
		Deque<Character> queue = new LinkedList<>();
		for (char c : s.toCharArray())
			queue.offer(c);
		return helper(queue);
	}

	public static String helper(Deque<Character> queue) {
		StringBuilder sb = new StringBuilder();
		int num = 0;
		while (!queue.isEmpty()) {
			char c = queue.poll();
			if (Character.isDigit(c)) {
				num = num * 10 + c - '0';
			} else if (c == '[') {
				String sub = helper(queue);
				for (int i = 0; i < num; i++)
					sb.append(sub);
				num = 0;
			} else if (c == ']') {
				break;
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
