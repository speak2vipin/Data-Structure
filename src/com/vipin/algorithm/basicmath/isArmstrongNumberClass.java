package com.vipin.algorithm.basicmath;

import java.util.Scanner;

public class isArmstrongNumberClass {

	public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scanner =  new Scanner(System.in);
        int input = scanner.nextInt();
        for(int i = 1; i<=input; i++) {
            isArmstrongNumber(i);
        }
        
        Scanner scanner11 =new Scanner(System.in);
        int input = scanner.nextInt();
        for(int i=1; i<=10;i++) {
            System.out.println("input * " + i " " + "= "+ (input*i));
        }
        
    }

    static void isArmstrongNumber(int x) {
        int sum = 0;
        int temp = 0;
        int tempX = x;
        while(tempX!=0) {
            temp = tempX%10;
            sum += temp*temp*temp;
            tempX = tempX/10;
        }
        if(sum==x) {
            System.out.println(x);
        }
    }
}
