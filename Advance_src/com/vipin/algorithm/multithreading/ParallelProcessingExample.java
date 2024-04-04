package com.vipin.algorithm.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ParallelProcessingExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Create a ThreadPoolExecutor with a fixed number of threads
		int numberOfThreads = 4;
		ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

		// Create a list of tasks to be executed in parallel
		List<Callable<Integer>> tasks = new ArrayList<>();
		tasks.add(() -> computeTask(1));
		tasks.add(() -> computeTask(2));
		tasks.add(() -> computeTask(3));
		tasks.add(() -> computeTask(4));

		// Invoke all tasks and obtain the results
		List<Future<Integer>> results = executorService.invokeAll(tasks);

		// Process the results
		for (Future<Integer> result : results) {
			// Get the result of each task
			int taskResult = result.get();
			System.out.println("Task result: " + taskResult);
		}

		// Shutdown the executor service
		executorService.shutdown();
	}

	private static int computeTask(int taskId) {
		// Perform some computation for the task
		System.out.println("Task " + taskId + " started");
		try {
			// Simulate some time-consuming computation
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Task " + taskId + " completed");
		return taskId;
	}

}
