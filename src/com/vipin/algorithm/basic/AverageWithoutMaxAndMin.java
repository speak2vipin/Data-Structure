package com.vipin.algorithm.basic;

public class AverageWithoutMaxAndMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int salray[] = {4000,3000,2111,2000};
		AverageWithoutMaxAndMin a = new AverageWithoutMaxAndMin();
		System.out.println(a.average(salray));
	}
	
	public double average(int[] salary) {
        int l = salary.length;
        int total = 0;
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = Integer.MIN_VALUE;
        for(int s : salary) {
            minSalary = Math.min(minSalary, s);
            maxSalary = Math.max(maxSalary, s);
            total += s;
        }
        total = total - minSalary - maxSalary;
        
        return (double)total/(double)(7);

    }

}
