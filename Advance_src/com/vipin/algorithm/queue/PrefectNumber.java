package com.vipin.algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

public class PrefectNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(solve(5));
		System.out.println(solve(10));
		System.out.println(solveq(4));
	}

	public static String solve(int A) {
		if (A == 1 || A == 2) {
			return "" + A;
		} else if (A == 3) {
			return "11";
		} else if (A == 4) {
			return "22";
		}
		Queue<String> qe = new LinkedList<String>();
		qe.add("11");
		qe.add("22");

		int i = 4;
		int len;
		int temp;
		String front;
		for (int j = 4; j < A + 1; j++) {
			front = qe.peek();
			len = front.length();
			temp = Integer.parseInt(front.substring(len - 2)) * 100 + 11;
			front = front.substring(0, len - 2) + "" + temp;
			i++;
			if (i == A) {
				qe.clear();
				return front;
			}
			qe.add(front);

			front = qe.peek();
			len = front.length();
			temp = Integer.parseInt(front.substring(len - 2)) * 100 + 22;
			front = front.substring(0, len - 2) + "" + temp;
			i++;
			if (i == A) {
				qe.clear();
				return front;
			}
			qe.add(front);
			qe.remove();
		}
		return null;
	}

	public static String solveq(int A) {
		Queue<Long> qe = new LinkedList<Long>();
		qe.add(1l);
		qe.add(2l);
		long front = 0;
		long temp1;
		long temp2;
		for (int j = 0; j < A; j++) {
			front = qe.peek();
			temp1 = front * 10 + 1;
			temp2 = front * 10 + 2;
			qe.add(temp1);
			qe.add(temp2);
			qe.remove();
		}
		StringBuilder sb = new StringBuilder(front + "");
		String temp = sb.toString();
		sb.append(new StringBuilder(temp).reverse());
		return sb.toString();
	}

}
