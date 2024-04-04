package com.vipin.algorithm.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

import org.w3c.dom.css.Counter;

public class OddAndEvenNumberPrintByTwoThreads {

	int counter = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OddAndEvenNumberPrintByTwoThreads o = new OddAndEvenNumberPrintByTwoThreads();
		Runnable print1 = new Runnable() {
			@Override
			public void run() {
				try {
					o.printOddNumber();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Runnable print2 = new Runnable() {
			@Override
			public void run() {
				try {
					o.printEvenNumber();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread t1 = new Thread(print1);
		Thread t2 = new Thread(print2);
		t1.start();
		t2.start();
	}

	void printOddNumber() throws InterruptedException {
		synchronized (this) {
			while (counter < 101) {
				if (counter % 2 == 0) {
					wait();
				}
				System.out.println(Thread.currentThread().getName() + " " + counter++);
				notify();
			}
		}
	}

	void printEvenNumber() throws InterruptedException {
		synchronized (this) {
			while (counter < 101) {
				if (counter % 2 != 0) {
					wait();
				}
				System.out.println(Thread.currentThread().getName() + " " + counter++);
				notify();
			}
		}
	}

}
