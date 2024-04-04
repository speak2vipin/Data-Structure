package com.vipin.algorithm.multithreading;

// Monitor
	// A critical section or shared resource
	// Here shared resoiurce is t object
	// wait is like -> Putting this thread on wait 
	// that too that thread is not having hold on that monitor.
	// Similarly notify means waking an another thread that too without holding the current monitor 
	// as how that thread will come back for it's execution
public class TwoThreadsPrintingOddAndEvenNumber {
	int count = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoThreadsPrintingOddAndEvenNumber t = new TwoThreadsPrintingOddAndEvenNumber();
		Thread t1 = new Thread() {
			public void run() {
				t.printOddNumber(100);
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				t.printEvenNumber(100);
			}
		};
		t1.start();
		t2.start();

	}

	void printEvenNumber(int N) {
		synchronized (this) {
			try {
				while (count < N) {
					if (count % 2 != 0) {
						wait();
					}
					System.out.println("Even Number " + count);
					notify();
					count++;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	void printOddNumber(int N) {
		synchronized (this) {
			try {
				while (count < N) {
					if (count % 2 == 0) {
						wait();
					}
					System.out.println("Odd Number " + count);
					count++;
					notify();
					
				}
			} catch (Exception  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
