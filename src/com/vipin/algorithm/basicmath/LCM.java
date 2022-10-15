package com.vipin.algorithm.basicmath;

import java.lang.*;
import java.util.*;

public class LCM {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=1;i<=T;i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int gcf = GCF(x,y);
            int lcm = (x*y)/gcf;
            System.out.println(lcm);
        }
        
    }

    static int GCF(int x, int y) {
        if(x==0) {
            return y;
        }
        return GCF(y%x, x);
    }
}
