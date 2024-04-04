package com.vipin.algorithm.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CalculatingString {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		int numberOfThreads = 8;
		ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
		List<Callable<String>> tasks = new ArrayList<>();
		tasks.add(() -> computeTask('A'));
		tasks.add(() -> computeTask('B'));
		tasks.add(() -> computeTask('C'));
		tasks.add(() -> computeTask('D'));
		
		tasks.add(() -> computeTask('P'));
		tasks.add(() -> computeTask('Q'));
		tasks.add(() -> computeTask('R'));
		tasks.add(() -> computeTask('S'));
		
		List<Future<String>> results = executorService.invokeAll(tasks);
		for (Future<String> result : results) {
			// Get the result of each task
			String taskResult = result.get();
			System.out.println("Task result: " + taskResult);
		}

		// Shutdown the executor service
		executorService.shutdown();
	
	}
	
	private static String computeTask(char taskId) throws InterruptedException {
		// Perform some computation for the task
		String temp = "";
		System.out.println("Task " + taskId + " started");
		// Simulate some time-consuming computation
		//Thread.sleep(2000);
		while(taskId<91) {
			temp += taskId;
			taskId++;
		}
		//System.out.println("Task " + taskId + " completed");
		return temp;
	}
	
	public int solve(int A) {
        int count = 0;
        int X=1;
        while((A/X)>0) {
            X = X*5;
            count++;
        }
        count--;
        int res = 0;
        while(A>0) {
            int power = (int)Math.pow(5, count);
            int divident = A/(power);
            res += divident;
            A = A - (power*divident);
            count--;
        }
        return res;
    }

}

 class ParallelProcessingExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Perform processing in parallel using Streams
        numbers.parallelStream().forEach(number -> {
            // Perform processing for each element
            System.out.println("Processing element: " + number);
            // ...
        });
    }
}







