package com.vipin.algorithm.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class ImplementStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementStack i = new ImplementStack();
		i.push(2);
		i.push(3);
		System.out.println(i.getMin());
		System.out.println(i.getMin());
		Stack<Integer> st = new Stack<>();
		MyCat c= new MyCat();
		System.out.println(MyCat.noOfLegs);
		MyCat.noOfLegs = 100;
		System.out.println(MyCat.noOfLegs);
		System.out.println();
		List<Integer>l = new ArrayList<>();
		l.add(20);
		l.remove(new Integer(21));
		System.out.println(l);
		
		

	}

	ArrayList<Integer> list = new ArrayList<>();
	ArrayList<Integer> minList = new ArrayList<>();

	public void push(int x) {

		list.add(x);
		minAdd(x);
	}

	public void pop() {
		int size = list.size();
		if (size == 0) {

		} else {
			Integer poppedElement = list.get(size - 1);
			list.remove(size - 1);
			minList.remove(poppedElement);
		}
	}

	public int top() {
		int size = list.size();
		if (size == 0) {
			return -1;
		}
		return list.get(size - 1);
	}

	public int getMin() {
		return minList.isEmpty() ? -1 : minList.get(0);
	}

	public void minAdd(int i) {
		if (minList.isEmpty()) {
			minList.add(i);
		} else {
			int j = 0;
			while (j < minList.size()) {
				if (minList.get(j) < i)
					j++;

				else {
					minList.add(j, i);
					break;
				}
			}
		}
	}
}

interface Animal extends Runnable {
	void run();
	void walk();
	void eat();
	default int print() {
		return 1;
	}
	default int sound() {
		return 1;
	}
}

abstract class Cat  {
	
}

class MyCat extends Cat {
	//Cat c = new MyCat();
	static int noOfLegs = 10;
}
