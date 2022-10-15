package com.vipin.algorithms.basicmath;

import java.util.Scanner;

public class isPerfectNumberClass {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int input;
        for(int i = 0;i<count;i++) {
            input = scanner.nextInt();
            System.out.println(isPerfectNumber(input));
        }
        
    }
    static String isPerfectNumber(int x) {
        int sum = 0;
        for(int i=1;i*i<=x;i++) {
            if(x%i==0) {
                sum+=i;
            }
        }
        return x==sum?"YES":"NO";
    }
}