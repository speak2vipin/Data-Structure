package com.vipin.java8.methodreference;

import java.util.*;
public class UniqueNameNamdIdJava8 {

	
	public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 1001));
        employees.add(new Employee("Alice", 1002));
        employees.add(new Employee("Bob", 1003));
        employees.add(new Employee("John", 1001)); // Duplicate
        employees.add(new Employee("Alice", 1004));

        boolean hasDuplicates = hasDuplicateNameAndId(employees);
        
        System.out.println("Does the list have duplicates based on name and employee ID? " + hasDuplicates);
    }

    public static boolean hasDuplicateNameAndId(List<Employee> employees) {
        Set<String> seen = new HashSet<>();
        return employees.stream()
                .anyMatch(e -> !seen.add(e.getName() + ":" + e.getEmployeeId()));
    }

    static class Employee {
        private String name;
        private int employeeId;

        public Employee(String name, int employeeId) {
            this.name = name;
            this.employeeId = employeeId;
        }

        public String getName() {
            return name;
        }

        public int getEmployeeId() {
            return employeeId;
        }
    }

}


