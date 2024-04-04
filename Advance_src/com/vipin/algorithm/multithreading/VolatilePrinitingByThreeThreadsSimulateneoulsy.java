package com.vipin.algorithm.multithreading;

import org.w3c.dom.css.Counter;

public class VolatilePrinitingByThreeThreadsSimulateneoulsy {
	private static volatile int counter = 0;

	public static void main(String[] args) {
		// TODO

		VolatilePrinitingByThreeThreadsSimulateneoulsy o = new VolatilePrinitingByThreeThreadsSimulateneoulsy();
		Runnable print1 = new Runnable() {
			@Override
			public void run() {
				
			}
		};

		Runnable print2 = new Runnable() {
			@Override
			public void run() {
				
			}
		};
		Thread t1 = new Thread(print1);
		Thread t2 = new Thread(print2);
		t1.start();
		t2.start();
	}
}
