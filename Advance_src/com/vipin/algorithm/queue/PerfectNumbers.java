package com.vipin.algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PerfectNumbers p = new PerfectNumbers();
		System.out.println(p.solve(2));

	}

	public String solve(int A) {

		Queue<Long> qe = new LinkedList<Long>();
		qe.add(1l);
		qe.add(2l);
		long front = 0;
		long temp1;
		long temp2;
		for (int j = 0; j < A; j++) {
			// TAKE CARE OF BELOW LINE
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
